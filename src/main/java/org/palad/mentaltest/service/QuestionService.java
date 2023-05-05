package org.palad.mentaltest.service;

import org.palad.mentaltest.dto.question.QuestionDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getList();
}
