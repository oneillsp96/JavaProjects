<%-- 
    Document   : response
    Created on : Oct 9, 2014, 1:45:16 PM
    Author     : apprentice
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer Response</title>
    </head>

    <body>
        <h1>Consider it Factorized!</h1>
        <p>The number you chose was: ${param.numberToFactor}</p>
        <p> The factors of ${numberToFactor} are:     </p>
        <hr/>

        <c:forEach var="myInt" items="${intList}">  <!--sent this list from servlet to jsp, printing out the contents here-->
            <c:out value="${myInt}"/> <br/>
        </c:forEach>
        <hr/>

        <c:if test="${perfectNum == true}">
             ${numberToFactor} is a perfect number<br/>
        </c:if>    

        <c:if test="${perfectNum == false}">
            ${numberToFactor} is not a perfect number.<br/>
        </c:if>  

            
            
        <c:if test="${primeNum == true}">
            ${numberToFactor} is a prime number<br/>

        </c:if>   
        <c:if test="${primeNum == false}">
            ${numberToFactor} is not a prime number<br/>

        </c:if>   






    </body>
</html>
