<%-- 
    Document   : response
    Created on : Oct 10, 2014, 11:40:51 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
       
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator Response</title>
    </head>
    <body>
        <h1>Tip Calculator</h1><br/>
       <p>Your meal cost was $${cost}</p><hr/>
        <p>You tipped ${tipPercentage}% </p><hr/>
        <p>Your tip was ${tip}</p><hr/>
        <p>Total Cost: ${totalCost}</p><hr/>
        
       
    </body>
</html>
