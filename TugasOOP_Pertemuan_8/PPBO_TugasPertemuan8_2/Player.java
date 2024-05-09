public class Player extends Entity {
    private String name;

    public Player(int level, int hp, String name) {
        super(hp, level);
        this.name = name;
    }

    public void entityInfo() {
        System.out.println("# PLAYER DENGAN NAMA : " + name + ", DAN LEVEL : " + getLevel());
    }

    public void interact(Merchant merchant) {
        if (getHp() > 0) {
            merchant.interact();
        } else {
            System.out.println("# TIDAK BISA BELI, PLAYER SUDAH MATI");
        }
    }

    public void attack(Zombie zombie) {
        if (getHp() > 0) {
            int damage = getLevel();
            zombie.takeDamage(damage);
            if (zombie.getHp() <= 0) {
                System.out.println("# ZOMBIE MATI");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void attack(Merchant merchant) {
        if (getHp() > 0) {
            int damage = getLevel(); // Player memberikan damage sebesar level
            merchant.takeDamage(damage);
            System.out.println("merchant : hey heyy, ngapain nyerang");
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (getHp() <= 0) {
            System.out.println("# YOU DIE, GAME OVER");
        } else {
            System.out.println("player : UGHH");
        }
    }
}
