package com.sapient.dao;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DbDetails {
    ResourceBundle rb = ResourceBundle.getBundle("sapient");
    Logger logger = LoggerFactory.getLogger("sapient");
	String URL = rb.getString("url");
	String DRIVER= rb.getString("driver");
	String UNAME = rb.getString("uname");
	String PWD = rb.getString("pwd");
	String QRY="select * from questions";
}
