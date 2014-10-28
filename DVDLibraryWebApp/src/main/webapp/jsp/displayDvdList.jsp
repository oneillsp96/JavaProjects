
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


       
        <link rel="stylesheet" type="text/css" href="css/spinningBall.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display DVD List</title>
    </head>
    <body>


        <div class="container">
            <jsp:include page="header.jsp"/>

            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">



                        <form action="searchDvds" method="post">
                            <br/>


                            Search By:  <select class="form-control" style="width: 100px" name="searchOption">                            <!--this is how we do it with a drop-down menu-->
                                <option value="title" >Title</option>
                                <option value="mpaaRating">Rating </option>
                                <option value="studio">Studio </option>
                               <!-- <option value="director">Director </option> -->

            </select>  <br/>
                             <input class="form-control" style="width: 200px" type="text" name="searchText" value="${param.searchText}"/>
                             <p style="form-control">${errorMessage}</p>
                            <br/>

                           
                            <button type="submit" class="btn btn-default" >Search</button>
                            <a href="displayAddDvdForm" class="btn btn-default">Add a DVD</a>
                            <br/>
                            
                            <br/>
                            
                        </form>

                    </div>                        
            </nav>

























            <div class="row">
                <div class="col-xs-6">
                    <c:forEach var="dvd" items="${dvdList}">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th>
                                        Title: 
                                    </th>
                                    <td>
                                        ${dvd.title}
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        Release Date:  
                                    </th>
                                    <td>
                                        ${dvd.releaseDate}
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        Rating
                                    </th>
                                    <td>
                                        ${dvd.mpaaRating}
                                    </td>
                                </tr>                    
                                <tr>
                                    <th>
                                        Director: 
                                    </th>
                                    <td>
                                        ${dvd.director}
                                    </td>
                                </tr> 
                                <tr>
                                    <th>
                                        Studio:
                                    </th>
                                    <td>
                                        ${dvd.studio}
                                    </td>
                                </tr> 
                                <tr>
                                    <th>
                                        Note: 
                                    </th>
                                    <td>
                                        ${dvd.note}
                                    </td>
                                </tr> 


                                <tr>
                                    <td align="right"><a href="deleteDvd?dvdId=${dvd.dvdId}"><button type="submit" class="btn-lg btn-info">Delete</button></a></td>                                
                                    <td><a href="displayEditDvdForm?dvdId=${dvd.dvdId}"><button type="submit" class="btn-lg btn-info">Edit</button></a></td>
                            <br />
                            <br />
                            </tr>
                            </tbody>
                        </table>

                    </c:forEach>
                    <div class="row">
                        <div class="col-xs-6">

                        </div>
                    </div>
                </div>
            </div>





        </div>


    </body>
</html>









