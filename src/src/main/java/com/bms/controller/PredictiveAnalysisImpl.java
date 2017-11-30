package com.bms.controller;

public class PredictiveAnalysisImpl implements PredictiveAnalysis {
	
	private PrintPredictiveAnalysis view;
	private sensorControllerImpl sensor;
	private PredictiveAnalysisDaoImpl database;
	private float soc;
	private float distance;
	private float lossOfCharge;
	private float efficiency;
	private float range;

	
	public PredictiveAnalysisImpl(PrintPredictiveAnalysis view) {
		this.view = view;
	}

	
	public float fuelEffCal() {
		// TODO Auto-generated method stub
		distance = database.getDistance();
		lossOfCharge = database.getSoc() - sensor.getStateOfCharge();
		efficiency = (distance/1000)/lossOfCharge; //divided by 1000 to convert it km
		
		return efficiency;
	}

	@Override
	public float rangeCalculator() {
		// TODO Auto-generated method stub
		range = sensor.getStateOfCharge() * fuelEffCal();
		range = Math.round(range);
		return range;
	}
	
	public void updateView() {
		view.DisplayPredictiveAnalysisMessage();
	}
	
}

