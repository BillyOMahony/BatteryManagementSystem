package com.btm.fd.dao;

public interface FaultDetectionDao {
	
	public float getFault();
	
	public float getSensorData();
	
	public void saveFault();
//	public void CompareTemerature(Float temperature, Float optimalTemperature);
//	public void Compare(Float temperature, Float optimalTemperature);
//	public void CompareVelocity(Float velocity, Float optimalvelocity);
//	public void Comparecurrent(Float current, Float optimalCurrent);
//
//	public void CompareSOC(Float soc, Float optimalsoc);
//	
}
