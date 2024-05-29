abstract class Item implements Infoable {
    protected String name;
    protected String rank;
    protected double price;

    public Item(String name, String rank, double price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public double getPrice() {
        return price;
    }

    public void info() {
        System.out.println("\nItem: " + name);
        System.out.println("Rank: " + rank);
        System.out.println("Price: " + price);
    }
}