package com.sapient.dao;

import java.util.Map;

import com.sapient.entity.Question;

public interface IDao {

	Map<Integer, Question> getQuestions();
}
