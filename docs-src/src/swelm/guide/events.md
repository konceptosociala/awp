# Events

Events in Swelm are processed using **messages**. They are objects, which 
come from user interactions events and represent the current state
of the application; For easy messages processing we recommend using
`enums`:

```java
enum MyMsg {
    DoSomethingCool,
    DoSomethingCool2,
    ExitApplication,
}
```

## Usage example

```java
enum MyMsg {
    HelloWorld,
    NotHelloWorld,
}

public class MyApp extends ConstructWidget<MyMsg> {
    
    @Override
    public void event(MyMsg msg) {
        switch (msg) {
            case HelloWorld:
                System.out.println("Hello world!");
                break;
        
            default:
                break;
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BorderContainer(this, "my_border")
                .north(new Button(this, "my_button")
                    .text("Say hello")
                    .clicked(this, MyMsg.HelloWorld)
                )          
        );
    }

    public static void main(String[] args) {
        new App<MyMsg>(new MyApp())
            .run();
    }

}
```