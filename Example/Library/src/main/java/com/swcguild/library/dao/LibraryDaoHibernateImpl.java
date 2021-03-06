
package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.HBook;
import com.swcguild.library.model.Publisher;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LibraryDaoHibernateImpl implements HLibraryDao {
    
    //session facotry instead of jdbcTemplate but similar (connection to database)
    private SessionFactory sessionFactory;
    
    @Inject
    public LibraryDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
        
    //convenience method - if you call it, it gives you current session you want to use
    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void addAuthor(Author author) {
        currentSession().save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        currentSession().delete(author);
    }

    @Override
    public void updateAuthor(Author author) {
        currentSession().update(author);
        
    }
    
    

    @Override
    public Author getAuthorById(int id) {  //only gets one object
        return (Author) currentSession().get(Author.class, id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>)currentSession().createCriteria(Author.class).list();   //criteria- we want all authors- turn this into list and return it
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void addBook(HBook book) {
        currentSession().save(book);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void deleteBook(HBook book) {
        currentSession().delete(book);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void updateBook(HBook book) {
        currentSession().update(book);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public HBook getBookById(int id) {
        return (HBook) currentSession().get(HBook.class, id);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
    public List<HBook> getAllBooks() {
        return (List<HBook>) currentSession().createCriteria(HBook.class).list();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void addPublisher(Publisher publisher) {
        currentSession().save(publisher);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void deletePublisher(Publisher publisher) {
        currentSession().delete(publisher);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void updatePublisher(Publisher publisher) {
        currentSession().update(publisher);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public Publisher getPublisherById(int id) {
        return (Publisher) currentSession().get(Publisher.class, id);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) currentSession().createCriteria(Publisher.class).list();
    }
    
}

