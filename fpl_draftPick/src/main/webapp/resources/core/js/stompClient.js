/**
 * 
 */

var StompClient = (function() {
	socket = null;

	function connect() {
		var socket = new SockJS('/messenger');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/greetings', function(greeting) {
				showGreeting(JSON.parse(greeting.body).content);
			});
		});
	}

	function disconnect() {
		if (stompClient != null) {
			stompClient.disconnect();
		}
		setConnected(false);
		console.log("Disconnected");
	}

	return {
		initStompClient : function() {
			socket = new SockJS('/messenger');
			stompClient = Stomp.over(socket);
			console.log("Init stomp client");
			console.log(socket);
			console.log(stompClient);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('Connected: ' + frame);
				stompClient.subscribe('/topic/greetings', function(greeting) {
					showGreeting(JSON.parse(greeting.body).content);
				});
			});
		},

		sendName : function() {

			var name = document.getElementById('name').value;
			stompClient.send("/fpl_draftPick/messenger", {}, JSON.stringify({
				'name' : name
			}));
		},

		showGreeting : function() {

			var response = document.getElementById('response');
			var p = document.createElement('p');
			p.style.wordWrap = 'break-word';
			p.appendChild(document.createTextNode(message));
			response.appendChild(p);
		}

	}

})();