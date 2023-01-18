package org.library.backend.repositories;

import org.library.backend.dto.ProductListDTO;
import org.library.backend.models.Product;
import org.library.backend.util.constants.ProductType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query("update Product p set p.buyPrice = ?1, p.dateOfIssue = ?2, p.description = ?3, p.isForRent = ?4, p.isOnSale = ?5, p.pictureUrl = ?6, p.quantity = ?7, p.rating = ?8, p.rentPrice = ?9, p.title = ?10 " +
            "where p.id = ?11")
    void updateBuyPriceAndDateOfIssueAndDescriptionAndIsForRentAndIsOnSaleAndPictureUrlAndQuantityAndRatingAndRentPriceAndTitleById(BigDecimal buyPrice, LocalDate dateOfIssue, String description, Boolean isForRent, Boolean isOnSale, String pictureUrl, Integer quantity, BigDecimal rating, BigDecimal rentPrice, String title, Integer id);
    List<ProductListDTO> findByType(ProductType type, Pageable pageable);
}