# Tutorial 07

## A. Assignment Feedback

- Magic numbers
    - use `private static final int`
- Entity
    - Probably a bit too much abstraction
    - Over engineering
    - Satellite and Device inherit from Entity
- Avoid dynamic typechecks
    - Can be avoided be delegating to classes, subclasses
    - instanceof
- `toJSON` interface
    - Extremely useful
    - Allows delegation to classes
- Data classes
    - getters, setters, nothing else
    - Design smell
    - Try to push functionality to classes
    - Avoid bloating `Blackout`
- Use JavaDocs
- Please write tests
- Please submit
- Use abstract classes

Example of abstract class:
```java
public abstract class Collection {   
    public abstract sort();
}
```

Example with typechecks (avoid):
```java
if (satellite.getType().equals("NasaSatellite")) {
    // do something
} else if (satellite.getType().equals("SovietSatellite")) {
    // do something
}
```

Example without typechecks (preferred):
```java
public abstract class Satellite {
    public abstract void doSomething();
}

public class NasaSatellite extends Satellite {
    @Override
    public void doSomething() {
        // do something
    }
}

satellite.doSomething();
```

## B. Finding Patterns

In groups, determine a possible pattern that could be used to solve each of the following problems:

* Sorting collections of records in different orders.

Strategy

Depending on nature of data or order, a different sorting algorithm is needed.


* Modelling a file system.

Composite

The composite pattern is used for anything tree like. A good example is goals in the project...


* Updating a UI component when the state of a program changes.

Observer pattern

```java
public class Button {
    private void subscribers;
    
    public void notify() {
        for (all subscriber : subscribers) {
           subscriber.clicked();
        }
    }
}
```


* Parsing and evaluating arithmetic expressions.

Composite

The tree:
   + 
  / \
 5   *
    / \
    6  7

represents the expression:
5 + 6 * 7


* Adjusting the brightness of a screen based on a light sensor.

Observer pattern


## C. Composite Pattern

[Composite Pattern](https://refactoring.guru/design-patterns/composite)

Each expression is either:
- a base case with 0 children.
- a recursive case with 1 or more children.

![Diagram of Composite Pattern](composite_pattern.jpg)


Inside `src/calculator`, use the Composite Pattern to write a simple calculator that evaluates an expression. Your calculator should be able to:

* Add two expressions
* Subtract two expressions
* Multiply two expressions
* Divide two expressions
* Sine of an expression
* Cosine of an expression
* Tangent of an expression

There should be a `Calculator` class as well which can be passed in an expression, and calculate that expression.


## D. Design By Contract

1. What is Design by Contract?

- Specify:
    - preconditions for inputs
    - postconditions for outputs
    - invariants for classes
- The invariants must always be true.
- If the preconditions are met, the postconditions are guaranteed to be true.
- If the postconditions are not met, anything can happen (the program is allowed to crash).


2. Discuss briefly as a class how you have used Design by Contract already in previous courses.

APIs
- hides implementation

Abstract Data Types
- hides implementation
- stack - first in last out (FILO)
- queue - last in last out
- binary search tree

Example of invariant
left < value < right
 4      10       12


3. Discuss how Design By Contract was applied in the Blackout assignment.

- Interface is given for you. The implementation is hiden, so you could implement the interface however you like.
- Postconditions given to you include:
    - Do not account for invalid satellite IDs and device IDs.
    - No two devices would ever occupy the same position.


4. In the `calculator` code, specify a contract for each of the `compute` functions. Hint: for the trig functions, look at the interface of the `Math` functions in the Java documentation. Key edge cases to consider:

    * Dividing by zero
    * `tan(Math.PI / 2)`

5. Will you need to write unit tests for something that doesn't meet the preconditions? Explain why.

No, since it is 'undefined behaviour' if the preconditions are not met.

6. We will now make our code more defensive by throwing an exception on the two edge cases listed above. Define your own custom exception called `CalculatorException`, and change the code so that these edge cases cause this exception to be thrown. Modify your contract accordingly. If you have time, add tests for these conditions as well.

When you update your postconditions, you should include the exceptions thrown.
