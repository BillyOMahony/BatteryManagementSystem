package com.bms.model;

public interface PowerSavingModeModel {

	public void CheckPowerSavingStatus(boolean powerSavingEnabled, float stateOfCharge);
	public float[] SetOptimalTemperature(boolean powerSavingEnabled);
	
}
