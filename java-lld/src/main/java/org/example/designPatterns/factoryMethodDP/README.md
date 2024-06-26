# Factory Method Design Pattern

The Factory Method design pattern is a creational pattern that defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. Instead of calling a constructor directly to create an object, the client calls a factory method, which then returns an instance of the object.

## Key Concepts of Factory Method Pattern

1. **Product**: This is the interface or abstract class defining the type of objects the factory method creates.
2. **Concrete Product**: These are the classes that implement the `Product` interface or inherit from the abstract `Product` class.
3. **Creator**: This is the abstract class or interface that declares the factory method. It may also include some default implementations of the factory method.
4. **Concrete Creator**: These are the subclasses of `Creator` that override the factory method to return an instance of a `Concrete Product`.

## Structure

1. **Product Interface/Abstract Class**:
    ```java
    interface Product {
        void use();
    }
    ```

2. **Concrete Product**:
    ```java
    class ConcreteProductA implements Product {
        @Override
        public void use() {
            System.out.println("Using Product A");
        }
    }

    class ConcreteProductB implements Product {
        @Override
        public void use() {
            System.out.println("Using Product B");
        }
    }
    ```

3. **Creator**:
    ```java
    abstract class Creator {
        // The factory method
        abstract Product factoryMethod();

        // An operation that uses the product
        void someOperation() {
            Product product = factoryMethod();
            product.use();
        }
    }
    ```

4. **Concrete Creator**:
    ```java
    class ConcreteCreatorA extends Creator {
        @Override
        Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

    class ConcreteCreatorB extends Creator {
        @Override
        Product factoryMethod() {
            return new ConcreteProductB();
        }
    }
    ```

## Example

Suppose you are building a logistics application, and you want to create transport objects. Depending on the type of logistics, you need to create different transport objects (e.g., Truck, Ship).

1. **Product Interface**:
    ```java
    interface Transport {
        void deliver();
    }
    ```

2. **Concrete Products**:
    ```java
    class Truck implements Transport {
        @Override
        public void deliver() {
            System.out.println("Deliver by land in a box.");
        }
    }

    class Ship implements Transport {
        @Override
        public void deliver() {
            System.out.println("Deliver by sea in a container.");
        }
    }
    ```

3. **Creator**:
    ```java
    abstract class Logistics {
        // Factory method
        abstract Transport createTransport();

        void planDelivery() {
            Transport transport = createTransport();
            transport.deliver();
        }
    }
    ```

4. **Concrete Creators**:
    ```java
    class RoadLogistics extends Logistics {
        @Override
        Transport createTransport() {
            return new Truck();
        }
    }

    class SeaLogistics extends Logistics {
        @Override
        Transport createTransport() {
            return new Ship();
        }
    }
    ```

## Usage

To use the pattern, you would instantiate a `ConcreteCreator` and call its methods:

```java
public class Main {
    public static void main(String[] args) {
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();

        logistics = new SeaLogistics();
        logistics.planDelivery();
    }
}

