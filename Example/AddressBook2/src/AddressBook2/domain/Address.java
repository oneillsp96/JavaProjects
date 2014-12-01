package AddressBook2.domain;


import java.util.Objects;

public class Address implements Comparable<Address> {

    //need to be final?
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    public Address(String lastName, String firstName, String streetAddress, String city, String state, String zipCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int compareTo(Address compareAddr) {

        //order by last name first
        int currentCompare = this.lastName.compareTo(compareAddr.lastName);
        if (currentCompare != 0) {
            return currentCompare;
        }//then check first name
        currentCompare = this.firstName.compareTo(compareAddr.firstName);
        if (currentCompare != 0) {
            return currentCompare;
        }//check street address
        currentCompare = this.streetAddress.compareTo(compareAddr.streetAddress);
        if (currentCompare != 0) {
            return currentCompare;
        }
        currentCompare = this.city.compareTo(compareAddr.city);
        if (currentCompare != 0) {
            return currentCompare;
        }
        currentCompare = this.state.compareTo(compareAddr.state);
        if (currentCompare != 0) {
            return currentCompare;
        }

        //don't need if statement since it's the last one checked
        return this.zipCode.compareTo(compareAddr.zipCode);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.lastName);
        hash = 31 * hash + Objects.hashCode(this.firstName);
        hash = 31 * hash + Objects.hashCode(this.streetAddress);
        hash = 31 * hash + Objects.hashCode(this.city);
        hash = 31 * hash + Objects.hashCode(this.state);
        hash = 31 * hash + Objects.hashCode(this.zipCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        return true;
    }

}
