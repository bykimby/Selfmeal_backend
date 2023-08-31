package com.example.studyproject.service;

import com.example.studyproject.entity.DietChatDto;
import com.example.studyproject.entity.DietChatEntity;
import com.example.studyproject.entity.DietDto;
import com.example.studyproject.entity.DietEntity;
import com.example.studyproject.mapper.DietChatMapper;
import com.example.studyproject.repository.DietChatRepository;
import org.springframework.stereotype.Service;

@Service
public class DietChatService {
    private final DietChatRepository dietChatRepository;
    private final DietChatMapper dietChatMapper;

    public DietChatService(DietChatRepository dietChatRepository, DietChatMapper dietChatMapper) {
        this.dietChatRepository = dietChatRepository;
        this.dietChatMapper = dietChatMapper;
    }
    public DietChatDto createDietChat(DietChatDto dietChatDto){
        DietChatEntity dietChatEntity = dietChatMapper.toEntity(dietChatDto);
        DietChatEntity returnEntity =  dietChatRepository.save(dietChatEntity);
        return dietChatMapper.toDto(returnEntity);
    }



    public void deleteDietChat(Long dietChatId){
        dietChatRepository.deleteById(dietChatId);
    }
}
