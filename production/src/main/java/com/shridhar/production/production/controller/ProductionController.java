package com.shridhar.production.production.controller;

import com.shridhar.production.production.dto.ProductionDto;
import com.shridhar.production.production.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/production")
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping("/all")
    public List<ProductionDto> findAll()
    {
        return productionService.findAll();
    }

    @PostMapping("")
    public ProductionDto createNewProduction(@RequestBody ProductionDto productionDto)
    {
      return productionService.createNewProduction(productionDto);
    }

    @GetMapping("{id}")
    public ProductionDto findById(@PathVariable Long id)
    {
        return productionService.findByID(id);
    }

    @PutMapping("/update/{id}")
    public ProductionDto update(@PathVariable Long id, @RequestBody ProductionDto productionDto)
    {
        return productionService.updateByName(id, productionDto);
    }


}
