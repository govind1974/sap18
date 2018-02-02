package com.sapient.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.dao.ExamDaoImpl;
import com.sapient.dao.IDao;
import com.sapient.entity.Question;

@RunWith(JUnitPlatform.class)
public class DaoTest {

	private static IDao dao;
	
	@BeforeAll
	public static void beforeAll(){
		dao = ExamDaoImpl.getDao();
	}
	
	@Test
	public void testDao1(){
		Assertions.assertEquals(15, dao.getQuestions().size());
	}
	
	@Test
	public void testDao2(){
		Question actual = dao.getQuestions().get(3);
		Question expected = new Question();
		expected.setQid(3);
		expected.setQdesc("what is the size of short type");
		expected.setOpta("1");
		expected.setOptb("2");
		expected.setOptc("4");
		expected.setRes("2");
		
		Assertions.assertEquals(actual.toString(), expected.toString());
	}
}








