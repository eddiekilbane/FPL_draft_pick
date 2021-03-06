package com.fpl.draftPick.web.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpl.draftPick.dto.PlayerDTO;
import com.fpl.draftPick.dto.UserDTO;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.service.players.PlayersService;
import com.fpl.draftPick.users.model.User;


@Controller
public class PlayerController {

	@Autowired
	private PlayersService playerService;
	
	@RequestMapping(value = "/fpldraftpick/getAllPlayers", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Map<String, Object> allFPLPlayers(){
		
		List<Player> allPlayers = playerService.getAllPlayers();
		
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
	

	@RequestMapping(value = "/fpldraftpick/getAllDraftPickUsers", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Map<String, Object> allFPLDraftPickUsers(){

		List<User> allDraftPickUsers = playerService.getAllDraftPickUsers();
		
		List<UserDTO> allDraftPickUsersDTOList = new ArrayList<UserDTO>();
		
		for(User user : allDraftPickUsers){
			UserDTO userDTO = new UserDTO(user);
			allDraftPickUsersDTOList.add(userDTO);
		}
		
		Map<String, Object> tableData = new HashMap<String, Object>();
		tableData.put("aaData",allDraftPickUsersDTOList);
		tableData.put("sEcho","false");
		tableData.put("iTotalRecords",allDraftPickUsersDTOList.size());
		tableData.put("iTotalDisplayRecords",allDraftPickUsersDTOList.size());
		
		return tableData;	
	}
	
	@RequestMapping(value = "/fpldraftpick/getAllDraftPickUsers1", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody List<UserDTO> allFPLDraftPickUsers1(){

		List<User> allDraftPickUsers = playerService.getAllDraftPickUsers();
		
		List<UserDTO> allDraftPickUsersDTOList = new ArrayList<UserDTO>();
		
		for(User user : allDraftPickUsers){
			UserDTO userDTO = new UserDTO(user);
			allDraftPickUsersDTOList.add(userDTO);
		}
		
		Map<String, Object> tableData = new HashMap<String, Object>();
		tableData.put("aaData",allDraftPickUsersDTOList);
		tableData.put("sEcho","false");
		tableData.put("iTotalRecords",allDraftPickUsersDTOList.size());
		tableData.put("iTotalDisplayRecords",allDraftPickUsersDTOList.size());
		
		return allDraftPickUsersDTOList;	
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/fpldraftpick/updateDraftPickOrder", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateDraftPickOrder(@RequestBody User[] users){
		
		for(User user : users){
			playerService.updateUser(user);
		}	
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/fpldraftpick/selectPlayerForUpdate", method=RequestMethod.POST)
	public @ResponseBody void selectPlayerForUpdate(@RequestParam int userId, @RequestParam String playerID){
		System.out.println("USER ID " + userId);
		System.out.println("PLAYER ID " + playerID);
		playerService.assignPlayerToUser(userId, playerID);
		
		
	}
}
