/*
 * draftSelection.js - handle loading of the FPL players table, 
 *  handle user inputs for player selection.
 *  
 *  Author - Eddie Kilbane
 */

var DraftSelection = (function() {

	_draftClock: null

	return {
		initDraftSelection : function() {

			DraftSelection.initButtonListeners();

			DraftSelection._draftClock = $('.flipClock').FlipClock(120, {
				clockFace : 'MinuteCounter',
				countdown : true,
				autoStart : false

			});

			$('.flipClock').hide();

			$('#playerDatatable').DataTable(
					{
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
						}, {
							"title" : "Selection",
							"data" : "playerId"
						} ],
						"columnDefs" : [ {
							"targets" : [ 5 ],
							"render" : function(data, type, row) {
								return DraftSelection.renderPlayerSelectButton(
										data, type, row);
							}
						} ],

						"processing" : true,
						"deferRender" : true,
						"paging" : true,
						"info" : true
					});
		},
		initButtonListeners : function() {

			$('#startDraftPickBtn').click(function() {
				$('.flipClock').show();
				DraftSelection._draftClock.start();
			});

		},

		renderPlayerSelectButton : function(data, type, row) {
			return '<button id="'
					+ row.playerId
					+ ' " type="button" class="btn btn-primary">Select</button>'
		}
	}
})();