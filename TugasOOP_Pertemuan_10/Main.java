public class Main {
    public static void main(String[] args) {
        Potion potionAttack = new Potion("Fire Potion", "Rare", 50.0, 5, 30, "Attack");
        Potion potionHeal = new Potion("Healing Potion", "Common", 30.0, 5, 20, "Heal");
        Sword sword = new Sword("Excalibur", "Legendary", 150.0, 50);
        Shield shield = new Shield("Dragon Shield", "Epic", 100.0, 40);

        potionAttack.info();
        potionHeal.info();
        sword.info();
        shield.info();

        potionAttack.use("Attack");
        potionHeal.use("Heal");
        sword.use("Attack");
        shield.use("Defend");
    }
}