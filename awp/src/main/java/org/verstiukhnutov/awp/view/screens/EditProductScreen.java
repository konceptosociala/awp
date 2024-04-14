package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.model.*;
import org.verstiukhnutov.awp.msg.AddProductMsg;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.msg.SaveProductMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.LabeledTextArea;
import org.verstiukhnutov.awp.view.widgets.LabeledTextField;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import java.awt.*;

public class EditProductScreen extends Screen {
    AwpApp app;
    private Product product;
    private AwpModel model;

    AwpMsg onSave;

    @Override
    public void init() {
        rebuild();
    }

    public EditProductScreen(AwpApp app, AwpModel model) {
        this(app, model, new AddProductMsg());
    }

    public EditProductScreen(AwpApp app, AwpModel model, AwpMsg onSave) {
        super(app, "edit_product_screen");
        this.app = app;
        this.model = model;

        this.onSave = onSave;
    }

    public EditProductScreen with(Product product, AwpMsg onSave) {
        this.product = product;
        this.onSave = onSave;
        return this;
    }

    public EditProductScreen empty() {
        return with(null, new SaveProductMsg(null));
    }

    @Override
    public void event(AwpMsg event) {
        app.event(event);
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, "edit_product_box")
            .align(BoxContainer.BoxAlign.Vertical)
            .padding(10)
            .componentMargin(10)
            .children(new Widget[]{
                new LabeledTextField(app, "product_name")
                    .label("Product Name")
                    .placeholder("Enter product name")
                    .text(product == null ? null : product.getName().toString())
                    .size(new Size(Integer.MAX_VALUE, 60))
                    .alignmentX(Component.LEFT_ALIGNMENT),

                new ComboBox(app, "product_group")
                    .size(new Size(Integer.MAX_VALUE, 40))
                    .alignmentX(Component.LEFT_ALIGNMENT)
                    .items(model.getGroups().toArray())
                    .selectedItem(null),

                new ScrollablePanel(app, "product_description_panel",
                    new LabeledTextArea(app, "product_description")
                        .label("Product Description")
                        .placeholder("Enter product description")
                        .text(product == null ? null : product.getDescription())
                        .alignmentX(Component.LEFT_ALIGNMENT))
                    .background(Color.GRAY)
                    .alignmentX(Component.LEFT_ALIGNMENT)
                    .size(new Size(Integer.MAX_VALUE, 120)),

                new BoxContainer(app, "product_manufacturer")
                    .align(BoxContainer.BoxAlign.Horizontal)
                    .componentMargin(10)
                        .size(new Size(Integer.MAX_VALUE, 60))
                        .alignmentX(Component.LEFT_ALIGNMENT)
                        .children(new Widget[]{
                            new ComboBox(app, "manufacturer_type")
                                .size(new Size(80, 40))
                                .items(Manufacturer.ManufacturerType.values())
                                .selectedItem(product == null ? null : product.getManufacturer().getType()),

                            new LabeledTextField(app, "manufacturer_name")
                                .label("Manufacturer Name")
                                .placeholder("Enter manufacturer name")
                                .text(product == null ? null : product.getManufacturer().getName().toString().replaceAll("\"", ""))
                                .size(new Size(Integer.MAX_VALUE, 60))
                        }),

                new LabeledTextField(app, "product_amount")
                    .label("Amount")
                    .placeholder("Enter amount")
                    .text(product == null ? null : String.valueOf(product.getAmount()))
                    .size(new Size(Integer.MAX_VALUE, 60))
                    .alignmentX(Component.LEFT_ALIGNMENT),

                new LabeledTextField(app, "product_price")
                    .label("Price")
                    .placeholder("Enter price")
                    .text(product == null ? null : String.valueOf(product.getPrice()))
                    .size(new Size(Integer.MAX_VALUE, 60))
                    .alignmentX(Component.LEFT_ALIGNMENT),

                new Button(app, "create_product")
                    .text("Save")
                    .size(new Size(700, 30))
                    .alignmentX(Component.LEFT_ALIGNMENT)
                    .clicked(this, onSave)
            });
    }

}
