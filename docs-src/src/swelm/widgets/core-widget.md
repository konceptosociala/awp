# CoreWidget

The CoreWidget class in Swelm is a fundamental building block for constructing widgets within your application. It serves as a container for other widgets, allowing you to organize and manage the layout of your application's user interface.

```java
public CoreWidget(IWidgetCollection widgets, String widgetName, Widget child)
```

 * widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
 * widgetName: A unique identifier for the widget.
 * child: The inner widget to be contained within the CoreWidget.

## Usage

To utilize the CoreWidget class, you can create an instance of it within your application's code and specify the inner widget to be contained. Here's an example of how to create a CoreWidget:

```java
@Override
public Widget build() {
    return new CoreWidget(this, "my_core_widget",

        new Button(this, "button1")
            .text("I am the only widget inside CoreWidget!"),

    );
}
```

In this example, we create a new CoreWidget named "my_core_widget" and add a Button widget as its inner child;