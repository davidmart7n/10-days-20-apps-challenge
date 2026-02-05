package io.github.davidmart7n.cryptoportfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.davidmart7n.cryptoportfolio.domain.Asset;
import io.github.davidmart7n.cryptoportfolio.dto.AssetDTO;
import io.github.davidmart7n.cryptoportfolio.dto.AssetMapper;
import io.github.davidmart7n.cryptoportfolio.repository.AssetRepository;

@Service
public class AssetService {

    private final AssetRepository repository;
    private final AssetMapper mapper;

    public AssetService(AssetRepository repository, AssetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AssetDTO> getAssets() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList(); 
    }

    public AssetDTO getAsset(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO) 
                .orElseThrow(() -> new RuntimeException("Asset no encontrado"));
    }

    public AssetDTO buyAsset(AssetDTO dto) {
        Asset assetToSave = mapper.toModel(dto);
        
        Asset savedAsset = repository.save(assetToSave);
        
        return mapper.toDTO(savedAsset);
    }
}