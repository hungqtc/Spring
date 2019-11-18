package com.hung.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hung.dto.AddressDTO;
import com.hung.entity.AddressEntity;

@Component
public class AddressConverter {
	public AddressEntity toEntity(AddressDTO dto) {
		AddressEntity entity = new AddressEntity();
		entity.setCity(dto.getCity());
		return entity;
	}

	public static AddressDTO toDTO(AddressEntity entity) {
		AddressDTO dto = new AddressDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCity(entity.getCity());
		dto.setUser(entity.getUser().getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public AddressEntity toEntity(AddressDTO dto, AddressEntity entity) {
		entity.setCity(dto.getCity());
		return entity;
	}
	
	public List<AddressDTO> toDTO(List<AddressEntity> listEntity) {
		List<AddressDTO> listDTO = new ArrayList<AddressDTO>();
		for (AddressEntity entity : listEntity) {
			listDTO.add(toDTO(entity));
		}
		return listDTO;
				
	}

}
