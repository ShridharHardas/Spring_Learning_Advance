package com.shridhar.production.production.service;

import com.shridhar.production.production.dto.ProductionDto;


import java.util.List;

public interface ProductionService {

    List<ProductionDto> findAll();

    public ProductionDto createNewProduction(ProductionDto productionDto);

    public ProductionDto findByID(Long id);

}
