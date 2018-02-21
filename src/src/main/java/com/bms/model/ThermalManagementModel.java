package com.bms.model;

public interface ThermalManagementModel {

	public boolean checkTemperature(float temperature);
	
	public boolean Compare(float temperature, float[] optimalTemperature, float pressure);

	public boolean checkCoolentLeak(float pressure);
	
}
