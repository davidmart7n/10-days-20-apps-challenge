package io.github.davidmart7n.cryptoportfolio.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.davidmart7n.cryptoportfolio.dto.AssetDTO;
import io.github.davidmart7n.cryptoportfolio.service.AssetService;

@RestController
@RequestMapping("api/assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service){
        this.service=service;
    }
    @GetMapping
    public List<AssetDTO> getAssets(){
        return service.getAssets();
    }

    @GetMapping("/{id}")
    public AssetDTO getAsset(@PathVariable Long id){
        return service.getAsset(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AssetDTO buyAsset(@RequestBody AssetDTO dto){
        return service.buyAsset(dto);
    }
}
