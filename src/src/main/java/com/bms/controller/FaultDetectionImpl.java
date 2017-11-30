package com.bms.controller;

import com.bms.view.PrintFaultDetection;

public class FaultDetectionImpl implements FaultDetection {
	private String FDMessage;
	float temperature;
	float velocity;
	float current;
	float soc;
	private SensorControllerImpl sensor;
	private PrintFaultDetection print;
//	private printFaultDetection view;
//	private sensorControllerImpl sensor;
//	private FaultDetectionDaoImpl database;

	private static final FaultDetectionImpl instance = new FaultDetectionImpl();
	
	private FaultDetectionImpl() {
		sensor = sensor.getInstance();
		print = new PrintFaultDetection();
	}
	
//	
//void CheckFault(float temperature, float velocity, float current, float soc) {
//	FDMessage = "";
//	if( temperature.Comparetemperature ) {
//		FDMessage = "informal temperature";
//		
//	}if else(current.Comparecurrent){
//		FDMessage = "informal current";
//	}if else(velocity.tempeComparevelocity){
//		FDMessage = "informal velocity ";
//	}if else(soc.Comparesoc){
//		FDMessage = "informal soc";
//	}
//	
//	print.printMessage(DFMessage);
//
//	
//}
//
//public void getSensorData() {
//	// TODO Auto-generated method stub
//	temperature = sensor.getTemperature();
//	velocity = sensor.getVelocity();
//	soc = sensor.getsoc();
//	current = sensor.getcurrent();
//
//}
	
	public static FaultDetectionImpl getInstance() {
		return instance;
	}
	
@Override
public void CallFaultDetectiomSystem() {
	// TODO Auto-generated method stub
	print.printMessage("fd" );
}


}


	
	