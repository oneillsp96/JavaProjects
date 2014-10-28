

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="fonts/glyphicons-halflings-refular.svg"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add DVD Form</title>
    </head>
    <body>

        <div class="container">
            <jsp:include page="header.jsp"/>


            <form role="form" action="addDvd" method="post" style="margin-left: 25px;">
                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" type="text" name="dvdTitle" value="${param.dvdTitle}"/>
                </div>
                <div class="form-group">
                    <label>Release Date (yyyy-mm-dd)</label>
                    <input class="form-control" type="text" name="dvdReleaseDate" value="${param.dvdReleaseDate}"/>
                </div>
                <div class="form-group">
                    <label>Rating</label>
                    <input class="form-control" type="text" name="dvdMpaaRating" value="${param.dvdMpaaRating}"/>
                </div>
                <div class="form-group">
                    <label>Director</label>
                    <input class="form-control" type="text" name="dvdDirector" value="${param.dvdDirector}"/>
                </div>
                <div class="form-group">
                    <label>Studio</label>
                    <input class="form-control" type="text" name="dvdStudio" value="${param.dvdStudio}"/>
                </div>
                <div class="form-group">
                    <label>Note</label>
                    <input class="form-control" type="text" name="dvdNote" value="${param.dvdNote}"/>
                </div>



                ${errorMessage}
                <input type="hidden" name="dvdId" value="${dvd.dvdId}"/>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>


        </div>

    </body>
</html>
