package com.bms.model;

import com.bms.dao.PredictiveAnalysisDaoImpl;
import com.bms.view.PrintPredictiveAnalysis;

public class PredictiveAnalysisModelImpl implements PredictiveAnalysisModel{

	private float soc;
	private float distance;
	private float lossOfCharge;
	private float efficiency;
	private float range;
	private float odometerDistance;
	private String message;
	private PrintPredictiveAnalysis view = new PrintPredictiveAnalysis();

	private PredictiveAnalysisDaoImpl database = new PredictiveAnalysisDaoImpl();;
	
	//Singleton
	private static final PredictiveAnalysisModelImpl instance = new PredictiveAnalysisModelImpl();
	
	
	@Override
	public void rangeCalculator(float soc, float odometerDistance) {
		range = soc * fuelEffCal(soc,odometerDistance);
		//sensor.getStateOfCharge() * analysisModelImpl.fuelEffCal(soc,odometerDistance)
		range = Math.round(range);
		
		message = "Range is " + range + "km";
		view.DisplayPredictiveAnalysisMessage(message);
		
		//return range;
	}

	@Override
	public float fuelEffCal(float soc, float odometerDistance) {
		distance = odometerDistance - database.getDistance();
		//soc = sensor.getStateOfCharge();
		lossOfCharge = database.getSoc() - soc;
		efficiency = (distance/1000)/lossOfCharge; //divided by 1000 to convert it km
		saveSoc(soc); //update the database with the new soc value
		saveOdometerDistance(odometerDistance); //update the database with the new distance
		
		return efficiency;
	}
	
	public void saveOdometerDistance(float odometerDistance) {
		this.odometerDistance = odometerDistance;
		database.saveDistance(odometerDistance);
	}
	
	public void saveSoc(float soc) {
		this.soc = soc;
		database.saveSoc(soc);
	}
	
	public static PredictiveAnalysisModelImpl getInstance() {
		return instance;
	}

}
