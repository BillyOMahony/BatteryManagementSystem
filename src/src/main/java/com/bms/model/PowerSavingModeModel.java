package com.bms.model;

public interface PowerSavingModeModel {

	public boolean CheckPowerSavingStatus(boolean powerSavingEnabled, float stateOfCharge);
	public float[] SetOptimalTemperature(boolean powerSavingEnabled);
	
}
