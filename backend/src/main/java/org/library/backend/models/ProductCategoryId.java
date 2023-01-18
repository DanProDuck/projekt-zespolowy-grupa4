package org.library.backend.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductCategoryId implements Serializable {
    private static final long serialVersionUID = -524912779544155637L;
    @NotNull
    @Column(name = "CategoryID", nullable = false)
    private Integer categoryID;

    @NotNull
    @Column(name = "ProductID", nullable = false)
    private Integer productID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductCategoryId entity = (ProductCategoryId) o;
        return Objects.equals(this.productID, entity.productID) &&
                Objects.equals(this.categoryID, entity.categoryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, categoryID);
    }

}