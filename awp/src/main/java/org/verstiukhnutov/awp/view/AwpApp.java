package org.verstiukhnutov.awp.view;

import java.io.IOException;

import org.verstiukhnutov.awp.model.*;
import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;
import org.verstiukhnutov.awp.model.error.InvalidManufacturerNameException;
import org.verstiukhnutov.awp.model.error.InvalidProductNameException;
import org.verstiukhnutov.awp.model.error.NoSuchGroupException;
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
    AwpModel model = new AwpModel();
    
    // Screens
    MainScreen mainScreen = new MainScreen(this, model);
    EditGroupScreen editGroupScreen = new EditGroupScreen(this);
    EditProductScreen editProductScreen = new EditProductScreen(this, model);
    ViewGroupScreen viewGroupScreen = new ViewGroupScreen(this, model);

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(1152, 648)
            .position(null)
            .run();
    }

    @Override
    public void init() {
        splashcreen();
    }

    @Override
    public void event(AwpMsg msg) {
        if (msg instanceof NewGroupMsg) {
            setScreen(editGroupScreen.empty());
            return;
        }
        
        if (msg instanceof AddGroupMsg) {
            String groupName = ((TextField) getWidget("group_name_field")).getText();
            String description = ((TextArea) getWidget("group_description_area")).getText();
            Group group = null;

            try {
                group = new Group(new GroupName(groupName), description);
                model.addGroup(group);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Invalid group name:\n", e.getMessage());
                return;
            }

            ((WrapContainer) getWidget("groups")).addFirst(new DisplayGroup(this, group));

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

            try {
                msgSave.displayGroup.update(new GroupName(name), description);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Invalid group name:\n", e.getMessage());
                return;
            }

            setScreen(mainScreen);
            return;
        }

        if (msg instanceof DeleteGroupMsg) {
            DeleteGroupMsg msgDelete = (DeleteGroupMsg) msg;
            Group group = ((DisplayGroup) getWidget(msgDelete.widgetName)).getGroup();
            model.removeGroup(group);

            ((WrapContainer) getWidget("groups")).removeChild(getWidget(msgDelete.widgetName));
            return;
        }

        if (msg instanceof AddProductMsg) {
            if (model.getGroups().isEmpty()) {
                MsgBox.error("No groups", "Please create a group first");
                return;
            }
            setScreen(editProductScreen.empty());
            return;
        }

        if (msg instanceof EditProductMsg) {
            EditProductMsg msgEdit = (EditProductMsg) msg;
            DisplayItem displayProduct = ((DisplayItem) getWidget(msgEdit.widgetName));

            setScreen(editProductScreen.with(
                displayProduct.getProduct(),
                new SaveProductMsg(displayProduct)
            ));
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
            Manufacturer.ManufacturerType manufacturerType = (Manufacturer.ManufacturerType) ((ComboBox) getWidget("manufacturer_type")).getSelectedItem();
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
                product.setGroup(group);
            } catch (InvalidProductNameException | InvalidManufacturerNameException e) {
                MsgBox.error("Invalid product data", e.getMessage());
                return;
            }

            if (isNew) {
                try {
                    model.addProduct(product);
                } catch (NoSuchGroupException e) {
                    MsgBox.error("Invalid group", e.getMessage());
                }
            }

            ((DisplayProducts) getWidget("display_products")).update();
            setScreen(mainScreen);
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
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app", mainScreen);
    }

    private void setScreen(Screen screen) {
        ((CoreWidget) getWidget("my_app")).setChild(screen);
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