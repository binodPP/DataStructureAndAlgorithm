1. Strategy Design Pattern 
   (https://medium.com/javarevisited/strategy-design-pattern-java-30439e00299e)
   (https://www.youtube.com/watch?v=u8DttUrXtEw&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=4)
   
2. Observer Design Pattern 
   (https://www.youtube.com/watch?v=Ep9_Zcgst3U&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=5)
   ()

3. Decorator Design Pattern 
   (https://www.youtube.com/watch?v=w6a9MXUwcfY&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=6)
   (https://refactoring.guru/design-patterns/decorator)
   (https://www.scaler.com/topics/design-patterns/decorator-design-pattern/)
   (https://www.javadevjournal.com/java-design-patterns/decorator-design-pattern/)
   
4. factory design pattern vs factory method design pattern vs abstract factory design pattern
   (https://medium.com/bitmountn/factory-vs-factory-method-vs-abstract-factory-c3adaeb5ac9a)
   (https://www.baeldung.com/cs/factory-method-vs-factory-vs-abstract-factory)
Ans:   
   
    1. Factory Pattern:
      Definition:
      The Factory Pattern is a creational pattern that provides an interface or a base 
       class for creating objects in a super class, but allows subclasses to alter the 
       type of objects that will be created.
      
      Example:
      
      java
      Copy code
      // Product interface
      interface Product {
      void display();
      }
      
      // Concrete product
      class ConcreteProduct implements Product {
      @Override
      public void display() {
      System.out.println("Product");
      }
      }
      
      // Factory class
      class Factory {
      public Product createProduct() {
      return new ConcreteProduct();
      }
      }
      
      // Client code
      public class FactoryPatternExample {
      public static void main(String[] args) {
      Factory factory = new Factory();
      Product product = factory.createProduct();
      product.display();
      }
      }
      When to Use:
      Use the Factory Pattern when you have a super class with multiple subclasses and, 
      based on the input or context, you want to create and return an instance of one of the subclasses.
      
      2. Factory Method Pattern:
         Definition:
         The Factory Method Pattern is a variation of the Factory Pattern where a method in an interface or an abstract class is responsible for creating objects. Subclasses implement this method to produce objects of a particular type.
      
      Example:
      
      java
      Copy code
      // Product interface
      interface Product {
      void display();
      }
      
      // Concrete products
      class ConcreteProductA implements Product {
      @Override
      public void display() {
      System.out.println("Product A");
      }
      }
      
      class ConcreteProductB implements Product {
      @Override
      public void display() {
      System.out.println("Product B");
      }
      }
      
      // Factory interface
      interface Factory {
      Product createProduct();
      }
      
      // Concrete factories
      class ConcreteFactoryA implements Factory {
      @Override
      public Product createProduct() {
      return new ConcreteProductA();
      }
      }
      
      class ConcreteFactoryB implements Factory {
      @Override
      public Product createProduct() {
      return new ConcreteProductB();
      }
      }
      
      // Client code
      public class FactoryMethodPatternExample {
      public static void main(String[] args) {
      Factory factoryA = new ConcreteFactoryA();
      Product productA = factoryA.createProduct();
      productA.display();
      
              Factory factoryB = new ConcreteFactoryB();
              Product productB = factoryB.createProduct();
              productB.display();
          }
      }
      When to Use:
      Use the Factory Method Pattern when you want to delegate the responsibility of 
      creating objects to subclasses, allowing them to alter the type of objects that will be created.
      
      3. Abstract Factory Pattern:
         Definition:
         The Abstract Factory Pattern is another creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It involves multiple factory methods, each responsible for creating a different kind of object.
      
      Example:
      
      java
      Copy code
      // Abstract product interfaces
      interface ProductA {
      void display();
      }
      
      interface ProductB {
      void show();
      }
      
      // Concrete product implementations
      class ConcreteProductA1 implements ProductA {
      @Override
      public void display() {
      System.out.println("Product A1");
      }
      }
      
      class ConcreteProductA2 implements ProductA {
      @Override
      public void display() {
      System.out.println("Product A2");
      }
      }
      
      class ConcreteProductB1 implements ProductB {
      @Override
      public void show() {
      System.out.println("Product B1");
      }
      }
      
      class ConcreteProductB2 implements ProductB {
      @Override
      public void show() {
      System.out.println("Product B2");
      }
      }
      
      // Abstract factory interface
      interface AbstractFactory {
      ProductA createProductA();
      ProductB createProductB();
      }
      
      // Concrete factory implementations
      class ConcreteFactory1 implements AbstractFactory {
      @Override
      public ProductA createProductA() {
      return new ConcreteProductA1();
      }
      
          @Override
          public ProductB createProductB() {
              return new ConcreteProductB1();
          }
      }
      
      class ConcreteFactory2 implements AbstractFactory {
      @Override
      public ProductA createProductA() {
      return new ConcreteProductA2();
      }
      
          @Override
          public ProductB createProductB() {
              return new ConcreteProductB2();
          }
      }
      
      // Client code
      public class AbstractFactoryPatternExample {
      public static void main(String[] args) {
      AbstractFactory factory1 = new ConcreteFactory1();
      ProductA productA1 = factory1.createProductA();
      productA1.display();
      ProductB productB1 = factory1.createProductB();
      productB1.show();
      
              AbstractFactory factory2 = new ConcreteFactory2();
              ProductA productA2 = factory2.createProductA();
              productA2.display();
              ProductB productB2 = factory2.createProductB();
              productB2.show();
          }
      }
      When to Use:
      Use the Abstract Factory Pattern when you need to create families of related or dependent objects. This pattern is particularly useful when the system must be configured with multiple families of objects, and the client code should be insulated from their concrete classes.
      
      Summary:
      Factory Pattern: Useful when you have a super class with multiple subclasses, and you want to create an instance of one of the subclasses based on input or context.
      
      Factory Method Pattern: Useful when you want to delegate the responsibility of creating objects to subclasses, allowing them to alter the type of objects that will be created.
      
      Abstract Factory Pattern: Useful when you need to create families of related or dependent objects, and the system must be configured with multiple families of objects.
      
      The choice between these patterns depends on the specific requirements of your application and the level of abstraction and flexibility you need in creating objects.
   