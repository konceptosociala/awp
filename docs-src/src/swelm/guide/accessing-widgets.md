# Accessing widgets

We've created an application and now we want to access our widgets somehow. For example,
we would want to check some config parameter at the application initialization to find out,
whether we must enable or disable some widget.

Namely for this purpose we have passed our application (or rarely other IWidgetCollection) 
instance when creating our widgets: 

```java
new Button(this, "my_button")
    .text("MyButton"),
```

So now we can get it from our application in `init` or `event` methods by its unique ID: 

```java
@Override
public void init() {
    Button myButton = (Button) getWidget("my_button");
    if (config.someParam == 0)
        myButton.setVisible(false);
    else 
        myButton.setVisible(true);
}
```

Or alternatively we can create another `IWidgetCollection` instance inside our
application and use it directly, but this approach is not recommended:

```java
public class MyApp extends ConstructWidget<UnitMsg> {
    
    private Widgets myWidgets = new Widgets();

    @Override
    public void init() {
        ((Button) myWidgets.getWidget("my_button")).setVisible(true);
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BorderContainer(this, "my_border")
                .north(new Button(myWidgets, "my_button")
                    .text("MyButton"))
        );
    }

    public static void main(String[] args) {
        new App<UnitMsg>(new MyApp())
            .run();
    }

}
```

**NOTE**: Every `ConstructWidget` can also be `IWidgetCollection`