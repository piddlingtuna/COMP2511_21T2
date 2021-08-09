# Tutorial 09

## Updates

- Milestone 2 hasn't been marked yet (sorry). I will email feedback instead.
- No lab this week. Next week, Jun will join the demos.
- Exam structure is out [here](https://www.cse.unsw.edu.au/~cs2511/21T2/SampleExam/SampleExam.html).
- Make sure JUnit works. It will be used in the exam.


## A. Builder Pattern 

The Builder pattern is used to avoid really complex construction like:
```java
public class House {
    public House(Windows windows, Doors doors, HasSwimmining hasSwimming, ...) {
        this.windows = windows;
        this.doors = doors;
        this.hasSwimming = hasSwimming;
        ...    
    }
}
```

```java
public class House {
    public static HouseBuilder createBuilder() {
        return new HouseBuilder();
    }
}

public class HouseBuilder {

    private Windows windows
    
    public HouseBuilder addWindows(Windows windows) {
    
    }
    
    public HouseBuilder makeFancyHouse(HouseBuilder builder) {
       return builder.addExpensiveDoors();
    }
    
    public House construct() {
        return new House(windows, ...)
    }
}
```

```java
House.createBuilder() // returns HouseBuilder
.addWindows(windows) // returns HouseBuilder
.addSwimmingPool()
.construct(); // 
```

```java
House.createBuilder() // returns HouseBuilder
.addWindows(windows) // returns HouseBuilder
.addSwimmingPool()
```

If each method did not return the `HouseBuilder`, code would look uglier:
```java
HouseBuilder builder = House.createBuilder();
builder.addWindows();
builder.addSwimmingPool();
return builder.construct();
```

[Builder Pattern](https://refactoring.guru/design-patterns/builder)

Analyse the testing infrastructure we provided you in the Blackout assignment and how it uses the Builder Pattern to make construction of objects and testing easier.

See the `TestHelper` and `ResponseHelper` classes.


## Game

### B. Template Pattern

[Template Pattern](https://refactoring.guru/design-patterns/template-method)

In a simple game, different types of characters move around on a grid fighting each other. When one character moves into the square occupied by another they attack that character and inflict damage based on random chance (e.g. a dice roll).

* A king can move one square in any direction (including diagonally), and always causes 8 points of damage when attacking.
* A queen can move to any square in the same column, row or diagonal as she is currently on, and has a 1 in 3 chance of inflicting 12 points of damage or a 2 out of 3 chance of inflicting 6 points of damage.
* A dragon can only move up, down, left or right, and has a 1 in 6 chance of inflicting 20 points of damage.

Look at the `CharacterBase` class.

The Template pattern has a similar use case as the Strategy Pattern. A notable difference is that the Template pattern is static (involves extending from abstract classes) while the Strategy pattern is dynamic (can change behaviour during runtime by changign strategy class). The Template pattern is preferred if different behaviours share a common algorithm.


### C. Decorator Pattern

[Decorator Pattern](https://refactoring.guru/design-patterns/decorator)

```python
@app.route("/")
def index():
    return "Hello World!"
```

We want to add different sorts of armour.

* A helmet reduces the amount of damage inflicted upon a character by 1 point.
* Chain mail reduces the amount of damage by a half (rounded down).
* A chest plate caps the amount of damage to 7, but also slows the character down. If the character is otherwise capable of moving more than one square at a time then this armour restricts each move to distances of 3 squares or less (by manhattan distance).

Assume that, as this game takes place in a virtual world, there are no restrictions on the number of pieces of armour a character can wear and that the "order" in which armour is worn affects how it works.

Look at the `CharacterDecorator` class.


### D. Factory Pattern

[Factory Pattern](https://refactoring.guru/design-patterns/factory-method)

We now want to refactor the code so that when the characters are created, they are put in a random location in a grid of length 5. 

1. How does the Factory Pattern allow us to abstract construction of objects, and how will it improve our design with this new requirement?

We can abstract the construction of characters so we don't have to directly deal with constructors. This means we could use a subtype like `MegaQueen` instead of `Queen` without changing the interface of `CharacterFactory.createQueen`. We could also abstract generating random numbers, simplifying object creation.


2. Use the Factory Pattern to create a series of object factories for each of the character types, and change the `main` method of `Game.java` to use these factories.

See `src/thrones/CharacterFactory.java`.
