package com.example.SelfMeal.gptResponse.service;

import com.example.SelfMeal.diet.dto.DietDto;
import com.example.SelfMeal.gptResponse.dto.GptResponseDto;
import com.example.SelfMeal.gptResponse.entity.GptResponseEntity;
import com.example.SelfMeal.gptResponse.mapper.GptResponseMapper;
import com.example.SelfMeal.gptResponse.repository.GptResponseRepository;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class GptResponseService {
    public GptResponseService(GptResponseRepository gptResponseRepository, GptResponseMapper gptResponseMapper, ChatgptService chatgptService) {
        this.gptResponseRepository = gptResponseRepository;
        this.gptResponseMapper = gptResponseMapper;
        this.chatgptService = chatgptService;
    }
    private final GptResponseRepository gptResponseRepository;
    private final GptResponseMapper gptResponseMapper;
    private final ChatgptService chatgptService;
    public GptResponseDto getFirstDiet(DietDto dietDto){
        GptResponseDto gptResponseDto=new GptResponseDto();
        StringBuilder promptNameBuild=new StringBuilder();
        String disease=dietDto.getDietDisease();
        String kcalToEat=Float.toString(dietDto.getKcalToEat());
        String availableIngredients=dietDto.getAvailableIngredients();
        String meal=dietDto.getMeal();
        String inavailableIngrediets=dietDto.getInavailableIngredients();
        if(disease!="")
            promptNameBuild.append(disease+"에 좋은");
        if(kcalToEat!="")
            promptNameBuild.append(" "+kcalToEat+" 열량의");
        if(availableIngredients!="")
            promptNameBuild.append(" "+availableIngredients+"를 이용한");
        if(inavailableIngrediets!="")
            promptNameBuild.append(" "+inavailableIngrediets+"를 제외한");
        promptNameBuild.append(" "+meal+"메뉴 1개만 다른 내용 없이 메뉴 이름만 알려줘");
        String promptName=promptNameBuild.toString();
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
            String dietName=chatgptService.sendMessage(promptName);
            gptResponseDto.setDietName(dietName);
            return dietName;
        }).thenApplyAsync(dietName->{
            String promptIngredients=dietName+"의 1인분 재료만 다른 멘트 없이 알려줘";
            String dietIngredients=chatgptService.sendMessage(promptIngredients);
            gptResponseDto.setDietIngredients(dietIngredients);
            return dietIngredients;
        }).thenApplyAsync(dietIngredients->{
            String promptRecipe= gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서 1인분 만드는 방법만 500자 이내로 다른 멘트 없이 알려줘";
            String dietRecipe= chatgptService.sendMessage(promptRecipe);
            gptResponseDto.setDietRecipe(dietRecipe);
            return dietRecipe;
        }).thenApplyAsync(dietRecipe->{
            String promptKcal=gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서" +gptResponseDto.getDietRecipe()+"의 방법으로 만들었을 때 1인분 열량을 다른 내용 없이 숫자만 알려줘";
            String dietKcal= chatgptService.sendMessage(promptKcal);
            gptResponseDto.setDietKcal(dietKcal);
            return null;
        }).thenRun(()->{
            createDietEntity(gptResponseDto);
        });
        future.join();
        return gptResponseDto;
    }
    public GptResponseDto getSecondDiet(DietDto dietDto, String firstDiet){
        GptResponseDto gptResponseDto=new GptResponseDto();
        StringBuilder promptNameBuild=new StringBuilder();
        String disease=dietDto.getDietDisease();
        String kcalToEat=Float.toString(dietDto.getKcalToEat());
        String availableIngredients=dietDto.getAvailableIngredients();
        String meal=dietDto.getMeal();
        String inavailableIngrediets=dietDto.getInavailableIngredients();
        promptNameBuild.append(firstDiet+"를 제외한");
        if(disease!="")
            promptNameBuild.append(disease+"에 좋은");
        if(kcalToEat!="")
            promptNameBuild.append(" "+kcalToEat+" 열량의");
        if(availableIngredients!="")
            promptNameBuild.append(" "+availableIngredients+"를 이용한");
        if(inavailableIngrediets!="")
            promptNameBuild.append(" "+inavailableIngrediets+"를 제외한");
        promptNameBuild.append(" "+meal+"음식 1개만 다른 내용 없이 음식 이름만 알려줘");
        String promptName=promptNameBuild.toString();
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
            String dietName=chatgptService.sendMessage(promptName);
            gptResponseDto.setDietName(dietName);
            return dietName;
        }).thenApplyAsync(dietName->{
            String promptIngredients=dietName+"의 1인분 재료만 다른 멘트 없이 알려줘";
            String dietIngredients=chatgptService.sendMessage(promptIngredients);
            gptResponseDto.setDietIngredients(dietIngredients);
            return dietIngredients;
        }).thenApplyAsync(dietIngredients->{
            String promptRecipe= gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서 1인분 만드는 방법만 500자 이내로 다른 멘트 없이 알려줘";
            String dietRecipe= chatgptService.sendMessage(promptRecipe);
            gptResponseDto.setDietRecipe(dietRecipe);
            return dietRecipe;
        }).thenApplyAsync(dietRecipe->{
            String promptKcal=gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서" +gptResponseDto.getDietRecipe()+"의 방법으로 만들었을 때 1인분 열량을 다른 내용 없이 숫자만 알려줘";
            String dietKcal= chatgptService.sendMessage(promptKcal);
            gptResponseDto.setDietKcal(dietKcal);
            return null;
        }).thenRun(()->{
            createDietEntity(gptResponseDto);
        });
        future.join();
        return gptResponseDto;
    }
    public GptResponseDto getThirdDiet(DietDto dietDto, String firstDiet,String secondDiet){
        GptResponseDto gptResponseDto=new GptResponseDto();
        StringBuilder promptNameBuild=new StringBuilder();
        String disease=dietDto.getDietDisease();
        String kcalToEat=Float.toString(dietDto.getKcalToEat());
        String availableIngredients=dietDto.getAvailableIngredients();
        String meal=dietDto.getMeal();
        String inavailableIngrediets=dietDto.getInavailableIngredients();
        promptNameBuild.append(firstDiet+"와" +secondDiet+"를 제외한");
        if(disease!="")
            promptNameBuild.append(disease+"에 좋은");
        if(kcalToEat!="")
            promptNameBuild.append(" "+kcalToEat+" 열량의");
        if(availableIngredients!="")
            promptNameBuild.append(" "+availableIngredients+"를 이용한");
        if(inavailableIngrediets!="")
            promptNameBuild.append(" "+inavailableIngrediets+"를 제외한");
        promptNameBuild.append(" "+meal+"메뉴 1개를 다른 내용 없이 메뉴 이름만 알려줘");
        String promptName=promptNameBuild.toString();
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
            String dietName=chatgptService.sendMessage(promptName);
            gptResponseDto.setDietName(dietName);
            return dietName;
        }).thenApplyAsync(dietName->{
            String promptIngredients=dietName+"의 1인분 재료만 다른 멘트 없이 알려줘";
            String dietIngredients=chatgptService.sendMessage(promptIngredients);
            gptResponseDto.setDietIngredients(dietIngredients);
            return dietIngredients;
        }).thenApplyAsync(dietIngredients->{
            String promptRecipe= gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서 1인분 만드는 방법만 500자 이내로 다른 멘트 없이 알려줘";
            String dietRecipe= chatgptService.sendMessage(promptRecipe);
            gptResponseDto.setDietRecipe(dietRecipe);
            return dietRecipe;
        }).thenApplyAsync(dietRecipe->{
            String promptKcal=gptResponseDto.getDietName()+"을"+gptResponseDto.getDietIngredients()+"을 이용해서" +gptResponseDto.getDietRecipe()+"의 방법으로 만들었을 때 1인분 열량을 다른 내용 없이 숫자만 알려줘";
            String dietKcal= chatgptService.sendMessage(promptKcal);
            gptResponseDto.setDietKcal(dietKcal);
            return null;
        }).thenRun(()->{
            createDietEntity(gptResponseDto);
        });
        future.join();
        return gptResponseDto;
    }
    public List<GptResponseDto> createRecommendDiets(DietDto dietDto){
        List<GptResponseDto> gptResponseDtos=new ArrayList<>();;
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
            GptResponseDto firstDiet=getFirstDiet(dietDto);
            gptResponseDtos.add(firstDiet);
            return firstDiet.getDietName();
        }).thenApplyAsync(firstDietName-> {
            GptResponseDto secondDiet=getSecondDiet(dietDto, firstDietName);
            gptResponseDtos.add(secondDiet);
            return secondDiet.getDietName();
        }).thenApplyAsync(secondDietName->{
            GptResponseDto thirdDiet=getThirdDiet(dietDto,gptResponseDtos.get(0).getDietName(),secondDietName);
            gptResponseDtos.add(thirdDiet);
            return null;
        });
        future.join();
        return gptResponseDtos;
    }
    public GptResponseDto createDietEntity(GptResponseDto dietResponseDto){
        GptResponseEntity dietResponseEntity = gptResponseMapper.toEntity(dietResponseDto);
        GptResponseEntity returnEntity =  gptResponseRepository.save(dietResponseEntity);
        return gptResponseMapper.toDto(returnEntity);
    }
    public void deleteDietResponse(Long gptResponseId){
        gptResponseRepository.deleteById(gptResponseId);
    }
    public List<GptResponseDto> searchDietsByTitle(Long userId,String keyword){
        List<GptResponseEntity> gptResponseEntities=gptResponseRepository.findByUserIdAntDietNameContaining(userId,keyword);
        List<GptResponseDto> gptResponseDtos = gptResponseEntities.stream()
                .map(dietResponseEntity -> gptResponseMapper.toDto(dietResponseEntity))
                .collect(Collectors.toList());
        return gptResponseDtos;
    }
    public List<GptResponseDto> getAllDietResponses(){
        List<GptResponseEntity> gptResponseEntities=gptResponseRepository.findAll();
        List<GptResponseDto> gptResponseDtos=gptResponseEntities.stream()
                .map(gptResponseEntity -> gptResponseMapper.toDto(gptResponseEntity))
                .collect(Collectors.toList());
        return gptResponseDtos;
    }
    public List<GptResponseDto> getByUserId(Long userId){
        List<GptResponseEntity> gptResponseEntities=gptResponseRepository.findByUserId(userId);
        List<GptResponseDto> gptResponseDtos=gptResponseEntities.stream()
                .map(gptResponseEntity -> gptResponseMapper.toDto(gptResponseEntity))
                .collect(Collectors.toList());
        return gptResponseDtos;
    }
    public Optional<GptResponseDto> findXthMostLiked(int x) {
        Pageable pageable = PageRequest.of(0, x);
        List<GptResponseEntity> gptResponseEntities = gptResponseRepository.findAllByOrderByLikesDesc(pageable);
        if (gptResponseEntities.size() < x) {
            return Optional.empty();
        }

        GptResponseEntity gptResponseEntity = gptResponseEntities.get(x - 1);
        GptResponseDto gptResponseDto = gptResponseMapper.toDto(gptResponseEntity);
        return Optional.ofNullable(gptResponseDto);
    }
}
