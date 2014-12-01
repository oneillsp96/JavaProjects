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


        <jsp:include page="header.jsp"/>

        <div class="container"> 
            <div class="jumbotron">
























                <h1>Welcome to the Factorizer App!</h1><br/>
                <h3>Please enter the number you'd like to factorize</h3>
                <br/>
                <form action="FactorizerServlet" method="post">

                    <p> Number To Factor:</p> <input class="form-control" style="width: 200px"type="text" name="numberToFactor" value="${param.numberToFactor}"/><br/>
                    <br/>
                    <button type="submit" class="form-control" style="width:100px">Factorize!</button>
                </form> <p style="form-control"> ${errorMessage}</p><br/>

            </div>
        </div>
    </body>
</html>
