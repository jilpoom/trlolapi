package org.palad.mentaltest.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.palad.mentaltest.domain.question.Question;
import org.palad.mentaltest.dto.question.QuestionDTO;
import org.palad.mentaltest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ModelMapperTests {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("Question - QuestionDTO Mapping")
    public void questionMap() {

        Question question = questionRepository.findById(1L).orElseThrow();

        QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);

        log.info(questionDTO);
    }


}
