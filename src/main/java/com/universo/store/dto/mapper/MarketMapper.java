package com.universo.store.dto.mapper;

import com.universo.store.dto.MarketDto;
import com.universo.store.dto.model.Market;

public class MarketMapper {

    // Convert Market Entity to Market DTO
    public static MarketDto toDto(Market market) {
        MarketDto dto = new MarketDto();
        dto.setId(market.getId());
        dto.setCode(market.getCode());
        dto.setDescription(market.getDescription());
        dto.setSector(market.getSector()); // ✅ Added
        dto.setCountry(market.getCountry());
        return dto;
    }

    // Convert Market DTO to Market Entity
    public static Market toEntity(MarketDto dto) {
        Market market = new Market();
        market.setId(dto.getId());
        market.setCode(dto.getCode());
        market.setDescription(dto.getDescription());
        market.setSector(dto.getSector()); // ✅ Added
        market.setCountry(dto.getCountry());
        return market;
    }

}
