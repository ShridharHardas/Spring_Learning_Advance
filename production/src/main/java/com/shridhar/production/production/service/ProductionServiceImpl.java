package com.shridhar.production.production.service;

import com.shridhar.production.production.dto.ProductionDto;
import com.shridhar.production.production.entity.Production;
import com.shridhar.production.production.exception.ResourceNotFoundException;
import com.shridhar.production.production.repository.ProductionRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepo productionRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<ProductionDto> findAll() {
       return productionRepo.findAll()
               .stream()
               .map(production -> modelMapper.map(production, ProductionDto.class))
               .toList();

    }

    @Override
    public ProductionDto createNewProduction(ProductionDto productionDto) {
        Production production = modelMapper.map(productionDto, Production.class);
        return modelMapper.map(productionRepo.save(production),ProductionDto.class);
    }

    @Override
    public ProductionDto findByID(Long id) {
         Production production=productionRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Production Id was Not Found :"+id));
           return modelMapper.map(production,ProductionDto.class);
    }

    @Override
    public ProductionDto updateByName(Long id, ProductionDto productionDto) {
        Production production=productionRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Id is Not Found :"+id));
        productionDto.setId(id);
        modelMapper.map(productionDto,production);
        Production updatedProduct=productionRepo.save(production);
        return modelMapper.map(updatedProduct,ProductionDto.class);
    }
}
