<%-- 
    Document   : displayEditStudentForm
    Created on : Oct 23, 2014, 9:53:52 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="container">
            <jsp:include page="header.jsp"/>


            <form role="form" action="updateStudent" method="post" style="margin-left: 25px;">
                <div class="form-group">
                    <label for="exampleInputEmail1">First Name </label>
                    <input class="form-control" type="text" name="studentFirstName" value="${student.firstName}"/>
                </div>
                 <div class="form-group">
                    <label for="exampleInputEmail1">Last Name</label>
                    <input class="form-control" type="text" name="studentLastName" value="${student.lastName}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Points</label>
                    <input class="form-control" type="text" name="studentPoints" value="${student.points}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Side</label>
                    <input class="form-control" type="text" name="studentSide" value="${student.side}"/>
                </div>
              
                
                

                ${errorMessage}
                <input type="hidden" name="dvdId" value="${student.studentId}"/>
                
                <button type="submit" class="btn btn-default">Submit</button>
            </form>


        </div>
    </body>
</html>
