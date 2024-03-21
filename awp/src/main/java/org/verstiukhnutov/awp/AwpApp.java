package org.verstiukhnutov.awp;

import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.BoxContainer.BoxAlign;

enum Msg {
    Increment,
    Decrement,
}

public class AwpApp extends ConstructWidget<Msg> {    
    int i = 0;

    public static void main(String[] args) {
        new App<Msg>(new AwpApp())
            .title("My App")
            .size(800, 600)
            .run();
    }

    @Override
    public void event(Msg msg) {
        Button button = (Button) this.getWidget("my_button");

        switch (msg) {
            case Increment: button.text(String.valueOf(++i)); break;
            case Decrement: button.text(String.valueOf(--i)); break;        
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BoxContainer(this, "my_box")
                .align(BoxAlign.Vertical)
                .children(new Widget[]{

                    new Button(this, "inc")
                        .text("Increment")
                        .bounds(0, 0, 100, 40)
                        .clicked(this, Msg.Increment),
                        
                    new Button(this, "my_button")
                        .text(String.valueOf(i))
                        .bounds(0, 0, 100, 40),

                    new Button(this, "dec")
                        .text("Decrement")
                        .bounds(0, 0, 100, 40)
                        .clicked(this, Msg.Decrement),

                })
        );
    }

}