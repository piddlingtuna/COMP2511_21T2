package thrones;

/**
 * A queen can move to any square, and has a 1 in 3 chance of inflicting 12 points of damage or a
 * 2 out of 3 chance of inflicting 6 points of damage.
 *
 * MegaQueen uses the template pattern.
 */
public class MegaQueen extends Queen {
    public MegaQueen(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMove(int dx, int dy) {
        return true;
    }
}
