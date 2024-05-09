import java.util.ArrayList;

public class Merchant extends Entity {
    private ArrayList<String> listItem;

    public Merchant(int level, int hp, ArrayList<String> listItem) {
        super(hp, level);
        this.listItem = listItem;
    }

    public void entityInfo() {
        System.out.println("# MERCHANT DENGAN LEVEL : " + level);
    }

    public void interact() {
        if (hp > 0) {
            System.out.println("Merchant : ");
            System.out.println("Barang yang tersedia hari ini");
            for (String item : listItem) {
                System.out.println("# " + item);
            }
        }
        if (hp <= 0) {
            System.out.println("Merchant : Dah lah males jualan");
            System.out.println("# TIDAK BISA BELI, MERCHANT NGAMBEK");
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int getHp() {
        return hp;
    }
}
