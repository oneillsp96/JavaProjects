$(function() {
    drawChart();
    
    function drawChart() {
        $.get('http://localhost:8080/googleCharts/spring/hello/chart').success(function(data) {
            var json = data;
            //var json = eval('(' + data + ')');
            //var json = JSON.stringify(data);
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title':'New Title', 'width':400, 'height':400};
            var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
            chart.draw(dataTable, options);
        });
    };
    
});