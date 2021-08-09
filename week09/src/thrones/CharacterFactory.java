package thrones;

import java.util.Random;

public class CharacterFactory {
    /*
    The singleton pattern is used when you need an object BUT only want to use a single object.
    Here, objects aren't needed so the singleton pattern is not used.
    */

    private static final Random random = new Random(System.currentTimeMillis());

    // Random coordinates are abstracted.
    public static Dragon createDragon(){
        return new Dragon(random.nextInt(), random.nextInt());
    }
    
    // Constant coordinates are abstracted.
    public static Dragon createDragonAtZero(){
        return new MegaDragon(0, 0);
    }
    
    // Factory can return a subclass of `Dragon`.
    public static Dragon createMysteryDragon(){
        if (Math.random() < 0.5 ) {
            return new MegaDragon(random.nextInt(), random.nextInt());
        }
        return new Dragon(random.nextInt(), random.nextInt());
    }
    
    public static King createKing(){
        return new King(random.nextInt(), random.nextInt());
    }
    
    // Factory can return a subclass of `Queen`.
    public static Queen createQueen(){
        return new MegaQueen(random.nextInt(), random.nextInt());
    }
    
    /*
    If a factory pattern was not used, a Dragon would be created like:
    new Dragon(new Random(System.currentTimeMillis()).nextInt(), new Random(System.currentTimeMillis()).nextInt());
    */
}
