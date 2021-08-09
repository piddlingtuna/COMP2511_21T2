package thrones;

/**
 * Helmet uses the decorator pattern.
 */
public class Helmet extends CharacterDecorator {
    private Character character;

    public Helmet(Character character) {
        super(character);
    }

    @Override
    public void damage(int points) {
        character.damage(Math.max(points - 1, 0));
    }
    
    /*
    Example use of Decorator pattern:
    new ChainMail(new Helmet(new King(0, 0)));
    */
}

/*
If the `CharacterDecorator` class was not used,
every decorator class would have to implement all methods
by delegating to the `character`.

public class Helmet implements Character {
    private Character character;

    public Helmet(Character character) {
        this.character = character;
    }
    
    @Override
    public int getHealthPoints() {
        return character.getHealthPoints();
    }

    @Override
    public int getX() {
        return character.getX();
    }

    @Override
    public int getY() {
        return character.getY();
    }

    @Override
    public void damage(int points) {
        character.damage(Math.max(points - 1, 0));
    }

    @Override
    public boolean canMove(int dx, int dy) {
        return character.canMove(dx, dy);
    }

    @Override
    public void attack(Character victim) {
        character.attack(victim);
    }

    @Override
    public MoveResult makeMove(int x, int y, List<Character> characters) {
        return character.makeMove(x,y,characters);
    }

    @Override
    public String toString(){
        return character.toString();
    }  
}
*/
