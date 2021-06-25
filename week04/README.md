# Tutorial 04

## A. Requirements Analysis Revision

### Part 1

a. Discuss the structure of this user story as a class, and create some acceptance criteria (Given/When/Then and Yes/No).

**As someone who uses GitLab, I want to be able to see all of my repositories currently 'active' so that I don't have to sift through old repos to find my current projects.**

AC: Given the repositories page is being displayed, when I click the 'active' button then non-active repositories will no longer be displayed.
AC: Given the 'active' button is clicked, when I search for repositories then only active repositories will be displayed in the results.
AC: There is a green 'active' button in the top left of every page.
AC: Active repositories have a green dot displayed left of repository name.

b. What are story points? See [this Atlassian guide](https://www.atlassian.com/agile/project-management/estimation) for more information.

A story point is a relative estimation of the length of time a task will take. It avoids problems that occur when giving tasks set deadlines.

It's standard practice to uses fibonacci numbering (1, 1, 2, 3, 5, 8, 13, ...) to make estimations.

c. How do we prioritise user stories and epic stories? See [this guide](https://www.productplan.com/learn/prioritize-product-backlog/) for more information.

High priority - we MUST have this, or else we don't have a product

Medium priority - useful and make the product stand out, but not absolutely vital

Low priority - nice to have, but aren't essential

### Part 2

In groups, create user stories and acceptance criteria for the following requirements. Structure these stories under at least one epic story.

**As a creatively minded individual I want to ability to create beautiful art like the following french duck.**

![Le Quack](lequack.png)

To accomplish this I need the following, you have to

- The ability to draw shapes such as rectangles and ovals, you should be able to give shapes constant aspect ratios by holding shift while dragging
- The ability to select a region then perform operations on it, regions are selected via a box
  - You can delete a region with ctrl + d
  - You can paste a region with ctrl + v, this won't clear the old region and will just paste it (i.e. copy + paste)

Other features that exist that you don't need to write a user story for are:

- The ability to paint using a brush like tool
- The ability to remove mistakes
- The ability to save my picture out to a location of my choosing
- The ability to load an image onto the canvas by clicking the image load tool, selecting the image you want to insert, then clicking where you want to insert it.
  - After placing the image it should return to just the simple cursor.
- The ability to change colours using a colour wheel for the strokes and shapes
- A new pipette tool that appears next to the colour selector that lets you pick the stroke/fill colour based upon the canvas.

Epic “POC/MVP - Quaint Shapes” or "Implement Shapes" are both acceptable here.

U: 1. As a user I want the ability to draw shapes by dragging out a region so I can make more interesting art

    AC: 1. A rectangle tool (with image "rect.png") and oval tool (with image "oval.png") should be added
    AC: 2. Clicking on the tool, should activate a 'shape' mode which will then begin showing a preview of the shape when I begin to drag (dashed outline)
    AC: 3. On finishing the drag, the shape should be placed onto the canvas
    AC: 4. Pressing escape at any point during the process prior to finishing the drag should end the shape drawing and not output anything to the canvas


U: 2. As a user I want the ability to drag shapes with a constant ratio of width/height
    AC: 1. In the case of a constant ratio width = height = min(width, height)
    AC: 2. Pressing 'shift' while dragging any sort of shape should activate this
    AC: 3. Letting go of shift should revert to the normal shape drawing mode
    AC: 4. The preview of the shape should also have a constant ratio

U: 3. As a user I want the ability to select a boxed region and manipulate it so I can make changes to my art without having to erase it
    AC: 1. A box select tool (with image "box-select.png") should be added
    AC: 2. On clicking the tool, shape mode should be activated and a preview of my region should be shown when dragging out the select
    AC: 3. On finishing the drag, the selected region should be shown via a dashed outline
    AC: 4. Pressing escape at any point during the process prior to or after dragging should stop the dragging operation and no changes should be applied to the canvas, including the dashed outline of selection
    AC: 5. Pressing Ctrl + d should delete the region, clearing it out from canvas
    AC: 6. Pressing Ctrl + v should paste the region at the current cursor location
    AC: 7. By clicking on the region I should be able to drag it around to change it's location

## B. Patterns - Strategy and State Pattern

### Refactoring Guru

Guides:

- [Strategy Pattern](https://refactoring.guru/design-patterns/strategy)

- [State Pattern](https://refactoring.guru/design-patterns/state)

### Simplified UML

There is a simplified example [here](QuaintSimple.png).

Below is an example of the state pattern. Each state can change `Enemy`'s state (i.e it is aware of other states).

```java
public interface EnemyState {
    public void attack();
}

public class BattleState implements EnemyState {
    public void attack(Enemy enemy) {
        // Do something
        enemy.changeState(new PeacefulState());
    }
}

public class PeacefulState implments EnemyState {
    public void attack(Enemy enemy) {
        // Do something
        enemy.changeState(new BattleState());
    }
}

public class Enemy {
    private EnemyState state;
    
    public void changeState(EnemyState state) {
        this.state = state;
    }
}
```

Below is a bad design since adding any new weapon requires changing the `Character` class.

```java
public class Character {
    public void attack() {
        if (weapon == 'sword') {
            doSomething();
        } else if (weapon == 'stake') {
            doSomething();
        } else if (weapon == 'staff') {
            
        } else if (weapon == 'gun') {
        
        }
    }
}
```

Below is an example of the strategy pattern. New strategies can be made by combining other strategies.

```java
public interface weapon {
    public void use();
}

public class Machette implements Weapon {
    public void use() {
    
    }
}

public class Gun implements Weapon {
    public void use() {
    
    }
}

public class MachetteAndGun implements {
    private Machette machette;
    private Gun gun;
    
    public void use() {
        machette.use();
        gun.use();
    }
}

public class Weapon {
    private Weapon weapon;
    
    public void attack() {
        weapon.use();
    }
}
```

### Quaint

The above specifications have been implemented into a paint application called `quaint`.  It uses strategy patterns to handle various different tools as well as a state pattern to handle the current state of the canvas.

A UML diagram of the design is [here](Quaint.pdf).

## C. Low-Fidelity User Interface Design

Look at the UI we've provided and discuss as a class:
* what's good about it?

- Simple menu bar
- Simple header
- Colour scheme to show active buttons
- Large amount of drawing space
- Drop down menus to save space
- Number fields for quantative options

* What could be better?

- Movement of shapes
- Highlighting of selected elements

The detail below is more than adequate for a low fidelity UI design in the project.

![Le Quack](wireframe.png)
