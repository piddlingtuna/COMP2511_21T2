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
    
public abstract class Collection {

    public abstract doSomething();
    
    public abstract sort();

}

satellite.doSomething();
    
if (satellite.getType().equals("NasaSatellite")) {
    // do something
} else if (satellite.getType().equals("SovietSatellite")) {
    // do something
}

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


## B. Finding Patterns

In groups, determine a possible pattern that could be used to solve each of the following problems:

* Sorting collections of records in different orders.
- Strategy
Needs different sorting algorithm depending on order, or nature of data set // From Benjamin


* Modelling a file system.
- Composite
- Tree-like
- Like goals


* Updating a UI component when the state of a program changes.
- Observer pattern

Button

for (all subscribers) {
   subscriber.hey i got clicked
}



Window



* Parsing and evaluating arithmetic expressions.
- Composite
   + 
  / \
 5   *
    / \
    6  7

5 + 6 * 7

5



* Adjusting the brightness of a screen based on a light sensor.
Observer pattern



## C. Composite Pattern

https://refactoring.guru/design-patterns/composite

Advantage
- each expression is flexible
- can have 0 children 1, children, 2 children, 3 children


Inside `src/calculator`, use the Composite Pattern to write a simple calculator that evaluates an expression. Your calculator should be able to:

* Add two expressions
* Subtract two expressions
* Multiply two expressions
* Divide two expressions
* Sine of an expression
* Cosine of an expression
* Tangent of an expression

There should be a `Calculator` class as well which can be passed in an expression, and calculate that expression.

Design a solution, create stubs, write failing unit tests, then implement the functions.

## D. Design By Contract

1. What is Design by Contract?




2. Discuss briefly as a class how you have used Design by Contract already in previous courses.

Abstract Data Types
- hides implementation
- stack - first in last out (FILO)
s.push(5)
s.push(6)
s.pop() == 6
- queue - last in last out
- binary search tree

left < value < right - invariant
 4      10       12
 
 
 
 APIs - desin by contract


3. Discuss how Design By Contract was applied in the Blackout assignment.



4. In the `calculator` code, specify a contract for each of the `compute` functions. Hint: for the trig functions, look at the interface of the `Math` functions in the Java documentation. Key edge cases to consider:

    * Dividing by zero
    * `tan(Math.PI / 2)`

5. Will you need to write unit tests for something that doesn't meet the preconditions? Explain why.

6. We will now make our code more defensive by throwing an exception on the two edge cases listed above. Define your own custom exception called `CalculatorException`, and change the code so that these edge cases cause this exception to be thrown. Modify your contract accordingly. If you have time, add tests for these conditions as well.
