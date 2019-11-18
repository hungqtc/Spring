package com.hung.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.converter.RoleConverter;
import com.hung.dto.RoleDTO;
import com.hung.entity.RoleEntity;
import com.hung.repository.RoleRepository;
import com.hung.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	 @Autowired
	 private RoleRepository roleRepository;
	 
	 @Autowired
	 private RoleConverter roleConverter;
	 
	 @Override
		public List<RoleDTO> getAll() {
			List<RoleEntity> listEntity = roleRepository.findAll();
			return roleConverter.toDTO(listEntity);
		}

		@Override
		public RoleDTO getById(Long id) {
			RoleEntity entity = roleRepository.findOne(id);
			return roleConverter.toDTO(entity);
		}

		@Override
		public RoleDTO save(RoleDTO RoleDTO) {
			RoleEntity RoleEntity = new RoleEntity();
			
			if (RoleDTO.getId() != null) {
				RoleEntity oldRoleEntity = roleRepository.findOne(RoleDTO.getId());
				RoleEntity = roleConverter.toEntity(RoleDTO, oldRoleEntity);
			} else {
				RoleEntity = roleConverter.toEntity(RoleDTO);
			}
			RoleEntity = roleRepository.save(RoleEntity);
			return roleConverter.toDTO(RoleEntity);
		}

		@Override
		public void delete(Long RoleId) {
			roleRepository.delete(RoleId);
		}
}
