package pl.edu.pwr.carpartsshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
import pl.edu.pwr.carpartsshop.product.service.ProductService;

import java.util.List;

/**
 * Created by lukasz on 1/27/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/addProduct/{id}")
    public String addProduct(@PathVariable String id, @RequestBody ProductDto productDto) {
        productService.saveProduct(id,productDto);
        return "Executed adding product to database";
    }
    @RequestMapping("/showProducts")
    public List<ProductDto> showProducts(){
        return productService.getProducts();
    }
}
