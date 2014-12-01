

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="fonts/glyphicons-halflings-refular.svg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Address Form</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>

            <form class="form-horizontal" role="form" method="post" action="addAddress" >
                <div class="form-group">
                    <label for="firstName" class="col-sm-2 control-label">First Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="firstName" name="addressFirstName" placeholder="First Name" value="${param.addressFirstName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="lastName" name="addressLastName" placeholder="Last Name" value="${param.addressLastName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="street" class="col-sm-2 control-label">Street Address</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="street" name="addressStreetAddress" placeholder="Street Address" value="${param.addressStreetAddress}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="city" class="col-sm-2 control-label">City</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="city" name="addressCity" placeholder="City" value="${addressCity}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="state" class="col-sm-2 control-label">State</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="state" name="addressState" placeholder="State" value="${param.addressState}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="zipcode" class="col-sm-2 control-label">Zip Code</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="zipcode" name="addressZipCode" placeholder="Zip Code" value="${param.addressZipCode}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        ${errorMessage}

                        <input type="hidden" name="dvdId" value="${address.addressId}"/>
                        <button type="submit" class="btn-lg btn-info">Save Address</button>
                    </div>
                </div>
            </form>








        </div>

    </body>
</html>
