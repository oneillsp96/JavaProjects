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

        <jsp:include page="header.jsp"/>

        <div class="container">
            <div class="jumbotron">













            <h1>Mile/Kilometer Converter</h1>
            <h2>Convert Miles to KM or vice versa</h2>



            <form action="UnitConverterServlet" method="post">
                <br/>


                <p>Starting Units:</p> <select class="form-control" style="width:130px" name="startingUnits">                            
                    <option value="miles">Miles</option>
                    <option value="kilometers">Kilometers </option>
                </select>  <br/>

                <p>Number:</p> <input class="form-control" style="width: 130px" type="text" name="number" value="${param.number}"/><hr/>
               ${errorMessage}


               <button type="submit" class="form-control" style="width: 80px">Submit</button>
            </form>
        </div>
        </div>
    </body>
</html>
