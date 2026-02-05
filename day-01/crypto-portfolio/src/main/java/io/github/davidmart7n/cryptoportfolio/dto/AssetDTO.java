package io.github.davidmart7n.cryptoportfolio.dto;

import lombok.Builder;

@Builder
public record AssetDTO(Long id, String name, double quantity, double purchasePrice ) {}
