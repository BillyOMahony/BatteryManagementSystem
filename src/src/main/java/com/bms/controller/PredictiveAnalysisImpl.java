<<<<<<< HEAD
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

=======
package com.bms.controller;

import com.bms.dao.PredictiveAnalysisDaoImpl;
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
		
		System.out.println("Predictive Analysis: Range is " + range + "km");
		
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

	@Override
	public void CallPredictiveAnalysis() {
		// TODO Auto-generated method stub
		
		// Implement this, think of it as main
		//Call everything here in the order they need to be called every time Predictive Analysis is called. 
		rangeCalculator();
	}
	
}

>>>>>>> origin/master
