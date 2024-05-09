public class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(String brand, int year, double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateDiscount() {
        double discount = super.calculateDiscount();
        if (cargoCapacity > 2000) {
            discount += 0.1 * rentalPrice;
        }

        return discount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Detail Truck :");
        super.displayInfo();
        System.out.println("Kapasitas Kargo : " + cargoCapacity);
        System.out.println("Total Diskon : " + calculateDiscount());
        System.out.println("Harga sewa setelah diskon : " + calculateFinalPrice());
        System.out.println("--------------------------------------------------");
    }
}
