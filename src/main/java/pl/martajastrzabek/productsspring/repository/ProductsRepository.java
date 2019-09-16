package pl.martajastrzabek.productsspring.repository;

import org.springframework.stereotype.Repository;
import pl.martajastrzabek.productsspring.model.Product;
import pl.martajastrzabek.productsspring.model.ProductCategory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {

    private List<Product> productsList = new ArrayList<>();

    public void addProduct(String name, BigDecimal price, ProductCategory category) {
        productsList.add(new Product(name, price, category));
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public List<Product> getProductsList(ProductCategory category) {
        List<Product> productsFromCategory = new ArrayList<>();
        for (Product p : productsList) {
            if (p.getCategory() == category) {
                productsFromCategory.add(p);
            }
        }
        return productsFromCategory;
    }

    public BigDecimal countPriceSum(List<Product> products) {
        BigDecimal sum = new BigDecimal("0");
        for (Product p : products) {
            sum = sum.add(p.getPrice());
        }
        return sum;
    }

}
