package by.teachmeskills.homeworks.hw_10032023.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EmptyProductListException {
        Shop shop = new Shop();

        Product product0 = new Product(5, "cucumber", 4);
        Product product1 = new Product(4, "watermelon", 15);
        Product product2 = new Product(2, "carrot", 2);
        Product product3 = new Product(3, "tomato", 53);

        try {
            shop.addProduct(product0);
            shop.addProduct(product1);
            shop.addProduct(product2);
            shop.addProduct(product3);
        } catch (EntityAlreadyExistsException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\nИсходный список:" + shop.getAllProducts() + "\n");

        List<Product> listSortByPrice = new ArrayList<>(shop.getAllProducts());
        System.out.println("Сортировка по цене по возрастанию: ");
        listSortByPrice.sort(new ComparatorSortByPrice());
        System.out.println(listSortByPrice);
        System.out.println();

        try {
            shop.deleteProduct(5);
        } catch (EntityNotFoundException | EmptyProductListException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Список после удаления: " + shop.getAllProducts()+ "\n");

        try {
            shop.editProduct(new Product(2, "carrot", 7));
        } catch (EmptyProductListException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Список после редактирования: " + shop.getAllProducts());
    }
}
