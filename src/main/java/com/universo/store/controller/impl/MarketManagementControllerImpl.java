package com.universo.store.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.universo.store.controller.MarketManagementController;
import com.universo.store.dto.MarketDto;
import com.universo.store.dto.mapper.MarketMapper;
import com.universo.store.dto.model.Market;
import com.universo.store.service.MarketManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/market_store/market")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Markets", description = "Market management API for market creation, update, delete, and retrieval")
public class MarketManagementControllerImpl implements MarketManagementController {

    @Autowired
    private MarketManagementService service;

    @Operation(summary = "List all markets ordered by code")
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    @Override
    public List<MarketDto> viewMarket() {
        List<Market> listMarkets = service.obtainMarketOrderCode();
        return listMarkets.stream().map(MarketMapper::toDto).toList();
    }

    @Operation(summary = "Get market by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Market found"),
            @ApiResponse(responseCode = "404", description = "Market not found")
        })
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<MarketDto> getMarket(@PathVariable Long id) {
        Market market = service.get(id);
        MarketDto marketDto = MarketMapper.toDto(market);
        return ResponseEntity.ok(marketDto);
    }

    @Operation(summary = "Save a new market")
    @PostMapping("/save")
    @Override
    public ResponseEntity<Object> saveMarket(@Valid @RequestBody MarketDto marketDto) {
        Market market = MarketMapper.toEntity(marketDto);
        service.save(market);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update an existing market")
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<MarketDto> updateMarket(
            @PathVariable Long id,
            @Valid @RequestBody MarketDto updatedMarketDto) {

        Market existingMarket = service.get(id);
        Market updatedMarket = MarketMapper.toEntity(updatedMarketDto);

        existingMarket.setCode(updatedMarket.getCode());
        existingMarket.setDescription(updatedMarket.getDescription());
        existingMarket.setSector(updatedMarket.getSector());
        existingMarket.setCountry(updatedMarket.getCountry());

        service.save(existingMarket);

        MarketDto existingMarketDto = MarketMapper.toDto(existingMarket);
        return ResponseEntity.ok(existingMarketDto);
    }

    @Operation(summary = "Delete market by ID")
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> deleteMarket(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
