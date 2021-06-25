# Tutorial

## A. Code Review & Questions 

In your project groups, answer the following questions. 

1. Can you override a static method?

No - a static method is attached to the class, not the instance.

2. What is output by executing `A.f()` in the following?

```java
public class A {
    public static void f() {
        C c = new C();
        c.speak(); // "quack"
        B b = new C();
        c.speak();
        // D d = new B(); not safe
        b.speak(); // "quack"
        b = new B();
        b.speak(); // "moo"
        c.speak(); // "quack"
    }
    /*
    Output:
    quack
    quack
    moo
    quack
    */
}

public class B {
    public void speak() {
        System.out.println("moo");
    }
}

public class C extends B {
    @Override
    public void speak() {
        System.out.println("quack");
    }
}

public class D extends C {
    private int privateAttribute;
    
    @Override
    public void speak() {
        System.out.println("hello");
        System.out.println(privateAttribute);
    }
}
```

Below is an example where it is better to use an interface over a superclass.

```java
public interface Drawer {
    public void draw();
}

public class Rectangle implements Drawer {
    private int width;
    private int height;
    
    public void draw() {
    
    }
}

public class Square implements Drawer {
    private int side;
    
    public void draw() {    
}
```

Below is a problematic case of inheritance.

```java
public class Bird {    
    public void fly() {
    
    }
}

public class Penguin extends Bird {
    public void fly() {
        throw new Exception("Penguins can't fly");
    }
}
```

Below is an example where it is better to use composition over inheritance.

```java
public interface Flyable() {
    public void fly();
}

public class Wings implements Flyable{
    public void fly() {
    
    }
}

public class Bird implements Flyable {
    private Wings wings;
    
    public void fly() {
        wings.fly();
    }
}

public class Penguin {
    // No fly method
}
```

3. What is output by executing `A.f()` in the following?

```java
public class A {
    public static void f() {
        B b1 = new B();
        B b2 = new B();
        b1.incX();
        b2.incY();
        System.out.println(b1.getX() + " " + b1.getY());
        System.out.println(b2.getX() + " " + b2.getY());
    }
    /*
    Output:
    1 1
    0 1
    */
}

public class B {
    private int x; // instance
    private static int y; // class

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incX() {
        x++;
    }

    public void incY() {
        y++;
    }
}
```

## B. Design Principles


### Part 1: Law of Demeter

In the `unsw.training` package there is some skeleton code for a training system. 

* Every employee must attend a whole day training seminar run by a qualified trainer
* Each trainer is running multiple seminars with no more than 10 attendees per seminar

In the TrainingSystem class there is a method to book a seminar for an employee given the dates on which they are available. This method violates the principle of least knowledge (Law of Demeter).

1. How and why does it violate this principle?

The `TrainingSystem` should only be interacting with 'friends'. This means it shouldn't call methods on objects returned from methods. No doing this:
```java
object.getSomething().doSomething()
```

2. In violating this principle, what other properties of this design are not desirable?

- The design is very tighly coupled. `TrainingSystem` is dependent on both `Trainer` and `Seminar`.
- `TrainingSystem` has low cohesion as any change to the system means you have to change this class.
- `Seminar` is poorly encapsulated. It should control the number of attendees and not rely on `TrainingSystem`.

3. Refactor the code so that the principle is no longer violated. How has this affected other properties of the design?

Basically fix the problems in 2.

4. More generally, are getters essentially a means of violating the principle of least knowledge? Does this make using getters bad design?

Getters can make classes mre reusable, although they can be used to violate the principle of least knowledge. Try to only use getters for immutable data. Instead of `getAttendees()` (which returns a mutable `List`), create a copy or use `Collections.unmodifiableList(...)`. You could also create `addAttendee()` and `removeAttendee()` to allow clients to change attendees in a controlled manner.

### Part 2: Liskov Substitution Principle

Look at the `OnlineSeminar` class. How does this violate the Liskov Substitution Principle?

`OnlineSeminar` is very different from `Seminar`. It does not have a list of attendees and so a clinet interacting with a `Seminar` might have trouble if it is instead provided with a `OnlineSeminar`, which is possible since it's a subclass.

## C. Testing with JUnit 

1. What is the difference between unit and integration testing?

Unit testing is used to make sure a small piece of code works in isolation

integration testing tests to make sure different pieces of codes work together

2. What does test-driven development look like in Java? 

- Define the API (class declarations)
- Write (black box) tests
- Implement all functionality
- Pass the tests

3. Inside the `src/unsw` folder is `archaic_fs` and `test` that mocks a very simple file system and tests it respectively, you can see 3 already written in there.

    - This simulates a 'linux' like Inode system (arguably pretty badly but we'll extend on it next week to be better).  You don't have to understand how it works under the hood, since it mocks the typical linux commands.
    - Commands available;
        - `cd(path)`
            - Throws NoSuchFileException is a part of the path can't be found
        - `mkdir(path, createParentDirectories, ignoreIfExists)`
            - Throws FileNotFoundException if a part of the path can't be found and createParentDirectories is false
            - Throws FileAlreadyExistsException if the folder already exists and ignoreIfExists is false
        - `writeToFile(path, content, opts)`
            - Options are a EnumSet of FileWriteOptions i.e. `EnumSet.of(FileWriteOptions.APPEND, FileWriteOptions.CREATE)` the full set is: CREATE, APPEND, TRUNCATE, CREATE_IF_NOT_EXISTS
            - Throws FileNotFoundException if the file can't be found and no creation options are specified
            - Throws FileAlreadyExistsException if the file already exists and CREATE is true
        - `readFromFile(path)` returns the content for a given file.
            - Throws FileNotFoundException if the file can't be found

**Write at least 2 more unit tests and 1 integration test.**

More information on JUnit can be found [here](https://www.vogella.com/tutorials/JUnit/article.html).

4. Coverage testing! After doing above you can check the coverage of your tests by running the command `$ gradle test -b test.gradle`

The output is under `build/reports/jacoco/test/html/index.html` you can open this in a browser.
