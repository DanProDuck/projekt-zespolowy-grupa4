package org.library.backend.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Author {
    @Basic
    @Column(name = "Alternative_name", nullable = true, length = 50)
    private String alternativeName;
    @Basic
    @Column(name = "Author_info", nullable = true, length = 250)
    private String authorInfo;
    @Basic
    @Column(name = "Date_of_birth", nullable = true)
    private Date dateOfBirth;
    @Basic
    @Column(name = "Date_of_death", nullable = true)
    private Date dateOfDeath;
    @Basic
    @Column(name = "Name", nullable = true, length = 30)
    private String name;
    @Basic
    @Column(name = "Surname", nullable = true, length = 30)
    private String surname;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AuthorID", nullable = false)
    private int authorId;

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

        if (authorId != author.authorId) return false;
        if (alternativeName != null ? !alternativeName.equals(author.alternativeName) : author.alternativeName != null)
            return false;
        if (authorInfo != null ? !authorInfo.equals(author.authorInfo) : author.authorInfo != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(author.dateOfBirth) : author.dateOfBirth != null) return false;
        if (dateOfDeath != null ? !dateOfDeath.equals(author.dateOfDeath) : author.dateOfDeath != null) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (surname != null ? !surname.equals(author.surname) : author.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = alternativeName != null ? alternativeName.hashCode() : 0;
        result = 31 * result + (authorInfo != null ? authorInfo.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (dateOfDeath != null ? dateOfDeath.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + authorId;
        return result;
    }
}
