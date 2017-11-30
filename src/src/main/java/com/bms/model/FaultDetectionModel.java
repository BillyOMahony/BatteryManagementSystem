package com.bms.model;

public interface FaultDetectionModel {
	
public void CheckVelocity(float velocity);
	
	public void CheckCurrent(float current);
	
	public void CheckTeperature(float temperature);
}
