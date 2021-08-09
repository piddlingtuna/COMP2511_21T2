package thrones;

/**
 * A mega dragon can only move up, down, left or right, and inflicts 30 points of damage.
 *
 * MegaDragon uses the template pattern.
 */
public class MegaDragon extends Dragon {

    public MegaDragon(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void attack(Character victim) {
        victim.damage(30);
    }
}
