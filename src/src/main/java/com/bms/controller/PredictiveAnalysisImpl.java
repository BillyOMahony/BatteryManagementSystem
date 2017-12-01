
package com.bms.controller;

import com.bms.dao.PredictiveAnalysisDaoImpl;
import com.bms.model.PredictiveAnalysisModelImpl;
import com.bms.view.PrintPredictiveAnalysis;

public class PredictiveAnalysisImpl implements PredictiveAnalysis{

	private PrintPredictiveAnalysis view;
	private SensorControllerImpl sensor;
	private PredictiveAnalysisDaoImpl database;
	private float soc;
	private float distance;
	private float lossOfCharge;
	private float efficiency;
	private float range;
	private float odometerDistance;
	private String message;
	private PredictiveAnalysisModelImpl analysisModelImpl = PredictiveAnalysisModelImpl.getInstance();


	//This is a singleton, it is returned by getInstance()
	private static final PredictiveAnalysisImpl instance = new PredictiveAnalysisImpl();

	//Private Constructor to ensure only one is ever made
	private PredictiveAnalysisImpl() {
		database = new PredictiveAnalysisDaoImpl();
		sensor = SensorControllerImpl.getInstance();
		view = new PrintPredictiveAnalysis();
	}

	public static PredictiveAnalysisImpl getInstance() {
		return instance;
	}

	@Override
	public void CallPredictiveAnalysis() {
		// TODO Auto-generated method stub

		// Implement this, think of it as main
		//Call everything here in the order they need to be called every time Predictive Analysis is called. 
		odometerDistance = sensor.getDistanceTravelled();
		soc = sensor.getStateOfCharge();		
		analysisModelImpl.rangeCalculator(soc, odometerDistance);
		
	}

}

