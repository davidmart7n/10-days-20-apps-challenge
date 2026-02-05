package io.github.davidmart7n.cryptoportfolio.dto;

import org.springframework.stereotype.Component;

import io.github.davidmart7n.cryptoportfolio.domain.Asset;
import io.github.davidmart7n.cryptoportfolio.dto.AssetDTO;

@Component
public class AssetMapper {
    
    public Asset toModel(AssetDTO dto){
        
        return new Asset(null, 
                        dto.name(), 
                        dto.quantity(),
                        dto.purchasePrice());

    }

    public AssetDTO toDTO(Asset model){
        return  AssetDTO.builder()
                        .id(model.getId())
                        .name(model.getName())
                        .quantity(model.getQuantity())
                        .purchasePrice(model.getPurchasePrice())
                        .build();

    }
}
