# Menu System Widgets

The menu system widgets in Swelm provide a way to create and manage menus and menu items within your application's user interface. These widgets allow you to organize and present functionality in a hierarchical manner, making it easy for users to navigate and interact with your application.

## MenuBar

The `MenuBar` widget represents a menu bar component, typically located at the top of the application window. It serves as the container for menus and provides a centralized location for accessing various functionalities offered by the application.

```java
public MenuBar(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the menu bar widget.

## Main methods

**`menus(Menu[] menus)`**

Adds menus to the menu bar.

```java
public MenuBar menus(Menu[] menus)
```

- menus: An array of Menu objects representing the menus to be added to the menu bar.

**`setVisible(boolean visible)`**

Sets the visibility of the menu bar.

```java
public void setVisible(boolean visible)
```

- visible: A boolean value indicating whether the menu bar should be visible or not.

## Usage

To create a menu bar in your Swelm application, you can instantiate a `MenuBar` object and add menus to it using the `menus()` method. Here's an example:

```java
MenuBar menuBar = new MenuBar(thi, "main_menu_bar")

    .menus(new Menu[]{
        new Menu(this, "file_menu").text("File")
            .items(new MenuItem[]{
                new SingleItem(this, "open_item").text("Open"),
                new SingleItem(this, "save_item").text("Save")
            }),

        new Menu(this, "edit_menu").text("Edit")
            .items(new MenuItem[]{
                new SingleItem(this, "cut_item").text("Cut"),
                new SingleItem(this, "copy_item").text("Copy"),
                new SingleItem(this, "paste_item").text("Paste")
            }),

    });
```

# MenuItem

The `MenuItem` class is an abstract class representing a single item within a menu. It serves as a base class for specific types of menu items.

```java
public MenuItem(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the menu item.

# Menu

The `Menu` class represents a menu component within the menu system. It contains a list of menu items and provides a dropdown interface for accessing them.

```java
public Menu(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the menu widget.

## Main methods

**`text(String text)`**

Sets the text label for the menu.

```java
public Menu text(String text)
```

- text: The text to be displayed on the menu.

**`items(MenuItem[] items)`**

Adds menu items to the menu.

```java
public Menu items(MenuItem[] items)
```

- items: An array of MenuItem objects representing the menu items to be added to the menu.

# SingleItem

The `SingleItem` class represents a single item within a menu that triggers an action when clicked. It is a subclass of `MenuItem`.

```java
public SingleItem(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the menu item.

## Main methods

**`text(String text)`**

Sets the text label for the menu item.

```java
public SingleItem text(String text)
```

- text: The text to be displayed on the menu item.

**`clicked(ConstructWidget<Msg> app, Msg msg)`**

Registers an action listener to handle clicks on the menu item.

```java
public <Msg> SingleItem clicked(ConstructWidget<Msg> app, Msg msg)
```

- app: An instance of ConstructWidget representing the application.
- msg: The message to be processed when the menu item is clicked.