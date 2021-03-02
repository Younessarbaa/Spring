package com.brightcoding.app.ws.controllers;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightcoding.app.ws.reponses.AddressResponse;
import com.brightcoding.app.ws.requests.AddressRequest;
import com.brightcoding.app.ws.services.AddressService;
import com.brightcoding.app.ws.shared.dto.AddressDto;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public  ResponseEntity<List<AddressResponse>> getAddresses(Principal principal) 
	{
		
		List<AddressDto> addresses = addressService.getAllAddresses(principal.getName()); 
		
		Type listType = new TypeToken<List<AddressResponse>>() {}.getType();
		List<AddressResponse> addressesResponse = new ModelMapper().map(addresses, listType);
		
		return new ResponseEntity<List<AddressResponse>>(addressesResponse, HttpStatus.OK );
		
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<AddressResponse> getOneAddress(@PathVariable(name="id") String addressId) 
	{
		
		AddressDto addresses = addressService.getAddress(addressId); 
		
		ModelMapper modelMapper = new ModelMapper();
		
		AddressResponse addressesResponse = modelMapper.map(addresses, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(addressesResponse, HttpStatus.OK );
		
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
				)
	public ResponseEntity<AddressResponse> storeAddress(@RequestBody AddressRequest addressRequest, Principal principal)
	{
		
		ModelMapper modelMapper = new ModelMapper();
		AddressDto addressDto = modelMapper.map(addressRequest, AddressDto.class);
		
		AddressDto createAddress = addressService.createAddress(addressDto,principal.getName());
		
		AddressResponse addressResponse = modelMapper.map(createAddress, AddressResponse.class);
		
		
		return new ResponseEntity<AddressResponse>(addressResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<AddressResponse> updateAddress(@PathVariable String id, @RequestBody AddressRequest addressRequest)
	{
		ModelMapper modelMapper = new ModelMapper();
		
		AddressDto addressDto = modelMapper.map(addressRequest, AddressDto.class);
		
		AddressDto update = addressService.updateAddress(id,addressDto);
		
		AddressResponse addressResponse = modelMapper.map(update, AddressResponse.class);
		
		return new ResponseEntity<AddressResponse>(addressResponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable(name ="id") String addressId)
	{
		addressService.deleteAddress(addressId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
	}
	

}
