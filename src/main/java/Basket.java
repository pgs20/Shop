import java.util.List;

public class Basket {
    private static Basket basket;
    private List<Product> productBasket = null;
    private double amount = 0;

    private Basket() {}

    public static Basket getInstance() {
        if (basket == null) return basket = new Basket();
        return basket;
    }
    public Basket addInBasket(Product product) {
        this.productBasket.add(product);
        this.amount += product.getPrice();
        return this;
    }

    public Basket removefromBasket(Product product) {
        this.productBasket.remove(product);
        this.amount -= product.getPrice();
        return this;
    }

    public void showBasket() {
        if (productBasket == null) {
            System.out.println("В корзине товаров нет!");
        } else {
            for (int i = 0; i < productBasket.size(); ++i) {
                System.out.println(i + 1 + "). " + productBasket.get(i));
            }
            System.out.println(this);
        }
    }

    public List<Product> getProductBasket() {
        return this.productBasket;
    }

    @Override
    public String toString() {
        return "В корзине " + productBasket.size() + " шт. товара, стоимостью - " + this.amount + "$";
    }



}
