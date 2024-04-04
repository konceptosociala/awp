# AdjustableWidget Interface

The `AdjustableWidget` interface in Swelm defines a set of methods that every widget implements to provide functionality for adjusting various visual properties and behaviors. By implementing this interface, widgets gain the ability to control their size, position, colors, border, and visibility.

## Methods

**`setSize(Size size)`**

Sets the size of the widget.

**`setPosition(Pos pos)`**

Sets the position of the widget.

**`setBackground(Color color)`**

Sets the background color of the widget.

**setForeground(Color color)**

Sets the foreground color of the widget.

**`setBorder(Border border)`**

Sets the border of the widget.

**`setVisible(boolean visible)`**

Sets the visibility of the widget.

## Fluent Methods

In addition to the regular setter methods, the interface also provides fluent methods, which return the modified widget instance to allow for method chaining:

- **`size(Size size)`**
- **`position(Pos pos)`**
- **`background(Color color)`**
- **`foreground(Color color)`**
- **`border(Border border)`**
- **`visible(boolean visible)`**

These fluent methods provide a more concise and expressive way to modify multiple properties of a widget in a single statement.

Usage

Widgets implementing the `AdjustableWidget` interface can be easily customized by invoking these methods to adjust their appearance and behavior according to the requirements of the application. For example:

```java
Button myButton = new Button(widgets, "my_button")
    .text("Click Me")
    .size(new Size(100, 50))
    .position(new Pos(50, 50))
    .background(Color.BLUE)
    .foreground(Color.WHITE)
    .visible(true);
```

In this example, we create a button named "my_button" with specified text, size, position, background color, foreground color, border, and visibility.

Benefits

- Provides a standardized way to adjust properties of widgets across different types of UI elements.
- Promotes code readability and maintainability by offering fluent methods for method chaining.
- Enables developers to easily customize the appearance and behavior of widgets to meet specific design requirements.