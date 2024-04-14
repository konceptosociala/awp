package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.model.Product;
import org.verstiukhnutov.awp.msg.SwitchToMainScreen;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.Icon;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.Label;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import java.awt.*;


public class ViewProductScreen extends Screen {
    private AwpApp app;
    private Product product;

    public ViewProductScreen(AwpApp app) {
        super(app, "view_product_screen");
        this.app = app;
    }

    public ViewProductScreen with(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public Widget build() {
        return new BorderContainer(app, "view_product_screen_container")
                .north(
                        new BoxContainer(app, "close_container")
                                .align(BoxContainer.BoxAlign.Vertical)
                                .size(new Size(500, 24))
                                .children(new Widget[]{
                                        new Icon(app, "close_icon")
                                                .type(Icon.IconType.Cross)
                                                .size(new Size(24, 24))
                                                .clicked(app, new SwitchToMainScreen())
                                                .alignmentX(Component.RIGHT_ALIGNMENT)
                                })
                                .alignmentX(0)
                )
                .center(
                        new BoxContainer(app, "view_product_box")
                                .align(BoxContainer.BoxAlign.Vertical)
                                .children(new Widget[]{
                                        new Label(app, "product_name")
                                                .text(product.getName().toString())
                                                .fontSize(24)
                                                .alignmentX(Component.CENTER_ALIGNMENT),
                                        new Label(app, "product_description")
                                                .text(product.getDescription())
                                                .alignmentX(Component.CENTER_ALIGNMENT),
                                        new Label(app, "product_manufacturer")
                                                .text("Manufacturer: " + product.getManufacturer())
                                                .alignmentX(Component.CENTER_ALIGNMENT),
                                        new Label(app, "product_price")
                                                .text("Price: " + product.getPrice())
                                                .alignmentX(Component.CENTER_ALIGNMENT),
                                        new Label(app, "product_amount")
                                                .text("Amount: " + product.getAmount())
                                                .alignmentX(Component.CENTER_ALIGNMENT)
                                })
                );
    }
}
