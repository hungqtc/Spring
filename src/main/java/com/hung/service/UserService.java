package com.hung.service;

import java.util.List;

import com.hung.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAll();

	UserDTO getById(Long id);

	UserDTO save(UserDTO userDTO);

	void delete(Long userId);
}
