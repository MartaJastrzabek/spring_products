package pl.martajastrzabek.productsspring.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private ProductCategory category;

    public Product(String name, BigDecimal price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + ", cena: " + price + ", kategoria: " + category.getName();
    }
}
