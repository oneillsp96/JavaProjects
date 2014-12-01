<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Rate Calculator</title>
    </head>
    <body>
        <h1>Interest Rate Calculator</h1>


        <p>How much would you like to invest?</p>
        <form action="InterestCalculatorServlet" method="post">
            <br/> 
            Start Balance: <input type="text" name="startBalance" value="${param.startBalance}"/><hr/>
            ${errorMessage1}

            Annual Rate: <input type="text" name="annualRate" value="${param.annualRate}"/><hr/>
            ${errorMessage2}    

            Number of years to stay in the fund: <input type="text" name="numYears" value="${param.numYears}"/><hr/>
            ${errorMessage3}     

            Compounding Period: <select name="period">

                <option value="Quarterly">Quarterly</option>
                <option value="Monthly">Monthly</option>
                <option value="Daily">Daily</option>




            </select>  






            <input type="submit" value="submit"/>

        </form>




    </body>
</html>
