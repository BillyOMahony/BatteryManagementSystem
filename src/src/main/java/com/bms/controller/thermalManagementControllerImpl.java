package com.bms.controller;
//Controller class

import com.bms.model.thermalManagementModel;
import com.bms.view.printThermalManagement;

public class thermalManagementControllerImpl implements thermalManagementController{

	private thermalManagementModel model;
	private printThermalManagement view;
	private sensorControllerImpl sensor;
	private float temperature;
	private float velocity;
	private float pressure;
	private float optimalTemp;
	boolean leakageFlag, tempFlag;

	public thermalManagementControllerImpl(thermalManagementModel model, printThermalManagement view){
		this.model = model;
		this.view = view;
	}

	@Override
	public void callThermalManagementSystem() {
		// TODO Auto-generated method stub
		temperature = sensor.getBatteryTemperature();
		velocity = sensor.getCoolantVelocity();
		pressure = sensor.getCoolantPressure();
		
		leakageFlag = model.checkCoolentLeak(velocity, pressure);
		tempFlag = model.checkTemperature(temperature);
		model.Compare(temperature, optimalTemp);
	}

	public void updateView(){				
		view.DisplayThermalManagementMessage();
	}

}
