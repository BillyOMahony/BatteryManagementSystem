package com.bms.controller;

public class powerSavingModeControllerImpl implements powerSavingModeController{

	private float[] optimalTemperatureRange;
	private boolean powerSavingEnabled;
	private float stateOfCharge = 0;
	private String PSMessage;
	private sensorControllerImpl sensor;
	
	@Override
	public void CallPowerSavingSystem() {
	
		// Get State of Charge
		stateOfCharge = sensor.getStateOfCharge();
		
		// HCI.getPowerSavingTEnabled();
		// powerSavingEnabled = HCI.getPowerSavingTEnabled();
		powerSavingEnabled = false;
		
		CheckPowerSavingStatus(powerSavingEnabled, stateOfCharge);
	}

	/*
	 * 
	 */
	private void CheckPowerSavingStatus(boolean powerSavingEnabled, float stateOfCharge) {
		PSMessage = "";
		if(powerSavingEnabled || stateOfCharge <= .2f) {
			PSMessage = "Power Saving Mode Enabled";
			
		}else{
			PSMessage = "Power Saving Mode Disabled";
		}
		
		SetOptimalTemperature();
		
	}
	
	/*
	 * 
	 */
	private void SetOptimalTemperature() {
		if(powerSavingEnabled) {
			optimalTemperatureRange = new float[]{20.0f, 30.0f};
		}else {
			optimalTemperatureRange = new float[] {30.0f, 40.0f};
		}
	}

	@Override
	public float[] GetOptimalTemperature() {	
		return optimalTemperatureRange;
	}
	
}
