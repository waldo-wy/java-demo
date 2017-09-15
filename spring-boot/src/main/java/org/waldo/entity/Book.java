/**
 * @author waldo.wy
 * @date 2017/4/10
 */
package org.waldo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 类Book描述：
 *
 * @author waldo.wy 2017/4/10 16:06
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String isbn;

    @NotNull
    private String title;

    private String description;

    @NotNull
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(@NotNull String isbn, @NotNull String title, @NotNull Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
