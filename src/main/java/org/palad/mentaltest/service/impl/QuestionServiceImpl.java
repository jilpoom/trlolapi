package org.palad.mentaltest.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.palad.mentaltest.domain.question.Question;
import org.palad.mentaltest.dto.question.QuestionDTO;
import org.palad.mentaltest.repository.QuestionRepository;
import org.palad.mentaltest.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<QuestionDTO> getList() {
        List<Question> questionGroup = questionRepository.findAll();
        log.info(questionGroup);

        List<QuestionDTO> questionDTOGroup = questionGroup.stream()
                .map( question -> mapQuetion(question))
                .collect(Collectors.toList());

        return questionDTOGroup;
    }

    @Override
    public QuestionDTO getOne(String id) {
        Question question = questionRepository.findById(Long.valueOf(id)).orElseThrow();
        return mapQuetion(question);

    }

    public QuestionDTO mapQuetion(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setId(question.getId());

        for(int i = 0; i < question.getChoices().size(); i++) {
            questionDTO.getChoices().add(question.getChoices().get(i).getText());
        }
        return questionDTO;
    }
}
