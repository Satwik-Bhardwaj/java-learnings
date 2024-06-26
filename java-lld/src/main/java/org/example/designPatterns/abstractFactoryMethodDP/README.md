# Abstract Factory Method Design Pattern

The Abstract Factory Method design pattern is a creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is useful when a system needs to be independent of how its objects are created, composed, and represented, and when it needs to be configured with one of multiple families of products.

## Key Concepts of Abstract Factory Pattern

1. **Abstract Factory**: This is an interface that declares a set of methods for creating abstract products.
2. **Concrete Factory**: These are classes that implement the abstract factory interface to create concrete products.
3. **Abstract Product**: These are interfaces or abstract classes that declare the operations that all concrete products must implement.
4. **Concrete Product**: These are classes that implement the abstract product interfaces.
5. **Client**: This is a class that uses the abstract factory and abstract products. It is decoupled from the concrete implementations.

## Structure

1. **Abstract Factory Interface**:
    ```java
    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }
    ```

2. **Concrete Factory**:
    ```java
    class WinFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }
    ```

3. **Abstract Product Interfaces**:
    ```java
    interface Button {
        void paint();
    }

    interface Checkbox {
        void paint();
    }
    ```

4. **Concrete Products**:
    ```java
    class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("Render a button in Windows style.");
        }
    }

    class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Render a button in macOS style.");
        }
    }

    class WinCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Render a checkbox in Windows style.");
        }
    }

    class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Render a checkbox in macOS style.");
        }
    }
    ```

## Example

Suppose you are building a cross-platform GUI application, and you want to create UI components that are platform-specific (e.g., Windows, macOS).

1. **Abstract Factory Interface**:
    ```java
    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }
    ```

2. **Concrete Factories**:
    ```java
    class WinFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }
    ```

3. **Abstract Product Interfaces**:
    ```java
    interface Button {
        void paint();
    }

    interface Checkbox {
        void paint();
    }
    ```

4. **Concrete Products**:
    ```java
    class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("Render a button in Windows style.");
        }
    }

    class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Render a button in macOS style.");
        }
    }

    class WinCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Render a checkbox in Windows style.");
        }
    }

    class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Render a checkbox in macOS style.");
        }
    }
    ```

## Client Code

To use the pattern, the client code would look like this:

```java
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

public class Main {
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WinFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
