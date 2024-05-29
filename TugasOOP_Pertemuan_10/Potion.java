public class Potion extends Item implements Usable {
    private int duration;
    private int effectPoint;
    private String type;
    public Potion(String name, String rank, double price, int duration, int effectPoint, String type) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.type = type;
    }
    public void use(String input) {
        if (input.equalsIgnoreCase("Attack")) {
            System.out.println("\nUsing " + getName() + " as Attack:");
            System.out.println("Damage dealt by " + effectPoint);
        } else if (input.equalsIgnoreCase("Heal")) {
            System.out.println("\nUsing " + getName() + " as Heal:");
            System.out.println("Healed by " + effectPoint);
        } else {
            System.out.println("Invalid input");
        }
    }
    public int getDuration() {
        return duration;
    }
    public int getEffectPoint() {
        return effectPoint;
    }
    public String getType() {
        return type;
    }
    public void info() {
        super.info();
        System.out.println("Duration: " + duration);
        System.out.println("Effect Point: " + effectPoint);
        System.out.println("Type: " + type);
    }
}
