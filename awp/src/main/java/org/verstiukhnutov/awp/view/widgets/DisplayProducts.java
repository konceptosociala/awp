package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.model.AwpModel;
import org.verstiukhnutov.awp.model.Product;
import org.verstiukhnutov.awp.msg.AddProductMsg;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;
import org.verstiukhnutov.swelm.widgets.containers.GridContainer;

import javax.swing.border.MatteBorder;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DisplayProducts extends ConstructWidget<AwpMsg> {
    private final AwpApp app;
    private final String widgetName;
    private AwpModel model;
    private boolean disableControls;

    public DisplayProducts(AwpApp app, String widgetName, AwpModel model) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.model = model;
    }

    public DisplayProducts disableControls() {
        this.disableControls = true;
        return this;
    }

    private Widget getLabelsRow() {
        return new GridContainer(app, widgetName + "_labels_row", 1, 7)
                .size(new Size(1152, 50))
                .maxSize(new Size(Integer.MAX_VALUE, 50))
                .children(new Widget[]{
                        new Label(app, widgetName + "_name_label").text("Name")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_group_label").text("Group")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_description_label").text("Description")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_manufacturer_label").text("Manufacturer")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_amount_label").text("Amount")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_price_label").text("Price")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE)),
                        new Label(app, widgetName + "_actions_label").text(disableControls ? "" : "Actions")
                                .bold(true)
                                .border(new MatteBorder(0, 0, 2, 0, Color.WHITE))
                });
    }

    private ArrayList<Widget> getProducts() {
        AtomicInteger index = new AtomicInteger(0);
        ArrayList<Widget> products = new ArrayList<>();

        for (Product product : model.getProducts()) {
            products.add(new DisplayItem(app, widgetName + "_display_item_" + product.getName(), product, index.getAndIncrement()).disableControls(disableControls));
        }

        return products;
    }

    public void update() {
        ((BoxContainer) app.getWidget(widgetName + "_box")).removeChildren();
        ((BoxContainer) app.getWidget(widgetName + "_box")).children(getProducts().toArray(new Widget[0]));
    }

    @Override
    public Widget build() {
        return new BorderContainer(app, widgetName+"_container")
                .north(disableControls ? new BoxContainer(app, "empty") : new SearchBar(app, widgetName + "_search_bar").placeholder("Search products..."))
                .center(
                        new BoxContainer(app, widgetName + "_main_box")
                                .align(BoxContainer.BoxAlign.Vertical)
                                .children(new Widget[]{
                                        getLabelsRow(),
                                        new ScrollablePanel(app, widgetName + "_scrollable_panel",
                                                new BoxContainer(app, widgetName + "_box")
                                                        .align(BoxContainer.BoxAlign.Vertical)
                                                        .children(getProducts().toArray(new Widget[0]))
                                        )
                                                .background(Color.GRAY)
                                                .disableHorizontalScrollBar()
                                })
                        )
                .south(
                        disableControls ? new BoxContainer(app, "empty") :
                        new Button(app, widgetName + "_add_product_button")
                                .text("Add Product")
                                .clicked(app, new AddProductMsg())
                );
    }
}
