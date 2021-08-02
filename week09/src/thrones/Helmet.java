package thrones;

import java.util.List;

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

new ChainMail(new Helmet(new King(0, 0)));
