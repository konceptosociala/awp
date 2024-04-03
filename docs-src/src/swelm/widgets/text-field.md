# TextField

The `TextField` class in Swelm is a widget that represents a text input field in your application's user interface. It allows users to enter and edit text.

```java
public TextField(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.

## Main methods

**`text(String text)`**

Sets the text content of the text field.

```java
public TextField text(String text)
```

- text: The text to be displayed in the text field.

**`placeholder(String placeholder)`**

Sets the placeholder text for the text field.

```java
public TextField placeholder(String placeholder)
```

- placeholder: The placeholder text to be displayed when the text field is empty.

**`setText(String text)`**

Sets the text content of the text field.

```java
public void setText(String text)
```

- text: The text to be displayed in the text field.

**`setPlaceholder(String placeholder)`**

Sets the placeholder text for the text field.

```java
public void setPlaceholder(String placeholder)
```

- placeholder: The placeholder text to be displayed when the text field is empty.

## Usage

To create a text field in your Swelm application, you can instantiate a `TextField` object and customize its properties using the available methods. Here's an example:

```java
TextField myTextField = new TextField(this, "my_text_field")
    .text("Enter text here")
    .placeholder("Type something...");
```

In this example, we create a text field named "my_text_field" with the initial text "Enter text here" and a placeholder "Type something...".

## Notes

- TextField provides a way for users to input text into your application.
- It utilizes a custom JPlaceholderTextField component to implement text field functionality with support for placeholder text.