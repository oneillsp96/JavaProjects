<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        
        <title>Lucky 7's</title>
    </head>
    
    <body>
        <h1>Lucky 7's</h1>
        <h2>How much money do you have to bet?</h2>
        
         <form action="Lucky7sServlet" method="post">
            Answer: <input type="text" name="answer" value="${param.answer}"/><br/>
        
         <input type="submit" value="Submit"/>
         </form>
         
    </body>
</html>
