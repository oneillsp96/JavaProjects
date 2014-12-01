

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="fonts/glyphicons-halflings-refular.svg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Address Form</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>


            <form role="form" action="updateAddress" method="post" style="margin-left: 25px;">
                <div class="form-group">
                    <label for="exampleInputEmail1">First Name</label>
                    <input class="form-control" type="text" name="addressFirstName" value="${address.firstName}"/>
                </div>
                 <div class="form-group">
                    <label for="exampleInputEmail1">Last Name</label>
                    <input class="form-control" type="text" name="addressLastName" value="${address.lastName}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Street Address</label>
                    <input class="form-control" type="text" name="addressStreetAddress" value="${address.streetAddress}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">City</label>
                    <input class="form-control" type="text" name="addressCity" value="${address.city}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">State</label>
                    <input class="form-control" type="text" name="addressState" value="${address.state}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Zip Code</label>
                    <input class="form-control" type="text" name="addressZipCode" value="${address.zipCode}"/>
                </div>
                
                

                ${errorMessage}
                <input type="hidden" name="addressId" value="${address.addressId}"/>
                
                <button type="submit" class="btn btn-default">Submit Changes</button>
            </form>


        </div>
        
        
    </body>
</html>
