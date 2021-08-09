package thrones;

/**
 * A queen can move to any square in the same column, row or diagonal as she is
 * currently on, and has a 1 in 3 chance of inflicting 12 points of damage or a
 * 2 out of 3 chance of inflicting 6 points of damage.
 *
 * Queen uses the template pattern.
 */
public class Queen extends CharacterBase {
    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public void attack(Character victim) {
        if (Math.random() < 1.0/3) {
            victim.damage(12);
        } else if (Math.random() < 2.0/3) {
            victim.damage(6);        
        }
    }

    @Override
    public boolean canMove(int dx, int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        return (dx == 0 || dy == 0 || dx == dy);
    }
}
