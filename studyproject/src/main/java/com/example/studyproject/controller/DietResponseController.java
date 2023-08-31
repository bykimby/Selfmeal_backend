package com.example.studyproject.controller;

import com.example.studyproject.entity.DietChatDto;
import com.example.studyproject.entity.DietResponseDto;
import com.example.studyproject.mapper.DietResponseMapper;
import com.example.studyproject.service.DietResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dietResponse")
public class DietResponseController {
    private final DietResponseService dietResponseService;
    private final DietResponseMapper dietResponseMapper;

    public DietResponseController(DietResponseService dietResponseService, DietResponseMapper dietResponseMapper) {
        this.dietResponseService = dietResponseService;
        this.dietResponseMapper = dietResponseMapper;
    }
    @PostMapping("")
    public DietResponseDto createDietResponse(@RequestBody DietResponseDto dietResponseDto) {
        return dietResponseService.createDietResponse(dietResponseDto);
    }
    @DeleteMapping("/{dietResponseId}")
    public void deleteDietResponse(@PathVariable("dietResponseId") Long dietResponseId) {
        dietResponseService.deleteDietResponse(dietResponseId);
    }

    @GetMapping("/{userid}/{dietKeword}")
    public List<DietResponseDto> searchDietByTitle(@PathVariable("userId") Long userId, @PathVariable("dietKeword")String keyword){
        List<DietResponseDto> dietResponseDtos=dietResponseService.searchDietsByTitle(userId,keyword);
        return dietResponseDtos;
    }
    @GetMapping("")
    public List<DietResponseDto> getAllDietResponses(){
        List<DietResponseDto> dietResponseDtos=dietResponseService.getAllDietResponses();
        return dietResponseDtos;
    }
    @GetMapping("/{userId}")
    public List<DietResponseDto> getById(@PathVariable("userId") Long userId){
        List<DietResponseDto> dietResponseDtos=dietResponseService.getById(userId);
        return dietResponseDtos;
    }

    @GetMapping("/{xthLiked}")
    public Optional<DietResponseDto> findXthMostLiked(@PathVariable("xthLiked") int xthLiked){
        Optional<DietResponseDto> dietResponseDto=dietResponseService.findXthMostLiked(xthLiked);
        return dietResponseDto;
    }

}
