package com.universo.store.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universo.store.dto.model.Market;
import com.universo.store.exception.ResourceNotFoundException;
import com.universo.store.repository.MarketRepository;

@Service
public class MarketManagementService {

	@Autowired
	private MarketRepository repo;

	// READ all
	public List<Market> listAll() {
		return repo.findAll();
	}

	// CREATE
	public void save(Market market) {
		repo.save(market);
	}

	// READ single by ID
	public Market get(Long id) {
		Supplier<? extends ResourceNotFoundException> exceptionSupplier =
			() -> new ResourceNotFoundException("Market with id " + id + " not found");

		return repo.findById(id).orElseThrow(exceptionSupplier);
	}

	// DELETE
	public void delete(Long id) {
		if (!repo.existsById(id)) {
			throw new ResourceNotFoundException("Market with id " + id + " not found");
		}
		repo.deleteById(id);
	}

	// READ ordered by code
	public List<Market> obtainMarketOrderCode() {
		return repo.getMarketOrderCode();
	}
}
