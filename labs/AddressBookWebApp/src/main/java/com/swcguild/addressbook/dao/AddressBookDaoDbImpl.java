package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.model.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AddressBookDaoDbImpl implements AddressBookDao {

    private static final String SQL_INSERT_ADDRESS = "insert into addresses(first_name, last_name, street_address, city, state, zip_code)  values"
            + "(?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_ADDRESS = "delete from addresses where address_id=?";

    private static final String SQL_UPDATE_ADDRESS
            = "update addresses set first_name=?, last_name=?, street_address=?, city=?, state=?, zip_code=? where address_id=?";

    private static final String SQL_GET_ALL_ADDRESSES
            = "select* from addresses";
    private static final String SQL_GET_ADDRESSES_BY_LAST_NAME
            = "select* from addresses where last_name=?";
    private static final String SQL_GET_ADDRESSES_BY_CITY
            = "select* from addresses where city=?";
    private static final String SQL_GET_ADDRESSES_BY_ZIP
            = "select* from addresses where zip_code=?";
    private static final String SQL_GET_ADDRESS_BY_ID
            = "select* from addresses where address_id=?";

//    public static final String SQL_GET_NUMBER_OF_ADDRESSES
//            = "select* from "
             
    public static final String SQL_GET_ADDRESSES_BY_STATE //group by city after getting them out!
            = "select* from addresses where state=?";
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode());
        address.setAddressId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getAddressId());  //id doesn't change when you update the address

    }

    //get mapper class for all 4 of these methods
    @Override
    public List<Address> getAllAddresses() {
        return jdbcTemplate.query(SQL_GET_ALL_ADDRESSES, new AddressMapper());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_ADDRESS_BY_ID, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Address> searchAddressesByLastName(String lastName) {
        return jdbcTemplate.query(SQL_GET_ADDRESSES_BY_LAST_NAME, new AddressMapper(), lastName);
    }
    
    @Override
     public List<Address> searchAddressesByCity(String city) {
      return jdbcTemplate.query(SQL_GET_ADDRESSES_BY_CITY, new AddressMapper(), city);
     }

    @Override
    public List<Address> searchAddressesByZip(String zipCode) {
        return jdbcTemplate.query(SQL_GET_ADDRESSES_BY_ZIP, new AddressMapper(), zipCode);
    }

    @Override
    public Map<String, List<Address>> searchAddressesByStateGroupByCity(String state) {
       return jdbcTemplate.query(SQL_GET_ADDRESSES_BY_STATE, new AddressMapper(), state).stream()
                .filter(a -> a.getState().equalsIgnoreCase(state))
                .collect(Collectors.groupingBy(a -> a.getCity()));
   }
    
    //double check the logic on this method
    @Override
     public int getNumberOfAddresses(){
     List<Address>addList=new ArrayList<>();
            addList=jdbcTemplate.query(SQL_GET_ALL_ADDRESSES, new AddressMapper());
            return addList.size();
     }
    
 
    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {

            Address a = new Address();
            a.setAddressId(rs.getInt("address_id"));
            a.setFirstName(rs.getString("first_name"));
            a.setLastName(rs.getString("last_name"));
            a.setStreetAddress(rs.getString("street_address"));
            a.setCity(rs.getString("city"));
            a.setState(rs.getString("state"));
            a.setZipCode(rs.getString("zip_code"));

            return a;
        }
    }
}
