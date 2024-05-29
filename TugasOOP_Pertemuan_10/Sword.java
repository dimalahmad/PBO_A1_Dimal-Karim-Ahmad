public class Sword extends Item implements Usable {
    private int damage;
    public Sword(String name, String rank, double price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }
    public void use(String input) {
        if (input.equalsIgnoreCase("Attack")) {
            System.out.println("\nUsing " + getName() + " to Attack:");
            System.out.println("Damage dealt by " + damage);
        } else {
            System.out.println("Invalid input");
        }
    }
    public int getDamage() {
        return damage;
    }
    public void info() {
        super.info();
        System.out.println("Damage: " + damage);
    }
}