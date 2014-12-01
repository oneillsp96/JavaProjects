<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>
    </head>
    <body>
        <h1>Address Book</h1>
        <p><a href="displayNewAddressForm">Add an Address</a></p>
        <hr/>


        <c:forEach var="address" items="${addressBook}">
            <p>
                <!--key=value ...separated by ampersands     ?addressId and value input is query string  -->
                <a href="deleteAddress?addressId=${address.addressId}">Delete</a> |
                <a href="editAddressForm?addressId=${address.addressId}">Edit</a><br/>

                First Name: ${address.firstName}  <br/>

                Last Name: ${address.lastName}<br/>

                Street Address: ${address.streetAddress}<br/>

                City:${address.city} <br/>

                State: ${address.state}<br/>
                
                Zip Code: ${address.zipCode}<br/>


            </p>
        </c:forEach>


    </body>
</html>
