package Limniya.CrudSpring.controller;

import Limniya.CrudSpring.model.Products;
import Limniya.CrudSpring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allproducts")
public class ProductController {

    @Autowired
    private ProductRepository product;

    @PostMapping("/product")
    Products newProduct(@RequestBody Products newProduct){
        return product.save(newProduct);
    }

    @GetMapping("/getprod")
    List<Products> getProducts(){
        return  product.findAll();
    }

    @GetMapping("/product/{id}")
    Optional<Products> getProductById(@PathVariable Long id){
        return product.findById(id);
    }

    @PutMapping("/products/{id}")
    Optional<Products> updateProduct(@RequestBody Products newProduct , @PathVariable Long id){
        return product.findById(id)
                .map(pr -> {
                    pr.setName(newProduct.getName());
                    pr.setDescription(newProduct.getDescription());
                    pr.setPrice(newProduct.getPrice());
                    return product.save(pr);
                });
    }

    @DeleteMapping("/deleteprod/{id}")
    String deleteProduct(@PathVariable Long id){
        product.deleteById(id);
        return "deleted with success";
    }
}
