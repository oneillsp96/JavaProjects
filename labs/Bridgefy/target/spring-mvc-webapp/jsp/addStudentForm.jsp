

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>


            <form role="form" action="addStudent" method="post" style="margin-left: 25px;">
                <div class="form-group">
                    <label for="exampleInputEmail1">First Name</label>
                    <input class="form-control" type="text" name="studentFirstName" value="${param.studentFirstName}"/>
                </div>
                 <div class="form-group">
                    <label for="exampleInputEmail1">Last Name</label>
                    <input class="form-control" type="text" name="studentLastName" value="${param.studentLastName}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Points</label>
                    <input class="form-control" type="text" name="studentPoints" value="${param.studentPoints}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Note</label>
                    <input class="form-control" type="text" name="studentSide" value="${param.studentSide}"/>
                </div>
               
                
                

                ${errorMessage}
                <input type="hidden" name="studentId" value="${student.studentId}"/>
                
                <button type="submit" class="btn btn-default">Submit</button>
            </form>


        </div>
    </body>
</html>
