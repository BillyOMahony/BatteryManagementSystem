package com.bms.model;

public interface ThermalManagementModel {

	public boolean checkTemperature(float temperature);
	
	public boolean checkCoolentLeak(float velocity, float Pressure);
	
	public boolean Compare(float temperature, float[] optimalTemperature);
	
}
