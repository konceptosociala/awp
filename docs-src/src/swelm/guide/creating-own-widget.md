# Creating own widget

Creating a widget in Swelm is similar to creating an application (because 
for both we use `ConstructWidget` class). As for application we must specify
its [message type](./events.md). If our widget won't produce any events, we
can use `UnitMsg` type. Else we can specify any other message type or application's
one:

```java
public class MyWidget extends ConstructWidget<MyMsg> {

    // We must save our app instance in order to
    // spawn widgets to it
    private MyApp app;

    public MyWidget(MyApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
    }

    @Override
    public void event(MyMsg msg) {
        // Process event
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, "my_box")
            .children(new Widget[]{
                new Button(app, "my_button")
                    .text("Button1")
                    .clicked(this, MyMsg.HelloWorld)
            });
    }
}
```

As you can see, we can't use more than 1 such widget in our application,
because its widgets IDs will be the same for every instance of the widget.
In order to avoid this, we can use our `widgetName` as a prefix for our widgets:

```java
public class MyWidget extends ConstructWidget<MyMsg> {

    private MyApp app;
    private String widgetName;

    public MyWidget(MyApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
    }

    @Override
    public void event(MyMsg msg) {
        // Process event
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, widgetName+"_my_box")
            .children(new Widget[]{
                new Button(app, widgetName+"_my_button")
                    .text("Button1")
                    .clicked(this, MyMsg.HelloWorld)
            });
    }
}
```

And now we can process our message in the widget or simply pass it 
directly to the application:

```java
public class MyWidget extends ConstructWidget<MyMsg> {

    private MyApp app;
    private String widgetName;

    public MyWidget(MyApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
    }

    @Override
    public void event(MyMsg msg) {
        app.event(msg);
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, widgetName+"_my_box")
            .children(new Widget[]{
                new Button(app, widgetName+"_my_button")
                    .text("Button1")
                    .clicked(this, MyMsg.HelloWorld)
            });
    }
}
```

That's all! Now we can use our widget in the application:

```java
enum MyMsg {
    HelloWorld,
    DoSomething,
}

public class MyApp extends ConstructWidget<MyMsg> {
    
    @Override
    public void event(MyMsg msg) {
        switch (msg) {
            case HelloWorld:
                System.out.println("Hello world!");
                break;
        
            default:
                break;
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BorderContainer(this, "my_border")
                .north(new MyWidget(this, "my_widget"))          
        );
    }

    public static void main(String[] args) {
        new App<MyMsg>(new MyApp())
            .run();
    }

}
```