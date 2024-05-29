public class Shield extends Item implements Usable {
    private int damageBlock;
    public Shield(String name, String rank, double price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }
    public void use(String input) {
        if (input.equalsIgnoreCase("Defend")) {
            System.out.println("\nUsing " + getName() + " to Defend:");
            System.out.println("Damage mitigated by " + damageBlock);
        } else {
            System.out.println("Invalid input");
        }
    }
    public int getDamageBlock() {
        return damageBlock;
    }
    public void info() {
        super.info();
        System.out.println("Damage Block: " + damageBlock);
    }
}