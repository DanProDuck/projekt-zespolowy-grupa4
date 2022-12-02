package org.library.backend.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    @Basic
    @Column(name = "Alternative_name")
    private String alternativeName;
    @Basic
    @Column(name = "Author_info")
    private String authorInfo;
    @Basic
    @Column(name = "Date_of_birth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "Date_of_death")
    private Date dateOfDeath;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Surname")
    private String surname;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AuthorID")
    private int authorId;
    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<Product> productsByAuthorId;

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(alternativeName, author.alternativeName) && Objects.equals(authorInfo, author.authorInfo) && Objects.equals(dateOfBirth, author.dateOfBirth) && Objects.equals(dateOfDeath, author.dateOfDeath) && Objects.equals(name, author.name) && Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alternativeName, authorInfo, dateOfBirth, dateOfDeath, name, surname, authorId);
    }

    public Collection<Product> getProductsByAuthorId() {
        return productsByAuthorId;
    }

    public void setProductsByAuthorId(Collection<Product> productsByAuthorId) {
        this.productsByAuthorId = productsByAuthorId;
    }
}
