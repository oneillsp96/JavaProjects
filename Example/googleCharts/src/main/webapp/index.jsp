
<html>
    <head>
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    </head>
    <body>
        <h2>Hello World!</h2>
        <a href="spring/hello/sayhi">Test Controller</a>

        <div ng-app="" ng-controller="chartController">
            

            <div id="chartDiv"></div>  
        </div>

        
        
        <script>
            google.load('visualization', '1.0', {'packages': ['corechart']});
            function chartController($scope, $http) {
                //raw data goes to this URL and is called by the method below
                $http.get("http://localhost:8080/googleCharts/spring/hello/chart")
                        .success(function(response) {
                            //call and define funtion at the same time

                            var json = response;
                            var myTable = new google.visualization.DataTable(json);
                            var options = {'title': 'Test Title', 'width': 500, 'height': 400};
                            var chart = new google.visualization.PieChart(document.getElementById('chartDiv'));
                            chart.draw(myTable, options);

                        });
            }


        </script>
    </body>
</html>
