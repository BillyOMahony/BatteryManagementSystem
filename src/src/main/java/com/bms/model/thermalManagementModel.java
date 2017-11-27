package com.bms.model;

public interface thermalManagementModel {

	public boolean checkTemperature(Float temperature);
	
	public boolean checkCoolentLeak(Float velocity, Float Pressure);
	
	public void Compare(Float temperature, Float optimalTemperature);
	
}
