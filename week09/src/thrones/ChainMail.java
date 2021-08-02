package thrones;

public class ChainMail extends CharacterDecorator {
    public ChainMail(Character character) {
        super(character);
    }
    
    @Override
    public void damage(int points) {
        super.damage(points / 2);
    }
}
