package com.fpl.draftPick.web.player;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.service.PlayersService;


@Controller
public class PlayerController {

	@Autowired
	private PlayersService playerSevice;
	
	@RequestMapping(value = "/fpldraftpick/getAllPlayers")
	public @ResponseBody List<Player> allFPLPlayers(){
		
		List<Player> allPlayers = playerSevice.getAllPlayers();
		
		return allPlayers;
		
	}
	
}
