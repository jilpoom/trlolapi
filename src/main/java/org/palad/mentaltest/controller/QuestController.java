package org.palad.mentaltest.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.palad.mentaltest.dto.question.QuestionDTO;
import org.palad.mentaltest.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@Log4j2
@RequiredArgsConstructor
public class QuestController {

    private final QuestionService questionService;

    @GetMapping()
    public List<QuestionDTO> getQuestions() {
        return questionService.getList();
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{id}")
    public QuestionDTO getOne(@PathVariable String id) {
        return questionService.getOne(id);
    }


}
