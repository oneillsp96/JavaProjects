<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="jumbotron"> 






                <h1>Welcome to the Tip Calculator</h1><hr/>
                <h2>Enter the cost of your meal and select tip percentage</h2>  <br/>


                <form action="TipCalculatorServlet" method="post">
                    <p>Meal cost:</p> <input style="width: 160px" class="form-control" type="text" name="cost" value="${param.cost}"/><hr/>  <!--"answer" is a tag which will become our request parameter....our java code expects a request parameter just like our switch statement expects number 1-6 (for example)--> 

                    <p>Tip Percentage:</p><select name="tipPercentage" class="form-control" style="width: 160px">                            <!--this is how we do it with a drop-down menu-->
                        <option value="10">10%</option>
                        <option value="15">15% </option>
                        <option value="20">20% </option>


                    </select>  ${errorMessage}<hr/>



                    <button type="submit" class="form-control" style="width: 100px" >Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
