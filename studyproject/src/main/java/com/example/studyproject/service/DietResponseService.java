package com.example.studyproject.service;

import com.example.studyproject.entity.DietChatDto;
import com.example.studyproject.entity.DietChatEntity;
import com.example.studyproject.entity.DietResponseDto;
import com.example.studyproject.entity.DietResponseEntity;
import com.example.studyproject.mapper.DietResponseMapper;
import com.example.studyproject.repository.DietResponseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DietResponseService {
    private final DietResponseRepository dietResponseRepository;
    private final DietResponseMapper dietResponseMapper;

    public DietResponseService(DietResponseRepository dietResponseRepository, DietResponseMapper dietResponseMapper) {
        this.dietResponseRepository = dietResponseRepository;
        this.dietResponseMapper = dietResponseMapper;
    }
    public DietResponseDto createDietResponse(DietResponseDto dietResponseDto){
        DietResponseEntity dietResponseEntity = dietResponseMapper.toEntity(dietResponseDto);
        DietResponseEntity returnEntity =  dietResponseRepository.save(dietResponseEntity);
        return dietResponseMapper.toDto(returnEntity);
    }

    public void deleteDietResponse(Long dietResponseId){
        dietResponseRepository.deleteById(dietResponseId);
    }
    public List<DietResponseDto> searchDietsByTitle(Long userId,String keyword){
        List<DietResponseEntity> dietResponseEntities=dietResponseRepository.findByUserIdAntDietNameContaining(userId,keyword);
        List<DietResponseDto> dietResponseDtos = dietResponseEntities.stream()
                .map(dietResponseEntity -> dietResponseMapper.toDto(dietResponseEntity))
                .collect(Collectors.toList());
        return dietResponseDtos;
    }
    public List<DietResponseDto> getAllDietResponses(){
        List<DietResponseEntity> dietResponseEntities=dietResponseRepository.findAll();
        List<DietResponseDto> dietResponseDtos=dietResponseEntities.stream()
                .map(dietResponseEntity -> dietResponseMapper.toDto(dietResponseEntity))
                .collect(Collectors.toList());
        return dietResponseDtos;
    }
    public List<DietResponseDto> getById(Long userId){
        List<DietResponseEntity> dietResponseEntities=dietResponseRepository.findByUserId(userId);
        List<DietResponseDto> dietResponseDtos=dietResponseEntities.stream()
                .map(dietResponseEntity -> dietResponseMapper.toDto(dietResponseEntity))
                .collect(Collectors.toList());
        return dietResponseDtos;
    }
    public Optional<DietResponseDto> findXthMostLiked(int x) {
        Pageable pageable = PageRequest.of(0, x); // 시작 페이지와 페이지 크기
        List<DietResponseEntity> dietResponseEntities = dietResponseRepository.findAllByOrderByLikesDesc(pageable);

        if (dietResponseEntities.size() < x) {
            return Optional.empty();
        }

        DietResponseEntity dietResponseEntity = dietResponseEntities.get(x - 1);
        DietResponseDto dietResponseDto = dietResponseMapper.toDto(dietResponseEntity);
        return Optional.ofNullable(dietResponseDto);
    }
}
