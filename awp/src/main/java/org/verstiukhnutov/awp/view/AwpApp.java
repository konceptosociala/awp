package org.verstiukhnutov.awp.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.verstiukhnutov.awp.model.*;
import org.verstiukhnutov.awp.model.Manufacturer.ManufacturerType;
import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;
import org.verstiukhnutov.awp.model.error.InvalidManufacturerNameException;
import org.verstiukhnutov.awp.model.error.InvalidProductNameException;
import org.verstiukhnutov.awp.model.error.InvalidSearchPromptException;
import org.verstiukhnutov.awp.model.search.SearchPattern;
import org.verstiukhnutov.awp.msg.*;
import org.verstiukhnutov.awp.view.screens.*;
import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.app.Splashcreen;
import org.verstiukhnutov.swelm.utils.MsgBox;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.*;
import org.verstiukhnutov.awp.view.widgets.*;

public class AwpApp extends ConstructWidget<AwpMsg> {

    // Model
    AwpModel model = AwpModel.fromJson();

    // Screens
    MainScreen mainScreen = new MainScreen(this, model);
    EditGroupScreen editGroupScreen = new EditGroupScreen(this);
    EditProductScreen editProductScreen = new EditProductScreen(this, model);
    ViewGroupScreen viewGroupScreen = new ViewGroupScreen(this, model);
    ViewProductScreen viewProductScreen = new ViewProductScreen(this);

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(1152, 648)
            .position(null)
            .run();
    }

    @Override
    public void init() {
        loadGroups();
        splashcreen();
    }

    @Override
    public void event(AwpMsg msg) {
        if (msg instanceof SearchMsg) {
            String prompt = ((SearchMsg) msg).getPrompt();
            if (prompt.equals("")) return;

            SearchPattern searchPattern;

            try {
                searchPattern = new SearchPattern(prompt);
            } catch (InvalidSearchPromptException e) {
                MsgBox.error("Search error", e.getMessage());
                return;
            }

            AtomicInteger index = new AtomicInteger(0);
            ArrayList<Widget> products = new ArrayList<>();

            for (Product product : model.findProducts(searchPattern)) {
                products.add(new DisplayItem(this, "display_products_display_item_"+product.getName(), product, index.getAndIncrement()));
            }

            ((DisplayProducts) getWidget("display_products")).update(products.toArray(new Widget[0]));
        }

        if (msg instanceof NewGroupMsg) {
            setScreen(editGroupScreen.empty());
            return;
        }
        
        if (msg instanceof AddGroupMsg) {
            String groupName = ((TextField) getWidget("group_name_field")).getText();
            String description = ((TextArea) getWidget("group_description_area")).getText();
            Group group = null;

            try {
                if (model.containsGroup(groupName)) {
                    MsgBox.error("Group error", "Group with such name already exists");
                    return;
                }

                group = new Group(new GroupName(groupName), description);
                model.addGroup(group);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Group error", e.getMessage());
                return;
            }

            ((WrapContainer) getWidget("groups")).addFirst(new DisplayGroup(this, group));

            model.toJson();
            setScreen(mainScreen);
            return;
        }

        if (msg instanceof EditGroupMsg) {
            EditGroupMsg msgEdit = (EditGroupMsg) msg;
            DisplayGroup displayGroup = ((DisplayGroup) getWidget(msgEdit.widgetName));

            setScreen(editGroupScreen.with(
                displayGroup.getGroup().getName().toString(), 
                displayGroup.getGroup().getDescription(), 
                new SaveGroupMsg(displayGroup)
            ));
            return;
        }

        if (msg instanceof SaveGroupMsg) {
            SaveGroupMsg msgSave = (SaveGroupMsg) msg;
            String name = ((TextField) getWidget("group_name_field")).getText();
            String description = ((TextArea) getWidget("group_description_area")).getText();

            if (model.containsGroup(name) && !msgSave.displayGroup.getGroup().getName().toString().equals(name)) {
                MsgBox.error("Group error", "Group with such name already exists");
                return;
            }

            try {
                msgSave.displayGroup.update(new GroupName(name), description);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Invalid group name:\n", e.getMessage());
                return;
            }

            model.toJson();
            setScreen(mainScreen);
            return;
        }

        if (msg instanceof DeleteGroupMsg) {
            DeleteGroupMsg msgDelete = (DeleteGroupMsg) msg;
            Group group = ((DisplayGroup) getWidget(msgDelete.widgetName)).getGroup();
            model.removeGroup(group);

            ((WrapContainer) getWidget("groups")).removeChild(getWidget(msgDelete.widgetName));
            ((DisplayProducts) getWidget("display_products")).update();
            model.toJson();
            return;
        }

        if (msg instanceof AddProductMsg) {
            if (model.getGroups().isEmpty()) {
                MsgBox.error("No groups", "Please create a group first");
                return;
            }
            setScreen(editProductScreen.empty());
            model.toJson();
            return;
        }

        if (msg instanceof EditProductMsg) {
            EditProductMsg msgEdit = (EditProductMsg) msg;
            DisplayItem displayProduct = ((DisplayItem) getWidget(msgEdit.widgetName));

            setScreen(editProductScreen.with(
                displayProduct.getProduct(),
                new SaveProductMsg(displayProduct)
            ));
            model.toJson();
            return;
        }

        if (msg instanceof SaveProductMsg) {
            SaveProductMsg msgSave = (SaveProductMsg) msg;
            DisplayItem displayProduct = msgSave.getDisplayItem();
            Product product;
            boolean isNew = false;

            if (displayProduct == null) {
                isNew = true;
                product = new Product();
            } else {
                product = displayProduct.getProduct();
            }

            String name = ((TextField) getWidget("product_name_field")).getText();
            String description = ((TextArea) getWidget("product_description_area")).getText();
            ManufacturerType manufacturerType = (ManufacturerType)((ComboBox) getWidget("manufacturer_type")).getSelectedItem();
            String manufacturerName = ((TextField) getWidget("manufacturer_name_field")).getText();
            int amount = 0;
            int price = 0;
            try {
                amount = Integer.parseInt(((TextField) getWidget("product_amount_field")).getText());
                price = Integer.parseInt(((TextField) getWidget("product_price_field")).getText());
            } catch (NumberFormatException e) {
                MsgBox.error("Invalid product data", "Amount and price must be integers");
                return;
            }
            Group group = (Group) ((ComboBox) getWidget("product_group")).getSelectedItem();

            try {
                product.setName(new ProductName(name));
                product.setManufacturer(new Manufacturer(manufacturerType, new ManufacturerName(manufacturerName)));
                product.setDescription(description);
                product.setAmount(amount);
                product.setPrice(price);
            } catch (InvalidProductNameException | InvalidManufacturerNameException e) {
                MsgBox.error("Invalid product data", e.getMessage());
                return;
            }

            if (isNew) {
                group.addProduct(product);
            }

            ((DisplayProducts) getWidget("display_products")).update();
            setScreen(mainScreen);
            model.toJson();
            return;
        }

        if (msg instanceof OpenGroupMsg) {
            setScreen(viewGroupScreen.with(((OpenGroupMsg) msg).getGroup()));
            return;
        }

        if (msg instanceof SwitchToMainScreen) {
            setScreen(mainScreen);
            return;
        }

        if (msg instanceof OpenProductMsg) {
            OpenProductMsg openProductMsg = (OpenProductMsg) msg;
            setScreen(viewProductScreen.with(((DisplayItem) getWidget(openProductMsg.widgetName)).getProduct()));
            return;
        }

        if (msg instanceof DeleteProductMsg) {
            DeleteProductMsg deleteProductMsg = (DeleteProductMsg) msg;
            DisplayItem displayProduct = (DisplayItem) getWidget(deleteProductMsg.widgetName);
            model.removeProduct(displayProduct.getProduct());

            ((DisplayProducts) getWidget("display_products")).update();
            model.toJson();
            return;
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app", mainScreen);
    }

    private void setScreen(Screen screen) {
        ((CoreWidget) getWidget("my_app")).setChild(screen);
    }

    private void loadGroups() {
        WrapContainer groups = ((WrapContainer) getWidget("groups"));

        model.getGroups()
            .forEach(g -> groups.addFirst(new DisplayGroup(this, g)));
    }

    private void splashcreen() {
        try {
            new Splashcreen(
                800, 450,
                new ResourceImage(getClass(), "/img/splash.png"),
                100
            ).show();
        } catch (IOException e) {
            MsgBox.error("I/O Error", e.getMessage());
        }
    }
}