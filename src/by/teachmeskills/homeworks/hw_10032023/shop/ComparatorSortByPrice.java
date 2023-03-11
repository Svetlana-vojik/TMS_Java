package by.teachmeskills.homeworks.hw_10032023.shop;

import java.util.Comparator;

public class ComparatorSortByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}