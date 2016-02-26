package com.fpl.draftPick.web.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fpl.draftPick.dto.PlayerDTO;
import com.fpl.draftPick.dto.UserDTO;
import com.fpl.draftPick.players.model.Player;
import com.fpl.draftPick.service.players.PlayersService;
import com.fpl.draftPick.service.users.MyUserDetailsService;
import com.fpl.draftPick.users.model.User;


@Controller
public class PlayerController {

	@Autowired
	private PlayersService playerSevice;
	
	@RequestMapping(value = "/fpldraftpick/getAllPlayers", method=RequestMethod.POST, produces="application/json")
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
	

	@RequestMapping(value = "/fpldraftpick/getAllDraftPickUsers", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Map<String, Object> allFPLDraftPickUsers(){

		List<User> allDraftPickUsers = playerSevice.getAllDraftPickUsers();
		
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

		List<User> allDraftPickUsers = playerSevice.getAllDraftPickUsers();
		
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
	
	@RequestMapping(value = "/fpldraftpick/updateDraftPickOrder", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateDraftPickOrder(@RequestBody User[] users){
		
		for(User user : users){
			playerSevice.updateUser(user);
			
		}	
	}
}
