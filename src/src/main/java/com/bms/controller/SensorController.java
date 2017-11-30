package com.bms.controller;

public interface SensorController {

	public float getCoolantPressure();
	
	public float getCoolantVelocity();
	public float getCoolantCurrent();
	
	
	public float getBatteryTemperature();
	
	public float getStateOfCharge();
	
}
