<%-- 
    Document   : entry
    Created on : Oct 8, 2014, 11:19:14 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        
        
        <title>You're invited</title>
    </head>
    <body>
        <h1>I'm having a party and you're invited!</h1>

        <h2>Can you attend?</h2>

        <form action="RSVPServlet" method="post">
            Answer: <input type="text" name="answer" value="${param.answer}"/><br/>  <!--"answer" is a tag which will become our request parameter....our java code expects a request parameter just like our switch statement expects number 1-6 (for example)--> 

<!--Number Attending: <input type="text" name="numAttending" value="${param.numAttending}"/>   this is how we'd do it with a normal form-->

            Number Attending:  <select name="numAttending">                            <!--this is how we do it with a drop-down menu-->
                <option value="1">1 guest</option>
                <option value="2">2 guests</option>
                <option value="3">3 guests</option>
                <option value="4">4 guests</option>

            </select>  ${errorMessage}<br/>



            <input type="submit" value="RSVP"/>
        </form>


    </body>
</html>
