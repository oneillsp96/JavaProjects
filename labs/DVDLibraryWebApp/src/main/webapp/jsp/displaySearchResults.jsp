
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="fonts/glyphicons-halflings-refular.svg"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Search Results</title>
    </head>
    <body>
        <div class="container">
        
        
        <jsp:include page="header.jsp"/>
        <div class="row">
                <div class="col-xs-6">
                    <c:if test="${empty dvdList}">
                        <h1>No DVD's were found with those properties</h1>
                        <a href='displayDvdList'>Try Again?</a>
                        
                    </c:if>
                          
                          
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
                                    <td><a href="deleteDvd?dvdId=${dvd.dvdId}"><button type="submit" class="btn-lg btn-info">Delete</button></a></td>                                
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
