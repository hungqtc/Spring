package com.hung.service;

import java.util.List;

import com.hung.dto.AddressDTO;

public interface AddressService {
	List<AddressDTO> getAll();

	AddressDTO getById(Long id);

	AddressDTO save(AddressDTO addressDTO);

	void delete(Long addressId);
}
