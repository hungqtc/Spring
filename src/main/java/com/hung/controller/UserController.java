
package com.hung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hung.dto.UserDTO;
import com.hung.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user")
	public List<UserDTO> getAll() {
		return userService.getAll();
	}
	
	@GetMapping(value = "/User/{id}")
	public UserDTO getOneById(@PathVariable long id) {
		return userService.getById(id);
	}
	
	@DeleteMapping(value = "/User/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.delete(id);
	}

	@PostMapping(value = "/User")
	public UserDTO insertUser(@RequestBody UserDTO User) {
		return userService.save(User);
	}

	@PutMapping(value = "/User/{id}")
	public UserDTO editUser(@RequestBody UserDTO User, @PathVariable long id) {
		User.setId(id);
		return userService.save(User);
	}

}
