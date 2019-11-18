package com.hung.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.converter.UserConverter;
import com.hung.dto.UserDTO;
import com.hung.entity.UserEntity;
import com.hung.repository.UserRepository;
import com.hung.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private UserConverter userConverter;
	 
	 @Override
		public List<UserDTO> getAll() {
			List<UserEntity> listEntity = userRepository.findAll();
			return userConverter.toDTO(listEntity);
		}

		@Override
		public UserDTO getById(Long id) {
			UserEntity entity = userRepository.findOne(id);
			return UserConverter.toDTO(entity);
		}

		@Override
		public UserDTO save(UserDTO UserDTO) {
			UserEntity UserEntity = new UserEntity();
			
			if (UserDTO.getId() != null) {
				UserEntity oldUserEntity = userRepository.findOne(UserDTO.getId());
				UserEntity = userConverter.toEntity(UserDTO, oldUserEntity);
			} else {
				UserEntity = userConverter.toEntity(UserDTO);
			}
			UserEntity = userRepository.save(UserEntity);
			return UserConverter.toDTO(UserEntity);
		}

		@Override
		public void delete(Long UserId) {
			userRepository.delete(UserId);
		}
}
