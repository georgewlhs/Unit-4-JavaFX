/**
 * Write a client program ProductPrinter that makes two products, prints the name and price,
 * and reduces their prices by 15%, then prints the name and price again.
 */



public class ProductPrinter {
    public static void main(String[]args){
        Product widget = new Product("Thing1", 10.0);
        Product doodad = new Product("Something", 20.0);

        System.out.println(widget);

        System.out.println(widget.getName());
        System.out.println(widget.getPrice());
        System.out.println(doodad.getName());
        System.out.println(doodad.getPrice());

        widget.reducePrice(15);
        doodad.reducePrice(15);

        System.out.println(widget.getName());
        System.out.println(widget.getPrice());
        System.out.println(doodad.getName());
        System.out.println(doodad.getPrice());


    }
}
