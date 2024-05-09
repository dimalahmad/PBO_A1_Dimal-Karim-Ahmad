public class Entity {
    protected int hp;
    protected int level;

    public Entity(int hp, int level) {
        this.hp = hp;
        this.level = level;
    }

    public void entityInfo() {
        System.out.println("# ENTITY DENGAN LEVEL : " + level + " DAN HP : " + hp);
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }
}
