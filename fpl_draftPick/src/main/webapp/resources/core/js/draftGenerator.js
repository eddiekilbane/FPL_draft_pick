/*
 * draftGenerator.js - Generate draft pick for all users. Display the table
 *  
 *  Author - Eddie Kilbane
 */

var DraftGenerator = (function() {
	
	var initButtonListener = function(){
		$('#startDraftGeneratorBtn').click(function() {
			console.log("Start Draft Generator");
			
			//TODO Get number of users, assign random number from 1:n where n is 
			// the total number of users.
			
			// Ajax update with data
			
			// Reload Table
			
		});
		
	};

	return {
		initDraftGenerator : function() {

			initButtonListener();

			$('#playerOrderDatatable').DataTable(
					{
						"ajax" : {
							url : ctx + '/fpldraftpick/getAllDraftPickUsers',
							error : function() {
								console.log("Error with Ajax call")
							},
							complete : function() {
								console.log("COMPLETE");
							}
						},
						"columns" : [ {
							"title" : "Name",
							"data" : "username"
						}, {
							"title" : "Order",
							"data" : "draftOrder"
						}],
					});
		},

	}
})();