
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Students</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>

            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">



                        <form action="searchStudents" method="post">
                            <br/>


                            Search By:  <select class="form-control" style="width: 140px" name="searchOption">                            <!--this is how we do it with a drop-down menu-->
                                <option value="firstName" >First Name</option>
                                <option value="lastName">Last Name</option>
                                <option value="points">Points</option>
                                <option value="side">Note</option> 

                            </select>  <br/>
                            <input class="form-control" style="width: 200px" type="text" name="searchText" value="${param.searchText}"/>
                            <p style="form-control">${errorMessage}</p>
                            <br/>


                            <button type="submit" class="btn btn-default" >Search</button>
                            <a href="displayAddStudentForm" class="btn btn-default">Add a Student</a>
                            <br/>

                            <br/>

                        </form>

                    </div>                        
            </nav>






            <c:forEach var="student" items="${studentList}">

                <div class="col-lg-3" style=" text-align: center; border-style: solid; border-width: 5px; border-radius: 20px; display: inline; margin: 30px">


                    <div style="padding: 3px">
                        Name: ${student.firstName} ${student.lastName}                       
                        <br/>
                        Points: <div id="student-point-${student.studentId}">  ${student.points} </div>                       
                        <br/>
                        Side:  ${student.side}
                        <br/>
                        <br/>
                        
                        
<!--                        AJAX--> <!--(this) is the student id of the specific student div-->
                        <a href="#" id="${student.studentId}" onclick="subtractPoint(this)" class="btn-primary btn"> - </a>
                        <a href="#" id="${student.studentId}" onclick="addPoint(this)" class="btn-primary btn"> + </a>  
                        

                        
                        
                        
                        
<!--                        non-ajax technique-->

<!--                        <a href="addPoint?studentId=${student.studentId}&studentPoints=${student.points}&studentFirstName=${student.firstName}&studentLastName=${student.lastName}&studentSide=${student.side}"><button  id="bt1" type="submit" class="btn-md btn-info"> + </button></a>  
                        -->

                     
<!--                        <a href="subtractPoint?studentId=${student.studentId}&studentPoints=${student.points}&studentFirstName=${student.firstName}&studentLastName=${student.lastName}&studentSide=${student.side}"><button type="submit" class="btn-md btn-info"> - </button></a> -->
                        <br/><br/>
                        <a href="deleteStudent?studentId=${student.studentId}"><button type="submit" class="btn-sm btn-info">Delete</button></a>                                
                        <a href="displayEditStudentForm?studentId=${student.studentId}"><button type="submit" class="btn-sm btn-info">Edit</button></a>




                    </div>

                    <br/>
                    <br/>
                </div>


            </c:forEach>
        </div>




        <div class="row">
            <div class="col-xs-6">

            </div>
        </div>








 <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/editPoints.js"></script>

    </body>
</html>





