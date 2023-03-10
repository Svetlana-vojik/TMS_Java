package by.teachmeskills.homeworks.hw_10032023.shop;

import java.util.List;

public class Shop {
    private List<Product> products;


    public Shop(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        if (products.contains(product)) {
            throw new EntityAlreadyExistsException("Product с таким id уже существует");
        }
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
