package org.library.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.backend.dto.ProductDTO;
import org.library.backend.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

@Repository
public class ProductDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.sessionFactory = this.entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Transactional
    public void update(int id, ProductDTO productDTO){
        Session session = sessionFactory.getCurrentSession();
        Product productToBeUpdated = session.get(Product.class, id);

        //then iterate over fields
    }
}
