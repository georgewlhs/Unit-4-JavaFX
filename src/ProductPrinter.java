/**
 * Write a client program ProductPrinter that makes two products, prints the name and price,
 * and reduces their prices by 15%, then prints the name and price again.
 */



public class ProductPrinter {
    public static void main(String[]args){
        Product p1 = new Product("Widget", 10.0);
        Product p2 = new Product("Doodad", 20.0);

        System.out.println(p1);
        System.out.println(p2);

        p1.reducePrice(15);
        p2.reducePrice(15);

        System.out.println(p1);
        System.out.println(p2);


    }
}
