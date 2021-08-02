package thrones;

import java.util.Random;

public class CharacterFactory {

    // Singleton - when you actually need an object.
    
    /*private CharacterFactory() {
    
    }
    
    public static CharacterFactory { return singleton };*/

    private static final Random random = new Random(System.currentTimeMillis());

    public static Dragon createDragon(){
        return new Dragon(random.nextInt(), random.nextInt());
    }
    
    public static Dragon createMysteryDragon(){
        if (Math.random() < 0.5 ) {
            return new OPDragon(random.nextInt(), random.nextInt());
        }
        return new Dragon(random.nextInt(), random.nextInt());
    }
    
    public static Dragon createDragonAtZero(){
        return new OPDragon(0, 0);
    }
    
    public static King createKing(){
        return new King(random.nextInt(), random.nextInt());
    }
    
    public static Queen createQueen(){
        return new Queen(random.nextInt(), random.nextInt());
    }

}
