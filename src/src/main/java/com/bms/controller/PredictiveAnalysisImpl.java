package src.main.java.com.bms.controller;

import src.main.java.com.bms.dao.PredictiveAnalysisDaoImpl;
import src.main.java.com.bms.view.PrintPredictiveAnalysis;

public class PredictiveAnalysisImpl {
	
	private PrintPredictiveAnalysis view;
	private SensorControllerImpl sensor;
	private PredictiveAnalysisDaoImpl database;
	private float soc;
	private float distance;
	private float lossOfCharge;
	private float efficiency;
	private float range;
	private float odometerDistance;

	
	public PredictiveAnalysisImpl(PrintPredictiveAnalysis view) {
		this.view = view;
	}

	
	public float fuelEffCal() {
		odometerDistance = sensor.getDistanceTravelled();
		distance = odometerDistance - database.getDistance();
		soc = sensor.getStateOfCharge();
		lossOfCharge = database.getSoc() - soc;
		efficiency = (distance/1000)/lossOfCharge; //divided by 1000 to convert it km
		saveSoc(soc); //update the database with the new soc value
		saveOdometerDistance(odometerDistance); //update the database with the new distance
		
		return efficiency;
	}

	public float rangeCalculator() {
		range = sensor.getStateOfCharge() * fuelEffCal();
		range = Math.round(range);
		return range;
	}
	
	public void saveSoc(float soc) {
		this.soc = soc;
		database.saveSoc(soc);
	}
	
	public void saveOdometerDistance(float odometerDistance) {
		this.odometerDistance = odometerDistance;
		database.saveDistance(odometerDistance);
	}
	
	public void updateView() {
		view.DisplayPredictiveAnalysisMessage();
	}
	
}

