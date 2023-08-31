package com.example.SelfMeal.gptResponse.controller;

import com.example.SelfMeal.diet.dto.DietDto;
import com.example.SelfMeal.gptResponse.dto.GptResponseDto;
import com.example.SelfMeal.gptResponse.service.GptResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recommend")
public class GptResponseController {
    private final GptResponseService gptResponseService;
    public GptResponseController(GptResponseService gptResponseService) {
        this.gptResponseService = gptResponseService;
    }
    @PostMapping("")
    public List<GptResponseDto> createRecommendDiets(@RequestBody DietDto dietDto){
        List<GptResponseDto> gptResponseDtos=gptResponseService.createRecommendDiets(dietDto);
        return gptResponseDtos;
    }
    @DeleteMapping("/{gptResponseId}")
    public void deleteDietResponse(@PathVariable("gptResponseId") Long gptResponseId){
        gptResponseService.deleteDietResponse(gptResponseId);
    }
    @GetMapping("/{userId}/{keyword}")
    public List<GptResponseDto> searchDietsByTitle(@PathVariable("userId") Long userId,@PathVariable("keyword") String keyword){
        List<GptResponseDto> gptResponseDtos=gptResponseService.searchDietsByTitle(userId,keyword);
        return gptResponseDtos;
    }
    @GetMapping("")
    public List<GptResponseDto> getAllDietResponse(){
        List<GptResponseDto> gptResponseDtos=gptResponseService.getAllDietResponses();
        return gptResponseDtos;
    }
    @GetMapping("/{userId}")
    public List<GptResponseDto> getByUserId(@PathVariable("userId")Long userId){
        List<GptResponseDto> gptResponseDtos=gptResponseService.getByUserId(userId);
        return gptResponseDtos;
    }
    @GetMapping("/{liked}")
    public Optional<GptResponseDto> findXthMostLiked(@PathVariable("liked")int liked){
        Optional<GptResponseDto> gptResponseDto=gptResponseService.findXthMostLiked(liked);
        return gptResponseDto;
    }
}
