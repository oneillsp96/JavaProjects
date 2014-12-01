



$(document).ready(function() {
    loadContacts();
    
    // on click for out add button
    $('#addButton').click(function() {
        $.ajax({
            type: 'POST',
            url: 'spring/rest/contact',
            data: JSON.stringify({                        //turns it into JSON object that can be sent across
                firstName: $('#add-firstName').val(),    //these (#) are normal CSS ID's (see contact.jsp)
                lastName: $('#add-lastName').val(),
                company: $('#add-company').val(),               //field equals whatevrs typed into form
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {                                  //lets it know its a request for JSON, knows to use right mapper
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function(data, status) {    //when request succeeds reset forms to blank and call loadContacts function (newly added contact shows up on screen)
            $('#add-firstName').val('');    
            $('#add-lastName').val('');
            $('#add-company').val('');  //manually reset each form field to blank after user adds contact
            $('#add-phone').val('');
            $('#add-email').val('');
            loadContacts();
        });
    });
    
    $('#editButton').click(function() {
       $.ajax({
           type: 'PUT',
           url: 'spring/rest/contact/' + $('#edit-contactId').val(),
           data: JSON.stringify({
               firstName: $('#edit-firstName').val(),
               lastName: $('#edit-lastName').val(),
               company: $('#edit-company').val(),
               phone: $('#edit-phone').val(),
               email: $('#edit-email').val(),
               contactId: $('#edit-contactId').val()
           }),
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
           },
           'dataType': 'json'
       }).success(function(data,status) {
           $('#edit-firstName').val('');
           $('#edit-lastName').val('');
           $('#edit-company').val('');
           $('#edit-phone').val('');
           $('#edit-email').val('');
           $('#edit-contactId').val('');
           loadContacts();
       }); 
    });
});

function getContact(element) {
    $.ajax({
        url: 'spring/rest/contact/' + element.id
    }).success(function(data) {
        $('#detail-firstName').text('First Name: ' + data.firstName);
        $('#detail-lastName').text('Last Name: ' + data.lastName);
        $('#detail-company').text('Company: ' + data.company);
        $('#detail-phone').text('Phone: ' + data.phone);
        $('#detail-email').text('Email: ' + data.email);
    });
}

function getEditContact(element) {
    $.ajax({
        url: 'spring/rest/contact/' + element.id
    }).success(function(data) {
        $('#edit-firstName').val(data.firstName);
        $('#edit-lastName').val(data.lastName);
        $('#edit-company').val(data.company);
        $('#edit-phone').val(data.phone);
        $('#edit-email').val(data.email);
        $('#edit-contactId').val(data.contactId);
    });
}

function deleteContact(element) {
    $.ajax({
        type: 'DELETE',
        url: 'spring/rest/contact/' + element.id  // element id is contact number
    }).success(loadContacts());
}

function loadContacts() {
    $('#contact-list').empty();
    $.ajax({
        url:"http://localhost:8080/ContactListMVC/spring/rest/contacts"
    }).then(function(data, status) {
       $.each(data, function(index, contact) {
          $('#contact-list').append('<p><a onclick="getContact(this);" href="#" id="' + 
                  contact.contactId + '">' +
                  contact.firstName + ' ' + contact.lastName + '</a>' +
                  '| <a onclick="getEditContact(this);" href="#" id="' + contact.contactId + '">Edit</a>' +
                  '| <a onclick="deleteContact(this);" href="#" id="' + contact.contactId + '">Delete</a></p>'); 
          
//          this method gets all contacts then builds these 3 links (contact, edit, and delete)for each contact
       }); 
    });
}