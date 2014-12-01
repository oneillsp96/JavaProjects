<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    <body>
        <h1>Lucky 7's Response</h1>
        
        <p>You bet: ${param.answer}</p>
        
        <c:forEach var="msg" items="${messageList}">
            <c:out value="${msg}"/> <br/>
                
            
            
        </c:forEach>
        
       
        
        
        
        <p> You rolled  ${rollCount}               times </p>
        <p>You should have stopped at ${addCount} when you had ${maxAmount} remaining</p>
        
    </body>
</html>
