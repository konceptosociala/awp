# BoxContainer & Glue

In Swelm, the `BoxContainer` widget is a versatile tool for organizing the layout of user interfaces. It allows developers to arrange components sequentially in either a horizontal or vertical box layout. Additionally, by incorporating `Glue` widgets within a `BoxContainer`, developers can control spacing and alignment between components more precisely.

```java
public BoxContainer(IWidgetCollection widgets, String widgetName)
```

- widgets: An instance of IWidgetCollection interface, providing access to the collection of widgets within the application.
- widgetName: A unique identifier for the BoxContainer widget.

## Usage

### Horizontal Layout with Glue

In a horizontal layout scenario, where components are arranged side by side, horizontal glue can be used to adjust the spacing between components.

```java
// Creating a BoxContainer with horizontal layout
BoxContainer horizontalContainer = new BoxContainer(this, "horizontal_container")
    .align(BoxContainer.BoxAlign.Horizontal)
    .children(new Widget[]{
        new Button(this, "button1").text("Button 1"),
        new Glue(this, "horizontal_glue", Glue.Orientation.Horizontal), // Horizontal glue for spacing
        new Button(this, "button2").text("Button 2"),
        new Glue(this, "horizontal_glue2", Glue.Orientation.Horizontal), // Additional horizontal glue
        new Button(this, "button3").text("Button 3")
    });
```

In this example, the `Glue` widgets (`horizontal_glue` and `horizontal_glue2`) provide flexible spacing between the buttons (`button1`, `button2`, and `button3`) within the `horizontalContainer`.

### Vertical Layout with Glue

Similarly, in a vertical layout scenario where components are stacked vertically, vertical glue can be utilized to adjust spacing between components.

```java
// Creating a BoxContainer with vertical layout
BoxContainer verticalContainer = new BoxContainer(this, "vertical_container")
    .align(BoxContainer.BoxAlign.Vertical)
    .children(new Widget[]{
        new Button(this, "button1").text("Button 1"),
        new Glue(this, "vertical_glue", Glue.Orientation.Vertical), // Vertical glue for spacing
        new Button(this, "button2").text("Button 2"),
        new Glue(this, "vertical_glue2", Glue.Orientation.Vertical), // Additional vertical glue
        new Button(this, "button3").text("Button 3")
    });
```

Here, the `Glue` widgets (`vertical_glue` and `vertical_glue2`) create flexible spacing between the buttons (`button1`, `button2`, and `button3`) within the `verticalContainer`.

## Customization and Precision

By incorporating `Glue` widgets within a `BoxContainer`, developers gain fine-grained control over the spacing and alignment of components. This approach allows for highly customizable user interfaces that adapt well to various screen sizes and resolutions.