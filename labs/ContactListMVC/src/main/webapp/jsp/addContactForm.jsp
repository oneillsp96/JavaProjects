<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contact Form</title>
    </head>
    <body>
        <h1>Contact Information Form</h1>

        <form action="addContact" method="post">
            <label>First Name: </label><input type="text" name="contactFirstName"/><br/>
            <label>Last Name: </label><input type="text" name="contactLastName"/><br/>
            <label>Company: </label><input type="text" name="contactCompany"/><br/>
            <label>Phone: </label><input type="text" name="contactPhone"/><br/>
            <label>Email: </label><input type="text" name="contactEmail"/><br/>
            <input type="submit" value="Add Contact"/><br/>

        </form>


    </body>
</html>
