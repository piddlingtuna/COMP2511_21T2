package thrones;

import java.util.List;

/**
 * A base character in template pattern.
 * This 
 */
public abstract class CharacterBase implements Character {
    private int healthPoints;

    private int x, y;

    public CharacterBase(int x, int y) {
        healthPoints = 100;
        this.x = x;
        this.y = y;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Cause this character the given amount of damage.
     *
     * @param points
     */
    public void damage(int points) {
        healthPoints -= points;
    }
    
    /**
    * This is a hook. By default, there is no behaviour.
    * However, it lets subclasses add behaviour in the algorithm (`makeMove` method).
    */
    public void specialAction() {}

    /**
     * Attempts to make a move to a square in the game, given all of the characters
     * If it is an invalid move, returns INVALID.
     * If it is a valid move but the square is occupied, attacks the character and returns ATTACK
     * If it is a valid move and the square is free, returns SUCCESS
     */
    public MoveResult makeMove(int x, int y, List<Character> characters) {
        // This function uses two abstract methods (AKA 'hook methods') which the concrete classes must implement
        if (!canMove(this.x - x, this.y - y)) {
            return MoveResult.INVALID;
        }
        
        specialAction();

        for (Character character : characters) {
            if (character != this && character.getX() == x && character.getY() == y) {
                attack(character);
                return MoveResult.ATTACK;
            }
        }
        
        this.x = x;
        this.y = y;

        return MoveResult.SUCCESS;
    }
    
    /*
    public MoveResult makeMove(...) {
        return strategy.makeMove();
    }
    
    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    */

    @Override
    public String toString() {
        return getClass().getSimpleName() + " at (" + getX() + ", " + getY() + "), health = " + healthPoints;
    }
    
     /**
     * This character attacks the given victim, causing them damage according to
     * their rules.
     *
     * @param victim
     */
    public abstract void attack(Character victim);

    /**
     * Can this character move by the given amount along the x and y axes.
     *
     * @param x
     * @param y
     * @return True if they can move by that amount, false otherwise
     */
    public abstract boolean canMove(int dx, int dy);

}
