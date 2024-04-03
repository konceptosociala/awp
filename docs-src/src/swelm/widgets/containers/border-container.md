# BorderContainer

The `BorderContainer` class in Swelm is a widget that represents a container with regions laid out in a border layout. It allows you to organize and manage the layout of your application's user interface by specifying components for each of the five regions: north, south, east, west, and center.

```java
public BorderContainer(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.

# Main methods

**`north(Widget widget)`**

Sets the widget to be displayed in the north region of the container.

```java
public BorderContainer north(Widget widget)
```

- widget: The widget to be displayed in the north region.

**`south(Widget widget)`**

Sets the widget to be displayed in the south region of the container.

```java
public BorderContainer south(Widget widget)
```

- widget: The widget to be displayed in the south region.

**`east(Widget widget)`**

Sets the widget to be displayed in the east region of the container.

```java
public BorderContainer east(Widget widget)
```

- widget: The widget to be displayed in the east region.

**`west(Widget widget)`**

Sets the widget to be displayed in the west region of the container.

```java
public BorderContainer west(Widget widget)
```

- widget: The widget to be displayed in the west region.

**`center(Widget widget)`**

Sets the widget to be displayed in the center region of the container.

```java
public BorderContainer center(Widget widget)
```

- widget: The widget to be displayed in the center region.

## Usage

To create a border container in your Swelm application, you can instantiate a `BorderContainer` object and specify the widgets for each region using the appropriate methods. Here's an example:

```java
BorderContainer borderContainer = new BorderContainer(this, "my_border_container")
    .north(new Button(this, "north_button").text("North"))
    .south(new Button(this, "south_button").text("South"))
    .east(new Button(this, "east_button").text("East"))
    .west(new Button(this, "west_button").text("West"))
    .center(new Button(this, "center_button").text("Center"));
```

In this example, we create a border container with buttons in each region, labeled accordingly.

## Notes

- BorderContainer provides a flexible way to organize the layout of your application's user interface using a border layout.
- It utilizes a Container with a BorderLayout manager to manage the layout of its child components.