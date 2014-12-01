
<html>
    <head>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src = "http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js" ></script>

    </head>
<h2>Hello World!</h2>
<a href="spring/hello/sayhi">Test Controller</a>

<div ng-app="" ng-controller="chartController">
  {{102 + 45}}
  
  <div id="chartDiv"></div>  
</div>

<script>
        google.load('visualization', '1.0', {'packages' : ['corechart']});
    function chartController($scope, $http) {
                $http.get("http://localhost:8080/googleCharts/spring/hello/chart")
                .success(function(response) {
                    //var json = eval(response);
                    var json = response;
                    //var json = JSON.stringify(response);
//                    alert(JSON.stringify(response));
//                    var json = eval('(' + response + ')');
                    var myTable = new google.visualization.DataTable(json);
                    //var myChart = new google.visualization.DataTable(json);
                    var options = {'title' : 'Test Title', 'width' : 500, 'height' : 400}; 
                    var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
                    chart.draw(myTable, options);
        
                });
    }
    
    function doTheChart($scope, $http) {
                $http.get("http://localhost:8080/googleCharts/spring/hello/chart")
                .success(function(response) {
                    var json = JSON.stringify(response);
//                    alert(JSON.stringify(response));
//                    var json = eval('(' + response + ')');
                    var myChart = new google.visualization.DataTable(json);
                    //var myChart = new google.visualization.DataTable(json);
                    var options = {'title' : 'Test Title', 'width' : 400, 'height' : 400}; 
                    var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
                    chart.draw(myChart, options);
        
                });

    }
</script>
</html>
