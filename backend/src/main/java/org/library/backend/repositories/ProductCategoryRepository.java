package org.library.backend.repositories;

import org.library.backend.models.ProductCategory;
import org.library.backend.models.ProductCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {
}