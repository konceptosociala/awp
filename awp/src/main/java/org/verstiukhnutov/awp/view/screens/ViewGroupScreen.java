package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.model.AwpModel;
import org.verstiukhnutov.awp.model.Group;
import org.verstiukhnutov.awp.model.Product;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.msg.SwitchToMainScreen;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.DisplayProducts;
import org.verstiukhnutov.awp.view.widgets.Icon;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Panel;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
import java.awt.*;

public class ViewGroupScreen extends Screen {
    private AwpApp app;
    private Group group;
    private AwpModel model;

    public ViewGroupScreen(AwpApp app, Group group, AwpModel model) {
        super(app, "view_group_screen");
        this.app = app;
        this.group = group;
        this.model = model;
    }

    public ViewGroupScreen(AwpApp app, AwpModel model) {
        super(app, "view_group_screen");
        this.app = app;
        this.model = model;
    }

    public ViewGroupScreen with(Group group) {
        this.group = group;
        return this;
    }

    private String truncateDescription(String description, int length) {
        if (description.length() <= length) {
            return description;
        } else {
            return description.substring(0, length)+"...";
        }
    }

    private int getProductsTotalCost() {
        return group.getProducts().stream().mapToInt((product) -> product.getAmount()*product.getPrice()).sum();
    }

    @Override
    public void init() {
        rebuild();
    }

    @Override
    public void event(AwpMsg event) {
        app.event(event);
    }

    @Override
    public Widget build() {
        return new BorderContainer(app, "view_group_container")
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
                        new BoxContainer(app, "view_group_box")
                                .align(BoxContainer.BoxAlign.Vertical)
                                .children(new Widget[]{
                                        new HTMLLabel(app, "group_name_label")
                                                .alignmentX(0.4f)
                                                .size(1152, 50)
                                                .text(group.getName().toString())
                                                .fontSize(24)
                                                .bold(true),

                                        new TextPane(app, "group_description_label")
                                                .size(new Size(1100, 200))
                                                .maximumSize(new Size(1100, 200))
                                                .text(truncateDescription(group.getDescription(), 1000))
                                                .fontSize(16),

                                        new HTMLLabel(app, "group_products_label")
                                                .alignmentX(0.4f)
                                                .size(1152, 50)
                                                .text("Total cost of products: " + getProductsTotalCost())
                                                .fontSize(18)
                                                .bold(true),

                                        new DisplayProducts(app, "display_group_products", model).size(new Size(1152, 400)).disableControls().groupFilter(group)
                                })
                );
    }
}
