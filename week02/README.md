# Tutorial

## Clarifications

- Challenge exercises are not worth any marks.
- Late enrolments mean groups aren't completely finalised... will sort out in the lab.


## Assignment

[Assignment Specification](https://gitlab.cse.unsw.edu.au/COMP2511/21T2/assignment-specification)

- The design is the most important part of your assignment! It's worth 15 of 40 marks...

- Draw your UML class diagram before coding anything (and seek feedback!).

- Make sure you configure your IDE (i.e. VSCode) before getting started. You really should install the 'Java Extension Pack'.

- Source Action will save you a bit of time.

- Check out the course forum.

Any questions?


## Packages

"A Java package organizes Java classes into namespaces, providing a unique namespace for each type it contains. Classes in the same package can access each other's package-private and protected members." - [Wikipedia](https://en.wikipedia.org/wiki/Java_package)

`import java.util.List`


## `super` and `this`

Look at `src/shapes`.

1. What is the difference between super and this?


2. What about super(...) and this(...)?


3. What are static fields and methods?


## Access Modifiers and Packages

Look at `src/access`.

Stuff to do with encapsulation

![Access Modifiers in Java](./Access_Modifiers_in_Java.png)


## UML Diagrams

[UML Class Diagram Tutorial](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-class-diagram-tutorial/)

### Requirements

A Car has one or more engines and a producer. The producer is a manufacturing company who has a brand name.  Engines are produced by a manufacturer and have a speed. There are only two types of engines within UNSW's cars:

    Thermal Engines, which have a default max speed of 114, although they can be produced with a different max speed, and the max speed can change to any value between 100 and 250.

    Electrical Engines, which have a default max speed of 180. This is the speed at which they are produced, and the max speed can change to any value that is divisible by 6.

Cars are able to drive to a particular location x, y.

Since UNSW is a world-leader in technology innovation, they want you to be able to model the behaviour of Time Travelling for any vehicle, and to model a time travelling car. A vehicle that travels in time stays in the same location but travels to a LocalDateTime.

**Create a UML diagram which models the domain.**


## JavaDoc

Look at `src/employee`.

Create an Employee class which has private fields for an employee's name and salary and appropriate getters, setters, and constructors. Document the class with JavaDoc.

[How to Write Doc Comments for the Javadoc Tool](https://www.oracle.com/au/technical-resources/articles/java/javadoc-tool.html)


## Inheritance and Polymorphism

1. How many constructors should the class have? What arguments should they take?


Create a Manager class that is a subclass of Employee and has a field for the manager's hire date.

2. What constructors are appropriate?


3. Is appropriate to have a getter for the hire date? What about a setter?


Override the toString() method inherited from Object in both classes.

4. What should the result of toString() contain?


5. Does the method in Manager call the one in Employee?

