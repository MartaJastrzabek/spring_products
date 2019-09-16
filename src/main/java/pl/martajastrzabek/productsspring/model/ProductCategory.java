package pl.martajastrzabek.productsspring.model;

public enum ProductCategory {
    GROCERY("spożywcze"),
    DOMESTIC("domowe"),
    OTHER("inne");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
