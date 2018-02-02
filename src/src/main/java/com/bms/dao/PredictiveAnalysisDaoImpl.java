package com.bms.dao;

import com.bms.model.PredictiveAnalysisModelImpl;

public class PredictiveAnalysisDaoImpl {
	float distance;
	float soc;
	float efficiency = 100;
	
	//Singleton
	private static final PredictiveAnalysisDaoImpl instance = new PredictiveAnalysisDaoImpl();
	
	private PredictiveAnalysisDaoImpl() {
		System.out.println("DB Created");
	}
	
	public void setEfficiency(float e) {
		efficiency = e;
	}
	
	public float getEfficiency() {
		return efficiency;
	}
	
	public void setDistance(float x) {
		distance = x;
	}

	public float getDistance() {
		return distance;
	}
	
	public void setSoc(float x) {
		soc = x;
	}

	public float getSoc() {
		
		return soc;
	}

	public void saveDistance(float dist) {
		// TODO Auto-generated method stub
		
	}

	public void saveSoc(float soc) {
		// TODO Auto-generated method stub
		
	}
	
	public static PredictiveAnalysisDaoImpl getInstance() {
		return instance;
	}

}
