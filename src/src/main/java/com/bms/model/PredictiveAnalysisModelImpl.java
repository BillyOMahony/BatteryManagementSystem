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

	private PredictiveAnalysisDaoImpl database = PredictiveAnalysisDaoImpl.getInstance();
	
	//Singleton
	private static final PredictiveAnalysisModelImpl instance = new PredictiveAnalysisModelImpl();
	
	
	@Override
	public float rangeCalculator(float soc, float odometerDistance) {
		range = soc * fuelEffCal(soc,odometerDistance);
		//float eff = fuelEffCal(soc,odometerDistance);
		//sensor.getStateOfCharge() * analysisModelImpl.fuelEffCal(soc,odometerDistance)
		range = Math.round(range);
		
		//message = "Range is " + range + "km and soc is " +soc+" and fueleff is " +eff;
		//view.DisplayPredictiveAnalysisMessage(message);
		
		return range;
	}

	@Override
	public float fuelEffCal(float soc, float odometerDistance) {
		distance = odometerDistance - database.getDistance();
		//soc = sensor.getStateOfCharge();
		
		//efficiency = (distance/1000)/lossOfCharge; //divided by 1000 to convert it km. A tiny number is added to loss of charge to prevent division by zero
		saveSoc(soc); //update the database with the new soc value
		saveOdometerDistance(odometerDistance); //update the database with the new distance
		
		lossOfCharge = database.getSoc() - soc;
		
		//if loss of charge is zero or negative use the efficiency value from the database
		if(lossOfCharge <= 0) {
			efficiency = database.getEfficiency();
			//return efficiency;
		}else {
			efficiency = (distance/1000)/lossOfCharge; //divided by 1000 to convert it km.
			
			/*this is for handling the case where the car is running but does
			not move for the duration of the sampling period*/
			if (efficiency <= 0) {
			efficiency = database.getEfficiency();
			}else {
				database.setEfficiency(efficiency);
			}
			
		}
		
		/*if (efficiency == 0) {
			efficiency = database.getEfficiency();
		}else {
			database.setEfficiency(efficiency);
		}*/
		
		message = "loss of charge " + lossOfCharge+ " and soc is "+database.getSoc()+
				" and distance is "+database.getDistance()+ "efficiency is "+ efficiency; //+ "km and soc is " +soc+" and fueleff is " +eff;
		//view.DisplayPredictiveAnalysisMessage(message);
		
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
