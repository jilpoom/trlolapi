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
                .text("괜찮아, 떨어지더라도 다음이 있잖아.").build());
        list.add(Choice.builder()
                .text("이번엔 무조건 합격한다. 다음은 없다.").build());

        Question question = Question.builder()
                .choices(list)
                .question("당신은 중요한 시험을 앞두고 있습니다. 당신의 마음은?")
                .build();

        questionRepository.save(question);

    }
}
