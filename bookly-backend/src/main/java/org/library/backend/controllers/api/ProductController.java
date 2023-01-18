package org.library.backend.controllers.api;

import org.library.backend.dto.ProductDTO;
import org.library.backend.dto.ProductListDTO;
import org.library.backend.models.Product;
import org.library.backend.repositories.ProductRepository;
import org.library.backend.util.constants.ProductType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ProductListDTO> index(@RequestParam Optional<String> type,
                                      @RequestParam Optional<String> page,
                                      @RequestParam Optional<String> itemsPerPage) {

        if (type.isPresent()) {
            if(page.isPresent() && itemsPerPage.isPresent()) {
                return productRepository.findByType(ProductType.valueOf(String.valueOf(type)),
                        PageRequest.of(Integer.parseInt(page.get()), Integer.parseInt(itemsPerPage.get())));
            }
            return productRepository.findByType(ProductType.valueOf(String.valueOf(type)), null);
        }
        if(page.isPresent() && itemsPerPage.isPresent()) {
            Page<Product> productsPage =
                    productRepository.findAll(PageRequest.of(Integer.parseInt(page.get())-1, Integer.parseInt(itemsPerPage.get())));
            Type listType = new TypeToken<List<ProductListDTO>>() {
            }.getType();
            return modelMapper.map(productsPage.getContent(), listType);
        }

        List<Product> products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductListDTO>>() {
        }.getType();

        return modelMapper.map(products, listType);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addNewProduct(@RequestBody ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        productRepository.save(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);


        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/totalNumber")
    public long countProducts() {
        return productRepository.count();
    }
}
