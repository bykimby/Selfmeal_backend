package com.example.SelfMeal.diet.service;


import com.example.SelfMeal.diet.dto.DietDto;
import com.example.SelfMeal.diet.entity.DietEntity;
import com.example.SelfMeal.diet.mapper.DietMapper;
import com.example.SelfMeal.diet.repository.DietRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DietService {
    public DietService(DietRepository dietRepository, DietMapper dietMapper) {
        this.dietRepository = dietRepository;
        this.dietMapper = dietMapper;
    }

    private final DietRepository dietRepository;
    private final DietMapper dietMapper;

    public DietDto createDiet(DietDto dietDto){
        DietEntity dietEntity = dietMapper.toEntity(dietDto);
        DietEntity returnEntity =  dietRepository.save(dietEntity);
        return dietMapper.toDto(returnEntity);
    }

    public Optional<DietDto> getByUserId(Long userId){
        Optional<DietEntity> dietEntity=dietRepository.findByUser_Id(userId);
        DietEntity returnEntity=dietEntity.orElseThrow(()->new EntityNotFoundException("DietEntity not found with id : "+userId));
        DietDto dietDto=dietMapper.toDto(returnEntity);
        return Optional.ofNullable(dietDto);
    }

    public void deleteDiet(Long dietId){
        dietRepository.deleteById(dietId);
    }


}
