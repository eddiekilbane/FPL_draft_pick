/*
 * draftSelection.js - handle loading of the FPL players table, 
 *  handle user inputs for player selection.
 *  
 *  Author - Eddie Kilbane
 */

var DraftSelection = (function() {
	// Properties
	///////////////////////////

	//var x = 0;

	// Private Methods
	///////////////////////////

	/*
	 * An example private method.
	 */
	//var privateMethod = function () {};
	// Public Methods
	///////////////////////////
	/*
	 * An example public method.
	 */
	//var publicMethod = function () {};
	// Init
	///////////////////////////
	//x = 10 + x;
	// Reveal public methods
	return {
		initDraftSelection : function() {
			 $.ajax({
		            url : ctx + '/fpldraftpick/getAllPlayers',
		            success : function(data) {
		                console.log(data);
		            }
		        });
		},

	}

})();