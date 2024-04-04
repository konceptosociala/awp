# Button

The `Button` class in Swelm is a widget that represents a clickable button in your application's user interface.

```java
public Button(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.

## Main methods

**`text(String text)`**

Sets the text label for the button.

```java
public Button text(String text)
```

- text: The text to be displayed on the button.

**`clicked(ConstructWidget<Msg> app, Msg msg)`**

Registers an action listener to handle button clicks.

```java
public <Msg> Button clicked(ConstructWidget<Msg> app, Msg msg)
```

- app: An instance of ConstructWidget representing the application.
- msg: The message to be processed when the button is clicked.

**`setText(String text)`**

Sets the text label for the button.

```java
public void setText(String text)
```

- text: The text to be displayed on the button.

## Usage

To create a button in your Swelm application, you can instantiate a `Button` object and customize its properties using the available methods. Here's an example:

```java
Button myButton = new Button(this, "my_button")
    .text("Click me")
    .clicked(this, new MyMsg("Button clicked"));
```

In this example, we create a button with the text "Click me", positioned at (100, 100) with a size of 100x50 pixels. We also register an action listener to handle button clicks and send a message `MyMsg("Button clicked")` to the application when clicked.
