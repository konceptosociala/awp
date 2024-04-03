# WrapContainer

The `WrapContainer` class in Swelm is a widget that represents a container with components laid out in a wrap layout. It allows you to organize and manage the layout of your application's user interface by arranging components in rows and automatically wrapping them to the next row when necessary.

```java
public WrapContainer(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.

## Main methods

**`children(Widget[] children)`**

Adds child widgets to the wrap container.

```java
public WrapContainer children(Widget[] children)
```

- children: An array of Widget objects representing the child widgets to be added to the wrap container.

Usage

To create a wrap container in your Swelm application, you can instantiate a `WrapContainer` object and add child widgets using the `children()` method. Here's an example:

```java
WrapContainer wrapContainer = new WrapContainer(this, "my_wrap_container")
    .children(new Widget[]{
        new Button(this, "button1").text("Button 1"),
        new Button(this, "button2").text("Button 2"),
        new Button(this, "button3").text("Button 3"),
        new Button(this, "button4").text("Button 4"),
        // Add more widgets as needed
    });
```

In this example, we create a wrap container named "my_wrap_container" and add several buttons to it. The wrap layout automatically arranges the buttons in rows and wraps them to the next row when necessary to fit within the container's width.

## Notes

- WrapContainer provides a convenient way to create responsive layouts with components automatically wrapping to accommodate varying screen sizes.
- It utilizes a Container with a WrapLayout manager to manage the layout of its child components.