
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

import com.hung.dto.AddressDTO;
import com.hung.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping(value = "/address")
	public List<AddressDTO> getAll() {
		return addressService.getAll();
	}
	
	@GetMapping(value = "/address/{id}")
	public AddressDTO getOneById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@DeleteMapping(value = "/address/{id}")
	public void deleteAddress(@PathVariable long id) {
		addressService.delete(id);
	}

	@PostMapping(value = "/address")
	public AddressDTO insertAddress(@RequestBody AddressDTO address) {
		return addressService.save(address);
	}

	@PutMapping(value = "/address/{id}")
	public AddressDTO editAddress(@RequestBody AddressDTO address, @PathVariable long id) {
		address.setId(id);
		return addressService.save(address);
	}

}
