/*
 * draftSelection.js - handle loading of the FPL players table, 
 *  handle user inputs for player selection.
 *  
 *  Author - Eddie Kilbane
 */

var DraftSelection = (function() {

	return {
		initDraftSelection : function() {

			$('#playerDatatable').DataTable({
				"ajax" : {
					url : ctx + '/fpldraftpick/getAllPlayers',
					error : function() {
						console.log("Error with Ajax call")
					},
					complete : function() {
						console.log("COMPLETE");
					}
				},
				"columns" : [ {
					"title" : "First",
					"data" : "firstName"
				}, {
					"title" : "Second",
					"data" : "secondName"
				}, {
					"title" : "Total Points",
					"data" : "totalPoints"
				}, {
					"title" : "Club",
					"data" : "club"
				}, {
					"title" : "Position",
					"data" : "playerType"
				} ],
				"processing" : true,
				"deferRender" : true,
				"paging" : true,
				"info" : true
			});
		},
	}
})();