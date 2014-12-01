<%-- 
    Document   : response
    Created on : Oct 10, 2014, 3:29:23 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unit Converter response</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <br/>
        <div class="container"> 
            <div class="jumbotron">
                <h2>






                    <c:if test="${startWithMiles==true}">
                        ${miles} miles equals ${kilometers} kilometers.
                    </c:if>

                    <c:if test="${startWithMiles==false}">
                        ${kilometers} kilometers equals ${miles} miles.

                    </c:if>
                </h2>
            </div>  
        </div>
    </body>
</html>
