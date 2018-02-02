package com.sapient.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sapient.entity.Question;
import com.sapient.service.ExamSerImpl;
import com.sapient.service.IExamSer;

public class Client {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		IExamSer ser = ExamSerImpl.getService();
		List<Question> lst = ser.generateQuestions();
		
		String answer=null;
		Map<Integer, String> amap = new HashMap<>();
		for(Question ques: lst){
			System.out.println(ques.getQdesc());
			System.out.println(ques.getOpta());
			System.out.println(ques.getOptb());
			System.out.println(ques.getOptc());
			answer=scan.next();
			amap.put(ques.getQid(), answer);
		}
		System.out.println("score " + ser.evaluate(amap));
	}

}






