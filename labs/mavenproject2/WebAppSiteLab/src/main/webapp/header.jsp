
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="container">
            <br/>
            <br/>
            <br/>
            <!-- Stack the columns on mobile by making one full-width and the other half-width -->
            <div style="border-style: solid; border-width: 2px; border-radius: 30px; text-align:center; font-size: 300%; background-color: #eee; padding-top: 80px; padding-left: 50px; padding-right: 50px">
                    <p style="padding: 10px">Software Craftsmanship Guild Java Cohort </p>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-md-12" style="text-align:center; font-size: 200%; padding-top: 20px">JSP Site Lab</div>
            </div>
            <br/> 


            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">  
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header" >
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"style="text-align: center">
                        <ul class="nav nav-justified">

                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="indexUC.jsp">Unit Converter</a></li>
                            <li><a href="indexF.jsp">Factorizer</a></li>
                            <li><a href="indexTC.jsp">Tip Calculator</a></li>
                           
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

        </div>
    </body>
</html>
