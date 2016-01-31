package com.fpl.draftPick.web.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fpl.draftPick.dto.PlayerDTO;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.users.service.PlayersService;


@Controller
public class PlayerController {

	@Autowired
	private PlayersService playerSevice;
	
	@RequestMapping(value = "/fpldraftpick/getAllPlayers", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> allFPLPlayers(){
		
		List<Player> allPlayers = playerSevice.getAllPlayers();
		
		List<PlayerDTO> allPlayerDTOList = new ArrayList<PlayerDTO>();
		
		for(Player player : allPlayers){
			PlayerDTO playerDTO = new PlayerDTO(player);
			allPlayerDTOList.add(playerDTO);
		}
		
		Map<String, Object> tableData = new HashMap<String, Object>();
		tableData.put("aaData",allPlayerDTOList);
		tableData.put("sEcho","false");
		tableData.put("iTotalRecords",allPlayerDTOList.size());
		tableData.put("iTotalDisplayRecords",allPlayerDTOList.size());
		
		
		return tableData;
		
	}
	
}
