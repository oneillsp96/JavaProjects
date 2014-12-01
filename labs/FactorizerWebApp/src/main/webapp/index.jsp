<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer Web App</title>
    </head>
    <body>
        
        <h1>Welcome to the Factorizer Web App!</h1>
        <h2>Please enter the number you'd like to factorize</h2>
         <form action="FactorizerServlet" method="post">
            
             Number To Factor: <input type="text" name="numberToFactor" value="${param.numberToFactor}"/><br/>
             <input type="submit" value="Factorize!"/>
         </form> ${errorMessage}<br/>
        
        
    </body>
</html>
