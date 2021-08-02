package thrones;

/**
 * A dragon can only move up, down, left or right, and has a 1 in 6 chance of
 * inflicting 20 points of damage.
 *
 */
public class Dragon extends CharacterBase {

    public Dragon(int x, int y) {
        super(x, y);
    }

    @Override
    public void attack(Character victim) {
        if (Math.random() < 1.0/6)
            victim.damage(20);
    }

    @Override
    public boolean canMove(int dx, int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        return (dx == 0 || dy == 0);
    }

}

// new Dragon(new Random(System.currentTimeMillis()).nextInt(), new Random(System.currentTimeMillis()).nextInt());
