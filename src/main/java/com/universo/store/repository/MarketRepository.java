package com.universo.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.universo.store.dto.model.Market;

public interface MarketRepository extends JpaRepository<Market, Long> {

	// Obtain Assets order by Code
	@Query(value="SELECT m FROM market m " + 
			" ORDER BY code ASC " )
	public List<Market> getMarketOrderCode();
	
	// Version automatica hibernate
	//public List<Asset> findAllByOrderByCodeAsc();
	
}
