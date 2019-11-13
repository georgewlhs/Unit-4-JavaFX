/**
 * Product. A product has a name and a price, for example new Product(“Toaster”, 29.95). Supply methods getName(),
 * getPrice(), and reducePrice(int r)
 * (Note: reducePrice reduces the price by the percentage r).
 */


public class Product {
    private String name;
    private double price;

    public Product(String productName, double productPrice){
        name = productName;
        price = productPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void reducePrice(int r){
        price = (price * (1 - r/100.0));
    }

    public String toString(){
        return "The product: " + name + ", costs $" + price;
    }
}
