/*
 * draftSelection.js - handle loading of the FPL players table, 
 *  handle user inputs for player selection.
 *  
 *  Author - Eddie Kilbane
 */

var DraftSelection = (function() {

	_draftClock: null;
	_draftRound : 1;
	_draftUserPick : 0;
	_draftUserOrder : [];
	_currentUser : 0;

	var displayUsernameSelction = function(){
		console.log(_draftUserOrder[0].draftOrder);
		
		for(i=0; i< _draftUserOrder.length; i++){
			
			if(_draftUserOrder[i].draftOrder === _draftUserPick){
				$('#usernameSelection').html(_draftUserOrder[i].username + "'s pick");
				_currentUser = _draftUserOrder[i].userId;
			}
			
		}
		_draftUserPick += 1;
		if(_draftUserPick > _draftUserOrder.length){
			_draftUserPick = 1;
		}
		
	};

	return {
		
		oTable : null,
		initDraftSelection : function() {
			
			DraftSelection._draftClock = $('.flipClock').FlipClock(120, {
				clockFace : 'MinuteCounter',
				countdown : true,
				autoStart : false

			});

			$('.flipClock').hide();
			
			$.ajax({
				type : 'POST',
				url : ctx + '/fpldraftpick/getAllDraftPickUsers1',
				error : function(error) {
					console.log("Error with Ajax call");
					console.log(error);
				},
				success : function(response) {
					console.log("Successfully updated Draft Order");
					_draftUserPick = 1;
					_draftUserOrder = response;
					displayUsernameSelction();
					

				}
			});

			/*$('#userDraftOrderTable').DataTable(
					{
						"ajax" : {
							type : 'POST',
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
						} ],
						"filter" : false,
						"processing" : false,
						"deferRender" : false,
						"paging" : false,
						"info" : false
					});*/


			DraftSelection.oTable = $('#playerDatatable').DataTable(
					{
						"ajax" : {
							type : 'POST',
							url : ctx + '/fpldraftpick/getAllPlayers',
							error : function() {
								console.log("Error with Ajax call")
							},
							complete : function() {
								console.log("COMPLETE");
								DraftSelection.initButtonListeners();
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
			// If player selected change button colour and do not allow it to be selected.
			if(row.assignedUserId === 0){
				return '<button id="'
				+ row.playerId
				+ ' " type="button" class="btn btn-primary"'
				+' onClick="DraftSelection.selectPlayer('+row.playerId+');">Select</button>';
			}else{
				return '<button id="'
				+ row.playerId
				+ ' " type="button" class="btn btn-default"'
				+' onClick="DraftSelection.playerAlreadySelected('+row.firstName+','+row.firstName+','+row.assignedUserId+');">Selected</button>';
			}	
		},
		
		playerAlreadySelected : function(firstName, secondName, userId ){
			console.log("Sorry: " + firstName + " " + secondName + " selected by: " + userId);
		},
		
		selectPlayer : function(player){
			$.ajax({
				type : 'POST',
				url : ctx + '/fpldraftpick/selectPlayerForUpdate',
				data : {
					userId : _currentUser,
					playerID : player
				},
				error : function(error) {
					console.log("Error with Ajax call");
					console.log(error);
				},
				success : function(response) {
					console.log("Successfully updated Users player selection");
					displayUsernameSelction();
					DraftSelection.oTable.ajax.reload();
				}
			});			
		}
	}
})();