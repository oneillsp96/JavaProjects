
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact Form</title>
    </head>
    <body>
        <h1>Edit Contact</h1>

        <sf:form method="post" action="updateContact" modelAttribute="contact">

            ${errorMessage}<br/>
            <sf:label path="firstName">First Name</sf:label><sf:input path="firstName" size="15"/><br/>
            <sf:errors path="firstName" cssClass="error"></sf:errors><br/>

            <sf:label path="lastName">Last Name</sf:label><sf:input path="lastName" size="15"/><br/>
            <sf:errors path="lastName" cssClass="error"></sf:errors><br/>

            <sf:label path="company">Company</sf:label><sf:input path="company" size="15"/><br/>
            <sf:errors path="company" cssClass="error"></sf:errors><br/>

            <sf:label path="phone">Phone</sf:label><sf:input path="phone" size="15"/><br/>
            <sf:errors path="phone" cssClass="error"></sf:errors><br/>

            <sf:label path="email">Email</sf:label><sf:input path="email" size="15"/><br/>
            <sf:errors path="email" cssClass="error"></sf:errors><br/>

            <sf:hidden path="contactId"/>
            <input type="submit" value="Update Contact"/><br/>

        </sf:form>






        <!--        <form action="updateContact" method="post">
                    <label>First Name: </label><input type="text" name="contactFirstName" value="${contact.firstName}"/><br/>
                    <label>Last Name: </label><input type="text" name="contactLastName" value="${contact.lastName}"/><br/>
                    <label>Company: </label><input type="text" name="contactCompany" value="${contact.company}"/><br/>
                    <label>Phone: </label><input type="text" name="contactPhone" value="${contact.phone}"/><br/>
                    <label>Email: </label><input type="text" name="contactEmail" value="${contact.email}"/><br/>
                    <input type="hidden" name="contactId" value="${contact.contactId}"/><br/>
                    <input type="submit" value="Edit Contact"/><br/>
        
                </form>-->

    </body>
</html>
