package org.verstiukhnutov.awp;

import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.CoreWidget;
import org.verstiukhnutov.swelm.widgets.Label;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;
import org.verstiukhnutov.swelm.widgets.containers.Glue;
import org.verstiukhnutov.swelm.widgets.containers.Glue.Orientation;

enum CounterMsg {
    Increment,
    Decrement,
}

public class CounterApp extends ConstructWidget<CounterMsg> {

    int i = 0;
    
    @Override
    public void event(CounterMsg msg) {
        switch (msg) {
            case Increment:
                i++;
                ((Label) getWidget("label")).setText(String.valueOf(i));
                break;

            case Decrement:
                i--;
                ((Label) getWidget("label")).setText(String.valueOf(i));
                break;
        
            default:
                break;
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "counter_app",

            new BorderContainer(this, "border")
                .west(

                    new Button(this, "inc_button")
                        .text("Increment")
                        .clicked(this, CounterMsg.Increment)

                )       
                .center(

                    new BoxContainer(this, "label_box").children(new Widget[]{

                        new Glue(this, "glue1", Orientation.Horizontal),

                        new Label(this, "label")
                            .text(String.valueOf(i)),

                        new Glue(this, "glue2", Orientation.Horizontal),
                        
                    })

                )
                .east(

                    new Button(this, "dec_button")
                        .text("Decrement")
                        .clicked(this, CounterMsg.Decrement)

                )
        );

    }

    public static void main(String[] args) {
        new App<CounterMsg>(new CounterApp())
            .size(800, 100)
            .run();
    }

}
