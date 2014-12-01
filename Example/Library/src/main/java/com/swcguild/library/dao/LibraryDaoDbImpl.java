package com.swcguild.library.dao;

import com.swcguild.library.model.Author;
import com.swcguild.library.model.Book;
import com.swcguild.library.model.Publisher;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LibraryDaoDbImpl implements LibraryDao {

    private JdbcTemplate jdbcTemplate;

    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //authors sql statements
    private static final String SQL_INSERT_AUTHOR
            = "insert into authors (first_name, last_name, street, city, state, zip, phone) values"
            + "(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_AUTHOR
            = "delete from authors where author_id=?";
    private static final String SQL_UPDATE_AUTHOR
            = "update authors set first_name=?, last_name=?, street=?, city=?, state=?, zip=?, phone=? where author_id=?";
    private static final String SQL_SELECT_AUTHOR
            = "select* from authors where author_id=?";
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID
            = "select au.author_id, au.first_name, au.last_name, au.street, au.city, au.state, au.zip, au.phone "
            + "from authors au"
            + "join books_authors ba on au.author_id=ba.author_id where ba.book_id=?";
    private static final String SQL_SELECT_ALL_AUTHORS
            = "select* from authors";

    
    
    
    
    
    private static final String SQL_INSERT_BOOK
            = "insert into books (isbn, title, publisher_id, price, publish_date) values "
            + "(?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_BOOKS_AUTHORS
            = "insert into books_authors (book_id, author_id) values (?, ?)";
    private static final String SQL_DELETE_BOOK
            = "delete from books where book_id=?";
    private static final String SQL_DELETE_BOOKS_AUTHORS
            = "delete from books_authors where book_id=?";   //delete from bridge table
    private static final String SQL_UPDATE_BOOK
            = "update books set isbn=?, title=?, publisher_id=?, price=?, publish_date=?"
            + "where book_id=?";

    private static final String SQL_SELECT_BOOK
            = "select* from books where book_id=?";
    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID
            = "select author_id from books_authors where book_id=?";
    private static final String SQL_SELECT_ALL_BOOKS
            = "select* from books";
    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID
          //  = "select b.*from books b join books_author ba on author_id where b.book_id=ba.book_id and ba.author_id=?";
   ="select b.*from books b join books_authors ba on b.book_id=ba.book_id and ba.author_id=?";
            private static final String SQL_SELECT_BOOKS_BY_PUBLISHER_ID
            ="select* from books where publsiher_id =?";
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)

    public void addAuthor(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone());
        author.setAuthorId(jdbcTemplate.queryForObject("select LAST INSERT ID()", Integer.class));
    }

    @Override
    public void deleteAuthor(int authorId) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone(),
                author.getAuthorId());
    }

    @Override
    public Author getAuthorById(int authorId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHOR, new AuthorMapper(), authorId);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Author> getAuthorsByBookId(int bookId) {
        return jdbcTemplate.query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS, new AuthorMapper());
    }

    
    
    
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBook(Book book) {
        //first insert into books table
        jdbcTemplate.update(SQL_INSERT_BOOK,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString());
        book.setBookId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        //now insert into the ooks_authors table
        insertBooksAuthors(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(int bookId) {
        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, bookId);
        jdbcTemplate.update(SQL_DELETE_BOOK, bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(Book book) {
       jdbcTemplate.update(SQL_UPDATE_BOOK,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString(),
                book.getBookId());
       jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, book.getBookId());  //have to delete out of books_authors first (ref integrity)
       insertBooksAuthors(book);
               
    }

    @Override
    public Book getBookById(int bookId) {
        //have to get authorId's as well
        try{
        Book b= jdbcTemplate.queryForObject(SQL_SELECT_BOOK, new BookMapper(), bookId);
        int[] idArray= getAuthorIdsForBook(b);
        b.setAuthorIds(idArray);
        return b;
        
        }catch(EmptyResultDataAccessException e){
        return null;
        }
    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bList=jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper());
        //get all authors for each book in my list
        for (Book b: bList){
        b.setAuthorIds(getAuthorIdsForBook(b));
        
        }
        return bList;
    }

    @Override
    public void addPublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePublisher(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publisher getPublisherByBookId(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publisher> getAllPublishers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //helper methods- used above- anonymous inner class
    
    private void insertBooksAuthors(Book book){
    final int bookId=book.getBookId();
    final int [] authorIds=book.getAuthorIds();
    //use batch update to send eveything in one request
    //anonymous inner class
    jdbcTemplate.batchUpdate(SQL_INSERT_BOOKS_AUTHORS, new BatchPreparedStatementSetter() {
      
        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(1, bookId);
        ps.setInt(2, authorIds[i]);
        
        }
        @Override
        public int getBatchSize(){
        return authorIds.length;
        
        }
            
    });
    
    }
    
    private int[] getAuthorIdsForBook (Book book) {
        //get a list of author ids from the books_authors table
        List<Integer> authorIds= jdbcTemplate.queryForList(SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID, 
                new Integer[] {book.getBookId()}, Integer.class);
        //turn list of Integers into array of primitive int's
        //this is sloppy- in retrospect, we probably should have done it differently
        int[] idArray=new int[authorIds.size()];
        for (int i=0; i< authorIds.size(); i ++) {
        idArray[i]= authorIds.get(i);
                }
        return idArray;
    
    }
    
    private static final class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author au = new Author();
            au.setAuthorId(rs.getInt("author_id"));
            au.setFirstName(rs.getString("first_name"));
            au.setLastName(rs.getString("last_name"));
            au.setStreet(rs.getString("street"));
            au.setCity(rs.getString("city"));
            au.setState(rs.getString("state"));
            au.setZip(rs.getString("zip"));
            au.setPhone(rs.getString("phone"));
            return au;
        }

    }
    
    private static final class BookMapper implements RowMapper<Book> {
      
         @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book b=new Book();
           
            b.setBookId(rs.getInt("book_id"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
            b.setPublisherId(rs.getInt("publisher_id"));
            b.setPrice(rs.getBigDecimal("price"));
            b.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
            
            return b;
        
        }
     
     
     
     }
    
    

}
