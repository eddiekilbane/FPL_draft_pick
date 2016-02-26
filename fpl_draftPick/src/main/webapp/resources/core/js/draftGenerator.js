/*
 * draftGenerator.js - Generate draft pick for all users. Display the table
 *  
 *  Author - Eddie Kilbane
 */

var DraftGenerator = (function() {

	var users = [];

	var initButtonListener = function() {
		$('#startDraftGeneratorBtn').click(function() {
			console.log("Start Draft Generator");

			// Disable button

<<<<<<< HEAD
=======
			//TODO Get number of users, assign random number from 1:n where n is 
			// the total number of users.

			console.log(users);
			// Ajax update with data

>>>>>>> 16f9b20ade78188a45b7ba5ed37f7f15846fdc0b
			var arr = []
			while (arr.length < users.length) {
				var randomnumber = Math.ceil(Math.random() * users.length);
				var found = false;
				for (var i = 0; i < arr.length; i++) {
					if (arr[i] == randomnumber) {
						found = true;
						break
					}
				}
				if (!found)
					arr[arr.length] = randomnumber;
					users[i].draftOrder = randomnumber;
			}
<<<<<<< HEAD

			// Ajax call to update users
=======
			console.log(arr);
			console.log(users);
			console.log(JSON.stringify(users));
			// Ajax call to update users
			
>>>>>>> 16f9b20ade78188a45b7ba5ed37f7f15846fdc0b
			$.ajax({
				type : 'POST',
				url : ctx + '/fpldraftpick/updateDraftPickOrder',
				contentType : 'application/json; charset=utf-8',
			    data: JSON.stringify(users),
				error : function(error) {
					console.log("Error with Ajax call");
					console.log(error);
				},
				success : function(response) {
					console.log("Successfully updated Draft Order");
					DraftGenerator.oTable.ajax.reload();

				}
			});
<<<<<<< HEAD
=======
			// Reload Table
			

>>>>>>> 16f9b20ade78188a45b7ba5ed37f7f15846fdc0b
		});

	};

	return {
		
		oTable : null,
		initDraftGenerator : function() {

			initButtonListener();

			DraftGenerator.oTable = $('#playerOrderDatatable').DataTable({
				"ajax" : {
					type : 'POST',
					url : ctx + '/fpldraftpick/getAllDraftPickUsers',
					error : function() {
						console.log("Error with Ajax call")
					},
					complete : function(response) {
						console.log("COMPLETE");

						users = response.responseJSON.aaData;
						console.log( response.responseJSON.aaData );

					}
				},
				"columns" : [ {
					"title" : "Name",
					"data" : "username"
				}, {
					"title" : "Order",
					"data" : "draftOrder"
				} ],
			});
		},

	}
})();