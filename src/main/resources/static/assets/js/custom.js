var company;

var $stockForm = $('#stock-form');
var $stockFormAjaxProcessor = function(e) {
	  e.preventDefault();	  
	  $.ajax({
	    url: $stockForm.attr('action'),
	    method: 'POST',
	    data: $stockForm.serialize(),
	    success: function(response) {
	    	var $responseData = $(response);
	    	var $tableDiv = $('#stock-table-row');
	    	$tableDiv.replaceWith($responseData);
	    	alert(1111);
	    	console.log($responseData);
	    	localStorage.setItem("last-company", $('#company').val());
	      }
	    });	  
	}


$stockForm.on('submit', $stockFormAjaxProcessor);

$(document).ready(function() {
    //$('#stock-table').DataTable();
    company = localStorage.getItem("last-company");
    
    if (company != null && company.trim() != "") {
    	$('#company').val(company);
    }
} );

