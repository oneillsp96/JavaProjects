
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="fonts/glyphicons-halflings-refular.svg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Dvd Form</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>


            <form role="form" action="updateDvd" method="post" style="margin-left: 25px;">
                <div class="form-group">
                    <label for="exampleInputEmail1">Title</label>
                    <input class="form-control" type="text" name="dvdTitle" value="${dvd.title}"/>
                </div>
                 <div class="form-group">
                    <label for="exampleInputEmail1">Release Date</label>
                    <input class="form-control" type="text" name="dvdReleaseDate" value="${dvd.releaseDate}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Rating</label>
                    <input class="form-control" type="text" name="dvdMpaaRating" value="${dvd.mpaaRating}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Director</label>
                    <input class="form-control" type="text" name="dvdDirector" value="${dvd.director}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Studio</label>
                    <input class="form-control" type="text" name="dvdStudio" value="${dvd.studio}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Note</label>
                    <input class="form-control" type="text" name="dvdNote" value="${dvd.note}"/>
                </div>
                
                

                ${errorMessage}
                <input type="hidden" name="dvdId" value="${dvd.dvdId}"/>
                
                <button type="submit" class="btn btn-default">Submit</button>
            </form>


        </div>

    </body>
</html>
