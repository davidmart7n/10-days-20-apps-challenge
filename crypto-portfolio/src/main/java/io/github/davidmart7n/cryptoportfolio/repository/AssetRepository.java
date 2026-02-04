package io.github.davidmart7n.cryptoportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.davidmart7n.cryptoportfolio.domain.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long>{


}
