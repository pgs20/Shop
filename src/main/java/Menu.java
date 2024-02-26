import java.util.Scanner;
// Принцип единственной ответственности
public class Menu {
    public void menu() {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Здравствуйте! Добро пожаловать в наш магазин!");
            Catalog catalog = new Catalog();
            Basket basket = Basket.getInstance();
            System.out.println("Вот доступные товары для покупки:");
            catalog.showCatalog();
            while (true) {
                System.out.println("Доступные действия:\n1. Сначала дешевле\n2. Сначала дороже");
                switch (scanner.nextInt()) {
                    case 1:
                        catalog.cheaperFirst().showCatalog();
                        break;
                    case 2:
                        catalog.expensiveFirst().showCatalog();
                        break;

                }
            }

        } finally {

        }
    }
}
