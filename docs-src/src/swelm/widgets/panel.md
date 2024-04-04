# Panel

The `Panel` class in Swelm is a widget that represents a graphical container for other components within your application's user interface. It provides a way to group and organize components together.

```java
public Panel(IWidgetCollection widgets, String widgetName, Widget child)
```

- widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.
- child: The inner widget to be contained within the Panel.

## Usage

To create a panel in your Swelm application, you can instantiate a `Panel` object and add child components to it. Here's an example:

```java
Panel myPanel = new Panel(this, "my_panel", new Button(this, "my_button").text("Click me"));
```

In this example, we create a panel named "my_panel" and add a button as its child component.

## Notes

- Panel provides a way to group and organize components within a container.
- It utilizes a JPanel from the Swing library to implement panel functionality.