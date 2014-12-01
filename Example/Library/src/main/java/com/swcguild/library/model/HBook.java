
package com.swcguild.library.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class HBook {

    //any Id will have these 3 annotations
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private int bookId;
    
    @Column(name = "isbn")
    private String isbn;
    
    @Column(name = "title")
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "publisher_id")  //publisher_id is foreign key
    private Publisher publisher;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})  //fetch type eager -get all author objects when query is run  //cascade all- if i update book, update authors
    @JoinTable(name = "books_authors",   //join table=bridge table
            joinColumns = {
                @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "author_id")})
    private Set<Author> authors;                       //Set can't have multiples
    
    @Column(name = "price")
    private BigDecimal price;
   
    @Column(name = "publish_date")
    private Date publishDate;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}