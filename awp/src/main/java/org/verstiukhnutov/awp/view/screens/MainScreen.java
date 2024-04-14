package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.model.*;
import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;
import org.verstiukhnutov.awp.model.error.InvalidManufacturerNameException;
import org.verstiukhnutov.awp.model.error.InvalidProductNameException;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.*;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.WrapContainer;

public class MainScreen extends Screen {
    AwpApp app;
    AwpModel model;

    public MainScreen(AwpApp app, AwpModel model) {
        super(app, "main_screen");
        this.app = app;
        this.model = model;
    }

    @Override
    public void init() {
        ((MainMenu) app.getWidget("main_menu")).setVisible(false);
    }

    @Override
    public Widget build() {
        Product testProduct;
        try {
            testProduct = new Product(
                    new ProductName("Test Product"),
                    new Manufacturer(Manufacturer.ManufacturerType.Pp, new ManufacturerName("Test Manufacturer")),
                    "Test Description",
                    10,
                    100,
                    new Group(new GroupName("Test Group"), "Test Description")
            );
        } catch (InvalidProductNameException | InvalidGroupNameException | InvalidManufacturerNameException e) {
            throw new RuntimeException(e);
        }

        return new BorderContainer(app, "my_border")
            .north(new MainMenu(app, "main_menu"))
            .center(new Notebook(app, "notebook")
                .background(Color.GRAY)
                .foreground(Color.WHITE)
                .tabs(new Tab[]{
                    new Tab("Groups", new ScrollablePanel(app, "groups_panel",
                        new BorderContainer(app, "groups_container")
                            .center(new WrapContainer(app, "groups").children(new Widget[]{
                                new AddGroup(app, "add_group")
                            }))
                    ).background(Color.GRAY)),
                    new Tab("Products", new Panel(app, "products_panel",
                            new DisplayProducts(app, "display_products", model)
                    )),
            }));
    }
}