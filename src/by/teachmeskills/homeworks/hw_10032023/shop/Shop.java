package by.teachmeskills.homeworks.hw_10032023.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;


    public Shop(List<Product> products) {

        this.products = products;
    }

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        if (products.contains(product)) {
            throw new EntityAlreadyExistsException("Product с таким id уже существует");
        }
        products.add(product);
    }

    public List<Product> getAllProducts() throws EmptyProductListException {
        if (products.isEmpty()) {
            throw new EmptyProductListException("No products found");
        }
        return products;
    }

    public void deleteProduct(int id) throws EmptyProductListException, EntityNotFoundException {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                return;
            }
        }
        for (Product p : products) {
            if (p.getId() != id) {
                throw new EntityNotFoundException("Product with <id> not found");
            }
        }
        throw new EmptyProductListException();
    }


    public void editProduct(Product product) throws EmptyProductListException, EntityNotFoundException {
        if (products.isEmpty()) {
            throw new EmptyProductListException();
        } else if (!products.contains(product)) {
            throw new EntityNotFoundException("Product with <id> not found");
        }
        int x = products.indexOf(product);
        products.set(x, product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}