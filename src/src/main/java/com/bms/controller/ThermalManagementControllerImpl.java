package com.bms.controller;
//Controller class

import com.bms.model.ThermalManagementModel;
import com.bms.view.PrintThermalManagement;

public class ThermalManagementControllerImpl implements ThermalManagementController{

	private ThermalManagementModel model;
	private PrintThermalManagement view;
	private SensorControllerImpl sensor;
	private float temperature;
	private float velocity;
	private float pressure;
	private float optimalTemp;
	boolean leakageFlag, tempFlag;

	public ThermalManagementControllerImpl(ThermalManagementModel model, PrintThermalManagement view){
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
