package com.sapient.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.ExamSerImpl;
import com.sapient.service.IExamSer;

@RunWith(JUnitPlatform.class)
public class ServiceTest {
   
	private static IExamSer ser;
	
	@BeforeAll
	public static void beforeAll(){
		ser = ExamSerImpl.getService();
	}
	
	@Test
	public void testQnos(){
		Assertions.assertTrue(((ExamSerImpl)ser).getQuestionNos().size() == 5);
	}
	
	@Test
	public void testGenerateQuestions(){
		Assertions.assertTrue(ser.generateQuestions().size() == 5);
	}
	
	@Test
	public void testEvaluate(){
		Map<Integer, String> amap= new HashMap<>();
		amap.put(1, "4");
		amap.put(2, "1");
		amap.put(3, "2");
		amap.put(4, "set");
		ser.generateQuestions();
		Assertions.assertTrue(ser.evaluate(amap) == 4);
	}
	
	@Test
	public void testEvaluate2(){
		Map<Integer, String> amap= new HashMap<>();
		amap.put(1, "4");
		amap.put(2, "1");
		amap.put(3, "1");//wrong answer
		amap.put(4, "set");
		ser.generateQuestions();
		Assertions.assertTrue(ser.evaluate(amap) == 3);
	}
}





