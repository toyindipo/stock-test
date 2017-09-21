var company;

var $stockForm = $('#stockForm');
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
    	$('#stockButton').click();
    }
} );

