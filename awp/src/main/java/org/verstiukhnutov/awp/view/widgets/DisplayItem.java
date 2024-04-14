package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.model.Product;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.msg.DeleteProductMsg;
import org.verstiukhnutov.awp.msg.EditProductMsg;
import org.verstiukhnutov.awp.msg.OpenProductMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;
import org.verstiukhnutov.swelm.widgets.containers.GridContainer;

import javax.swing.border.EmptyBorder;

public class DisplayItem extends ConstructWidget<AwpMsg> {
    private AwpApp app;
    private String widgetName;
    private Product product;
    private int index;

    public DisplayItem(AwpApp app, String widgetName, Product product, int index) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.product = product;
        this.index = index;
    }

    @Override
    public Widget build() {
        Color backgroundColor = index % 2 == 0 ? Color.GRAY : Color.LIGHT_GRAY;

        return new GridContainer(app, widgetName, 1, 7)
                .size(new Size(1152, 50))
                .maxSize(new Size(Integer.MAX_VALUE, 50))
                .children(new Widget[]{
                        new Panel(app, widgetName + "_name_panel",
                                new Label(app, widgetName + "_name")
                                        .border(new EmptyBorder(10, 10, 10, 10))
                                        .text(product.getName().toString()))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_group_panel",
                                new Label(app, widgetName + "_group")
                                        .text(product.getGroup().getName().toString()))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_description_panel",
                                new Label(app, widgetName + "_description")
                                        .text(product.getDescription()))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_manufacturer_panel",
                                new Label(app, widgetName + "_manufacturer")
                                        .text(product.getManufacturer().toString()))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_amount_panel",
                                new Label(app, widgetName + "_amount")
                                        .text(Integer.toString(product.getAmount())))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_price_panel",
                                new Label(app, widgetName + "_price")
                                        .text(Double.toString(product.getPrice())))
                                .background(backgroundColor),
                        new Panel(app, widgetName + "_controls_panel",
                                new BoxContainer(app, widgetName + "_controls_box")
                                        .componentMargin(20)
                                        .children(new Widget[]{
                                                new Button(app, widgetName + "_details_button")
                                                        .size(new Size(50, 30))
                                                        .text("Open")
                                                        .clicked(app, new OpenProductMsg(widgetName)),
                                                new Icon(app, widgetName + "_edit_button")
                                                        .type(Icon.IconType.Pen)
                                                        .size(new Size(20, 20))
                                                        .clicked(app, new EditProductMsg(widgetName)),
                                                new Icon(app, widgetName + "_delete_button")
                                                        .type(Icon.IconType.Trash)
                                                        .size(new Size(17, 20))
                                                        .clicked(app, new DeleteProductMsg(widgetName))
                                        })
                        )
                                .background(backgroundColor)
                });
    }
}
