package org.verstiukhnutov.awp;

import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.CoreWidget;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer.BoxAlign;

class MyMsg {

}

public class MyApp extends ConstructWidget<MyMsg> {
    
    @Override
    public void init() {
        // Initialization
    }

    @Override
    public void event(MyMsg msg) {
        // Event processing
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BoxContainer(this, "my_box")
                .align(BoxAlign.Vertical)
                .children(new Widget[]{
                    new Button(this, "button1")
                        .text("Button1"),
                    new Button(this, "button2")
                        .text("Button2")
                })
        );
    }

    public static void main(String[] args) {
        new App<MyMsg>(new MyApp())
            .run();
    }

}