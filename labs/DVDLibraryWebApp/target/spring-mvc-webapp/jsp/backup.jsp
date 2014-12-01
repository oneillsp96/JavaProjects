
<c:forEach var="student" items="${studentList}">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th>
                                    First Name: 
                                </th>
                                <td>
                                    ${student.firstName}
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    Last Name:  
                                </th>
                                <td>
                                    ${student.lastName}
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    Points:
                                </th>
                                <td>
                                    ${student.points}
                                </td>
                            </tr>                    
                            <tr>
                                <th>
                                    Side:
                                </th>
                                <td>
                                    ${student.side}
                                </td>
                            </tr> 



                            <tr>
                                <td align="right"><a href="deleteDvd?dvdId=${student.studentId}"><button type="submit" class="btn-lg btn-info">Delete</button></a></td>                                
                                <td><a href="displayEditStudentForm?studentId=${student.studentId}"><button type="submit" class="btn-lg btn-info">Edit</button></a></td>
                        <br />
                        <br />
                        </tr>
                        </tbody>
                    </table>

                </c:forEach>








































<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Backup- do not use</h1>
        
        
        
            <p><a href="displayAddDvdForm">Add a DVD</a></p>
            <hr/>

            
            
            
            
            
            <form action="searchDvds" method="post">
                <!--"answer" is a tag which will become our request parameter....our java code expects a request parameter just like our switch statement expects number 1-6 (for example)--> 

                Search By:  <select name="searchOption">                            <!--this is how we do it with a drop-down menu-->
                    <option value="title">Title</option>
                    <option value="mpaaRating">Rating </option>
                    <option value="studio">Studio </option>
                    <option value="director">Director </option>

            </select>  <!-- ${errorMessage}<hr/>  -->

                Value <input type="text" name="searchText" value="${param.searchText}"/><hr/>
                ${errorMessage}

                <input type="submit" value="Search"/>
            </form>
            <!--attribute we set on model-->
            
            
            
            
            
            
            
            
            
            
            
            <c:forEach var="dvd" items="${dvdList}">
                <p>

                    <a href="deleteDvd?dvdId=${dvd.dvdId}">Delete</a> |
                    <a href="displayEditDvdForm?dvdId=${dvd.dvdId}">Edit</a><br/>



                    Title: ${dvd.title}<br/>               

                    Release Date: ${dvd.releaseDate}<br/>

                    MPAA Rating: ${dvd.mpaaRating}<br/>

                    Director:${dvd.director} <br/>

                    Studio: ${dvd.studio}<br/>

                    Note: ${dvd.note}<br/>


                </p>
            </c:forEach>











    </body>

</html>

        
        
        
        
        
        
        
        
    </body>
</html>


<c:forEach var="dvd" items="${dvdList}">

            
                Title: ${dvd.title}<br/>
                Release Date: ${dvd.releaseDate}<br/>
                Rating: ${dvd.mpaaRating}<br/>
                Director:${dvd.director}<br/>
                Studio: ${dvd.studio}<br/>
                Note: ${dvd.note}<br/>
                <hr/>
               

            

        </c:forEach>
                
                
                 <div class="container" style="padding-top: 40px; padding-left: 0px">
            <div class="spinner">
                <div class="ball ball-1"></div>
                <div class="ball ball-2"></div>
                <div class="ball ball-3"></div>
                <div class="ball ball-4"></div>
            </div>
        </div>
                
                
                <div class="page-header"><h1><span class="glyphicon glyphicon-large"></span>< DVD Library <small> Stay Organized!</small></h1></div>
