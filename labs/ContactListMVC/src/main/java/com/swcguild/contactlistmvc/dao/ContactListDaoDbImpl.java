package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ContactListDaoDbImpl implements ContactListDao {
    
    private static final String SQL_INSERT_CONTACT = "insert into contacts(first_name, last_name, company, phone, email)  values"
            + "(?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_CONTACT = "delete from contacts where contact_id=?";
    
    private static final String SQL_UPDATE_CONTACT
            = "update contacts set first_name=?, last_name=?, company=?, phone=?, email=? where contact_id=?";
    
    private static final String SQL_GET_ALL_CONTACTS
            = "select* from contacts";
    private static final String SQL_GET_CONTACTS_BY_LAST_NAME
            = "select* from contacts where last_name=?";
    private static final String SQL_GET_CONTACTS_BY_COMPANY
            = "select* from contacts where company=?";
    private static final String SQL_GET_CONTACT_BY_ID
            = "select* from contacts where contact_id=?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                contact.getFirstName(),             //take each of these fields from the contact object passed in and insert them into database using jdbcTemplate
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail());
        contact.setContactId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));   //database sets the ID number

    }
    
    @Override
    public void removeContact(int contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }
    
    //don't need transactional since we already know ID
    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getContactId());  //id doesn't change when you update the contact

    }

    //get mapper class for all 4 of these methods
    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(SQL_GET_ALL_CONTACTS, new ContactMapper());
    }
    
    @Override
    public Contact getContactById(int contactId) {
       try{
        return jdbcTemplate.queryForObject(SQL_GET_CONTACT_BY_ID, new ContactMapper(), contactId);
                }catch(EmptyResultDataAccessException e){
                    return null;
            }
                }
    
    @Override
    public List<Contact> searchContactByLastName(String lastName) {
        return jdbcTemplate.query(SQL_GET_CONTACTS_BY_LAST_NAME, new ContactMapper(), lastName);
    }
    
    @Override
    public List<Contact> searchContactsByCompany(String company) {
        return jdbcTemplate.query(SQL_GET_CONTACTS_BY_COMPANY, new ContactMapper(), company);
    }

    //grab data from database and put it into a contact object so it can be used 
    private static final class ContactMapper implements RowMapper<Contact> {
        
        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            
            Contact c = new Contact();
            c.setContactId(rs.getInt("contact_id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            c.setCompany(rs.getString("company"));
            c.setPhone(rs.getString("phone"));
            c.setEmail(rs.getString("email"));
            return c;
        }
    }
}
