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

    public String printProductsList(ProductCategory category) {
        String productsToString = "";
        for (Product p : productsList) {
            if (category == ProductCategory.ALL) {
                productsToString += p.toString() + "</br>";
            } else if (p.getCategory() == category) {
                productsToString += p.toString() + "</br>";
            }
        }
        countPriceSum(category);

        return productsToString + "</br>" + "Suma cen produktów: " + countPriceSum(category);
    }

    private BigDecimal countPriceSum(ProductCategory category) {
        BigDecimal sum = new BigDecimal("0");
        for (Product p : productsList) {
            if (category == ProductCategory.ALL) {
                sum = sum.add(p.getPrice());
            } else if (p.getCategory() == category) {
                sum = sum.add(p.getPrice());
            }
        }
        return sum;
    }

}
