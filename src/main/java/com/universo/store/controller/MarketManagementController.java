package com.universo.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.universo.store.dto.MarketDto;

public interface MarketManagementController {

	public List<MarketDto> viewMarket();
	
	public ResponseEntity<MarketDto> getMarket(Long id);
	
	//public String showFormCreateAsset(Model model); // Esto se gestiona en Angular
	
	public ResponseEntity<Object> saveMarket(MarketDto marketDto);
	
	// public ModelAndView showFormEditAsset(@PathVariable(name="id") Long id);   // Esto se gestiona en Angular 
	
	public ResponseEntity<MarketDto> updateMarket(Long id, MarketDto updatedMarketDto);
	
	public ResponseEntity<Object> deleteMarket(Long id);
	
}
