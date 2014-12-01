
$(document).ready(function() {

    

    
});

function addPoint(element) {
        $.ajax({
            type: 'PUT',
            url: 'rest/addPoint/' + element.id,
            data: JSON.stringify({
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function(data, status) {
            
            $('#student-point-' + element.id).text(data);


        });
    }
    
    function subtractPoint(element) {
        $.ajax({
            type: 'PUT',
            url: 'rest/subtractPoint/' + element.id, 
            data: JSON.stringify({
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function(data, status) {
            
            $('#student-point-' + element.id).text(data);


        });
    }

















