# Notebook

The `Notebook` class in Swelm is a widget that represents a notebook or tabbed pane in your application's user interface. It allows you to organize content into multiple tabs, with each tab containing a distinct set of components.

```java
public Notebook(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, which provides access to the collection of widgets within the application.
- widgetName: A unique identifier for the widget.

## Main methods

**`tabs(Tab[] tabs)`**

Adds tabs to the notebook.

```java
public Notebook tabs(Tab[] tabs)
```

- tabs: An array of Tab objects representing the tabs to be added to the notebook.

## Usage

To create a notebook in your Swelm application, you can instantiate a `Notebook` object and add tabs to it using the `tabs()` method. Here's an example:

```java
Notebook myNotebook = new Notebook(this, "my_notebook")
    .bounds(100, 100, 300, 200)
    .tabs(new Tab[]{
        new Tab("Tab 1", new Panel(this, "panel1", new Button(this, "my_button").text("Click me"))),
        new Tab("Tab 2", new Panel(this, "panel2", new Button(this, "my_button").text("Click me")))
    });
```

In this example, we create a notebook positioned at (100, 100) with a size of 300x200 pixels. We add two tabs to the notebook, each with a label ("Tab 1" and "Tab 2") and a corresponding panel.

## Notes

- Notebook provides a convenient way to organize and present multiple sets of content within a single container.
- It utilizes a JTabbedPane from the Swing library to implement tabbed functionality.

# Tab

The `Tab` class in Swelm represents a single tab within a notebook or tabbed pane. Each tab consists of a label and an associated panel containing the tab's content.

```java
public Tab(String label, Panel panel)
```

- label: The label or title of the tab.
- panel: An instance of the Panel class representing the content of the tab.

Methods

**`getLabel()`**

Returns the label of the tab.

```java
public String getLabel()
```

- Returns: The label of the tab.

**`getPanel()`**

Returns the panel associated with the tab.

```java
public Panel getPanel()
```

- Returns: An instance of the Panel class representing the content of the tab.
