//package pl.edu.pwr.carpartsshop;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.edu.pwr.carpartsshop.product.model.dto.ProductDto;
//import pl.edu.pwr.carpartsshop.product.service.ProductService;
//
//import java.sql.SQLException;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by lukasz on 1/12/17.
// */
//@SpringBootTest
//@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class ProductServiceTest {
//    @Autowired
//    private ProductService productService;
//
//    private ProductDto productDto = ProductDto.builder()
//            .id(123)
//            .company("TESLA")
//            .name("Brakes")
//            .price(12.3)
//            .amount(123)
//            .build();
//
//    @Test
//    public void saveProduct() throws SQLException {
//        ProductDto productDto = productService.saveProduct(this.productDto);
//        assertEquals(this.productDto.toString(),productService.getProduct(productDto.getId()).toString());
//    }
//    @Test
//    public void updateProduct() throws SQLException {
//        this.productDto = productService.saveProduct(this.productDto);
//        this.productDto.setCompany("Emano");
//        productService.updateProduct(this.productDto);
//        assertEquals(this.productDto,productService.getProduct(this.productDto.getId()));
//    }
//    @Test
//    public void getProducts() throws SQLException {
//        ProductDto productDto = productService.saveProduct(this.productDto);
//        ProductDto productDto1 = productService.saveProduct(ProductDto.builder()
//                .price(123.2)
//                .name("test")
//                .amount(123)
//                .company("qqq")
//                .build());
//
//        assertEquals(2,productService.getProducts().size());
//    }
//    @Test
//    public void shouldDeleteProducts() throws  SQLException {
//        ProductDto productDto = productService.saveProduct(this.productDto);
//        ProductDto productDto1 = productService.saveProduct(ProductDto.builder()
//                .price(123.2)
//                .name("test")
//                .amount(123)
//                .company("qqq")
//                .build());
//
//        productService.deleteProduct(productDto1);
//        assertEquals(1,productService.getProducts().size());
//    }
//}
