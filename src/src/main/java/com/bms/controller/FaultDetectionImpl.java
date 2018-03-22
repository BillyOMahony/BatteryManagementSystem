package com.bms.controller;

import com.bms.model.FaultDetectionModelImpl;

import com.bms.model.ChargingAndDischargingModel;

public class FaultDetectionImpl implements FaultDetection {
	private FaultDetectionModelImpl model;

	
	float temperature;
	float velocity;
	float current;
	
	private SensorControllerImpl sensor;
	


	private static final FaultDetectionImpl instance = new FaultDetectionImpl();

	private FaultDetectionImpl() {
		model = FaultDetectionModelImpl.getInstance();
		sensor = SensorControllerImpl.getInstance();
		
	}



	public static FaultDetectionImpl getInstance() {
		return instance;
	}

	@Override
	public void CallFaultDetectiomSystem() {
		
		velocity = sensor.getCoolantVelocity();
		current = sensor.getCoolantCurrent();
		temperature = sensor.getBatteryTemperature();


		model.CheckVelocity(velocity);
		model.CheckCurrent(current);
		model.CheckTeperature(temperature);
	}

}



