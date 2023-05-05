package org.palad.mentaltest.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.palad.mentaltest.domain.question.Choice;
import org.palad.mentaltest.domain.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class QuestionRepositoryTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("Get Question List")
    @Transactional
    public void getQuestionListTest() {
        List<Question> questionGroup = questionRepository.findAll();
        log.info(questionGroup);
    }

    @Test
    @DisplayName("Get Question")
    public void getQuestion() {
        Question question = questionRepository.findById(1L).orElseThrow();
        log.info(question);
    }

    @Test
    @DisplayName("Insert Question")
    public void insertQuestionList() {
        List<Choice> list = new ArrayList<>();
        list.add(Choice.builder()
                .text("선택지 1").build());
        list.add(Choice.builder()
                .text("선택지 2").build());

        Question question = Question.builder()
                .choices(list)
                .question("질문 2")
                .build();

        questionRepository.save(question);

    }
}
