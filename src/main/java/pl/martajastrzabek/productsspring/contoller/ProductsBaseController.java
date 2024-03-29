package pl.martajastrzabek.productsspring.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.martajastrzabek.productsspring.model.Product;
import pl.martajastrzabek.productsspring.model.ProductCategory;
import pl.martajastrzabek.productsspring.repository.ProductsRepository;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductsBaseController {
    private ProductsRepository productsRepository;

    public ProductsBaseController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
        productsRepository.addProduct("Czekolada Milka", BigDecimal.valueOf(3.29), ProductCategory.GROCERY);
        productsRepository.addProduct("Gazeta Wyborcza", BigDecimal.valueOf(2.99), ProductCategory.OTHER);
        productsRepository.addProduct("Proszek do prania", BigDecimal.valueOf(22.99), ProductCategory.DOMESTIC);
        productsRepository.addProduct("Bułka Kajzerka", BigDecimal.valueOf(0.55), ProductCategory.GROCERY);
        productsRepository.addProduct("Papier toaletowy", BigDecimal.valueOf(12.56), ProductCategory.DOMESTIC);
        productsRepository.addProduct("Szynka Wiejska", BigDecimal.valueOf(6.29), ProductCategory.GROCERY);
    }

    @GetMapping("/products")
    @ResponseBody
    public String printProductsAndPriceSum(@RequestParam(required = false) ProductCategory category) {
        List<Product> productList;
        if (category == null){
            productList = productsRepository.getProductsList();
        }
        else {
            productList = productsRepository.getProductsList(category);
        }

        return convertListToString(productList) + "Suma cen produktów wynosi: " + productsRepository.countPriceSum(productList) ;
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam BigDecimal price, @RequestParam ProductCategory category) {
        if (!name.isEmpty() && price != null && category != null) {
            productsRepository.addProduct(name, price, category);
            return "/success.html";
        } else {
            return "/err.html";
        }
    }

    private String convertListToString(List<Product> list){
        String listToString = "";
        for (Product p : list){
            listToString += p.toString() + "</br>";
        }
        return listToString;
    }





}
