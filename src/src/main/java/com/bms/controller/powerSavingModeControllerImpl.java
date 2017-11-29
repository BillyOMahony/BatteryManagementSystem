package com.bms.controller;

public class powerSavingModeControllerImpl implements powerSavingModeController{

	private float[] optimalTemperatureRange = null;
	private boolean powerSavingEnabled = false;
	private float stateOfCharge = 0;
	private String PSMessage;
	private sensorControllerImpl sensor;
	
	@Override
	public void CallPowerSavingSystem() {
	
		// Get State of Charge
		stateOfCharge = sensor.getStateOfCharge();
					
	}

	private void CheckPowerSavingStatus(boolean powerSavingEnabled, float stateOfCharge) {
		PSMessage = "";
		if(powerSavingEnabled || stateOfCharge < .2f) {
			PSMessage = "Power Saving Mode Enabled";
		}else{
			PSMessage = "Power Saving Mode Disabled";
		}
		
		
	}

	private void SetOptimalTemperature() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GetOptimalTemperature() {
		// TODO Auto-generated method stub
		
	}
	
}
