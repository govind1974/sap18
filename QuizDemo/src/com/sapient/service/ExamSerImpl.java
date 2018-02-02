package com.sapient.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.sapient.dao.DbDetails;
import com.sapient.dao.ExamDaoImpl;
import com.sapient.dao.IDao;
import com.sapient.entity.Question;
import com.sapient.test.DaoTest;

public class ExamSerImpl implements IExamSer{
   
	private IDao dao= ExamDaoImpl.getDao();
	private static Map<Integer, Question> qmap = null;
	private static final  IExamSer ser = new ExamSerImpl();
	
	private ExamSerImpl(){
		
	}
	
	public static IExamSer getService(){
		return ser;
	}
	
	@Override
	public List<Question> generateQuestions() {
		List<Question> lst = new ArrayList<>();
		if(qmap == null)
			qmap = dao.getQuestions();
		for(int key: getQuestionNos()){
			lst.add(qmap.get(key));
		}
		return lst;
	}

	@Override
	public int evaluate(Map<Integer, String> amap) {
		int score=0;
		for(int qid: amap.keySet()){
			if(amap.get(qid).equalsIgnoreCase(qmap.get(qid).getRes()))
				++score;
		}
		return score;
	}

	public Set<Integer> getQuestionNos(){
		Set<Integer> set = new HashSet<>();
		Random rand = new Random();
		while(set.size() < 5){
			set.add(rand.nextInt(15)+1);
		}
		DbDetails.logger.debug(set.toString());
		return set;
	}
}







