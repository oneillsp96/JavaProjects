<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
     
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unit Converter</title>
    </head>
    <body>
        <h1>Mile/Kilometer Converter</h1>
        <h2>Convert Miles to KM or vice versa<h2>
        
          <form action="UnitConverterServlet" method="post">
                                                                            <!--"answer" is a tag which will become our request parameter....our java code expects a request parameter just like our switch statement expects number 1-6 (for example)--> 

           Starting Units:  <select name="startingUnits">                            <!--this is how we do it with a drop-down menu-->
                <option value="miles">Miles</option>
                <option value="kilometers">Kilometers </option>
                
                

            </select>  <!-- ${errorMessage}<hr/>  -->
            
            Number: <input type="text" name="number" value="${param.number}"/><hr/>
            ${errorMessage}


            <input type="submit" value="submit"/>
        </form>
        
    </body>
</html>
