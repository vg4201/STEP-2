import java.util.Scanner;

public class ShoppingCart {

    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public ShoppingCart(String cartId, int maximumItems) {
        this.cartId = cartId;
        this.itemPrices = new double[maximumItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount >= itemPrices.length) {
            System.out.println("Cart is full.");
            return;
        }

        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        itemPrices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        ShoppingCart cart =
                new ShoppingCart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: Rs " + cart.getTotal());
        System.out.println("Item count: "
                + cart.getItemCount());
    }
}