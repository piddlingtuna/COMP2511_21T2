package thrones;

public class OPDragon extends Dragon {

    public OPDragon(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void attack(Character victim) {
        victim.damage(30);
    }
}
