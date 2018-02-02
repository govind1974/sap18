package com.sapient.service;

import java.util.List;
import java.util.Map;

import com.sapient.entity.Question;

public interface IExamSer {

	List<Question> generateQuestions();
	int evaluate(Map<Integer, String> amap);
}
