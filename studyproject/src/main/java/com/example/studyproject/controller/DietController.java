package com.example.studyproject.controller;

import com.example.studyproject.entity.DietDto;
import com.example.studyproject.mapper.DietMapper;
import com.example.studyproject.service.DietService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/diet")
public class DietController {
    private final DietService dietService;
    private final DietMapper dietMapper;

    public DietController(DietService dietService, DietMapper dietMapper) {
        this.dietService = dietService;
        this.dietMapper = dietMapper;
    }

    @PostMapping("")
    public DietDto createDiet(@RequestBody DietDto dietDto) {
        return dietService.createDiet(dietDto);
    }
    @DeleteMapping("/{dietId}")
    public void deleteDiet(@PathVariable("dietId") Long dietId) {
        dietService.deleteDiet(dietId);
    }
    @GetMapping("/{userId}")
    public Optional<DietDto> getById(@PathVariable("userId") Long userId){
        Optional<DietDto> dietDto=dietService.getById(userId);
        return dietDto;
    }
}
