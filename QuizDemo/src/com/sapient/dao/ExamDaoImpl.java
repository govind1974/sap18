package com.sapient.dao;

import static com.sapient.dao.DbDetails.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.entity.Question;

public class ExamDaoImpl implements IDao{
	
	private static Logger log= DbDetails.logger;
	private static IDao dao = new ExamDaoImpl();
	
	private ExamDaoImpl(){
		
	}
	public static IDao getDao(){
		return dao;
	}
	static{
		try {
			Class.forName(DbDetails.DRIVER);
			log.info("driver loaded");
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
		}
	}
	@Override
	public Map<Integer, Question> getQuestions() {
		Map<Integer, Question> qmap= new HashMap<>();
		Question ques = null;
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PWD)){
			PreparedStatement st = conn.prepareStatement(QRY);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				ques = new Question();
				ques.setQid(rs.getInt("qid"));
				ques.setQdesc(rs.getString("qdesc"));
				ques.setOpta(rs.getString("optiona"));
				ques.setOptb(rs.getString("optionb"));
				ques.setOptc(rs.getString("optionc"));
				ques.setRes(rs.getString("answer"));
				qmap.put(ques.getQid(), ques);
				log.debug(ques.toString());
			}
		}catch(SQLException ex){
			log.error(ex.getMessage());
		}
		return qmap;
	}

}









