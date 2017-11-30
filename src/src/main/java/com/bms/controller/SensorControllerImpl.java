package com.bms.controller;

public class SensorControllerImpl implements SensorController{

	public SensorControllerImpl() {
		System.out.println("Sensor Created");
	}
	
	@Override
	public float getCoolantPressure() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	@Override
	public float getCoolantVelocity() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	@Override
	public float getBatteryTemperature() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	@Override
	public float getStateOfCharge() {
		// TODO Auto-generated method stub
		//StateOfCharge should be between 0 and 1. 
		//1 = 100%, 0 = 0%
		
		return 0.3f;
	}
	
}