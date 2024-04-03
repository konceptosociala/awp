# Example: Counter

Now let's create a real working example: it will be an application with two 
buttons - increment and decrement, and a label with a number, which will be manipulated.

Let's start with a carcass - application base and message:

```java
enum CounterMsg {
    Increment,
    Decrement,
}

public class CounterApp extends ConstructWidget<CounterMsg> {

    // Our value to modify
    int i = 0;
    
    @Override
    public void event(CounterMsg msg) {
        // Event processing
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "counter_app",
            // Our widgets
        );

    }

    // Initialize application
    public static void main(String[] args) {
        new App<CounterMsg>(new CounterApp())
            .size(800, 100)
            .run();
    }

}
```

Now create a border container, where we will put our buttons and a label:

```java
@Override
public Widget build() {
    return new CoreWidget(this, "counter_app",

        new BorderContainer(this, "border")
            .west(

                // Increment button, which sends `CounterMsg.Increment` message
                new Button(this, "inc_button")
                    .text("Increment")
                    .clicked(this, CounterMsg.Increment)

            )       
            .center(

                // We will use box container with glues to center our label
                new BoxContainer(this, "label_box").children(new Widget[]{

                    new Glue(this, "glue1", Orientation.Horizontal),

                    new Label(this, "label")
                        .text(String.valueOf(i)),

                    new Glue(this, "glue2", Orientation.Horizontal),
                    
                })

            )
            .east(

                // Decrement button, which sends `CounterMsg.Decrement` message
                new Button(this, "dec_button")
                    .text("Decrement")
                    .clicked(this, CounterMsg.Decrement)

            )
    );

}
```

And now let's process our sent messages using `switch` statements:

```java
@Override
public void event(CounterMsg msg) {
    switch (msg) {
        case Increment:
            // Increment our value and set label text to it
            i++;
            ((Label) getWidget("label")).setText(String.valueOf(i));
            break;

        case Decrement:
            // Decrement our value and set label text to it
            i--;
            ((Label) getWidget("label")).setText(String.valueOf(i));
            break;
    
        default:
            break;
    }
}
```

So our application code will be the following:

```java
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
```

The final application will look like this

![img2.png](../_img/img2.png)