package com.sapient.entity;

public class Question {

	private int qid;
	private String qdesc;
	private String opta;
	private String optb;
	private String optc;
	private String res;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQdesc() {
		return qdesc;
	}
	public void setQdesc(String qdesc) {
		this.qdesc = qdesc;
	}
	public String getOpta() {
		return opta;
	}
	public void setOpta(String opta) {
		this.opta = opta;
	}
	public String getOptb() {
		return optb;
	}
	public void setOptb(String optb) {
		this.optb = optb;
	}
	public String getOptc() {
		return optc;
	}
	public void setOptc(String optc) {
		this.optc = optc;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	@Override
	public String toString() {
	
		return qid + " " + qdesc + " " + opta + " " + optb + " " + optc + " " + res;
	}
	
	
	
}
