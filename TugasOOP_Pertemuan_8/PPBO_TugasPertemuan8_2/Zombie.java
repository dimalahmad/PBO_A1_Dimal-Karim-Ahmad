public class Zombie extends Entity {
    public enum Types {
        MELEE,
        RANGED
    }

    private Types type;

    public Zombie(int level, int hp, Types type) {
        super(hp, level);
        this.type = type;
    }

    public void entityInfo() {
        System.out.println("# ZOMBIE DENGAN TIPE : " + type + ", DAN LEVEL : " + getLevel());
    }

    public void attack(Player player) {
        if (getHp() > 0) {
            int damage = player.getLevel();
            player.takeDamage(damage);
        } else {
            System.out.println("# ZOMBIE SUDAH MATI");
        }
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (getHp() >= 0) {
            System.out.println("zombie : GRAAA!");
        }
    }
}
