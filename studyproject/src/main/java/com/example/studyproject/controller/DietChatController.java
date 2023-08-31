package com.example.studyproject.controller;

import com.example.studyproject.entity.DietChatDto;
import com.example.studyproject.entity.DietDto;
import com.example.studyproject.mapper.DietChatMapper;
import com.example.studyproject.service.DietChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dietChat")
public class DietChatController {
    private final DietChatService dietChatService;
    private final DietChatMapper dietChatMapper;

    public DietChatController(DietChatService dietChatService, DietChatMapper dietChatMapper) {
        this.dietChatService = dietChatService;
        this.dietChatMapper = dietChatMapper;
    }
    @PostMapping("")
    public DietChatDto createDietChat(@RequestBody DietChatDto dietChatDto) {
        return dietChatService.createDietChat(dietChatDto);
    }
    @DeleteMapping("/{dietChatId}")
    public void deleteDietChat(@PathVariable("dietChatId") Long dietChatId) {
        dietChatService.deleteDietChat(dietChatId);
    }
}
