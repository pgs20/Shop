import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private List<Product> catalog = new ParserJsonProduct().parse("dataProduct.json");

    public void showCatalog() {
        for (int i = 0; i < catalog.size(); ++i) {
            System.out.println(i + 1 + "). " + catalog.get(i));
        }
        System.out.println();
    }

    public Catalog cheaperFirst() {
        this.catalog = catalog.stream()
            .sorted(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            })
                .collect(Collectors.toList());
        return this;
    }

    public Catalog expensiveFirst() {
        this.catalog = catalog.stream()
            .sorted(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            })
                .collect(Collectors.toList());
        return this;
    }

    public List<Product> getCatalog() {
        return this.catalog;
    }
}
