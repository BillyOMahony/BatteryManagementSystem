package com.bms.controller;

import com.bms.view.PrintPowerSavingMode;

public class PowerSavingModeControllerImpl implements PowerSavingModeController{

	private float[] optimalTemperatureRange;
	private boolean powerSavingEnabled = false;
	private float stateOfCharge = 0;
	private String PSMessage;
	private SensorControllerImpl sensor;
	private PrintPowerSavingMode print;
	
	//Singleton
	private static final PowerSavingModeControllerImpl instance = new PowerSavingModeControllerImpl();
	
	private PowerSavingModeControllerImpl() {
		sensor = new SensorControllerImpl();
		print = new PrintPowerSavingMode();
	}
	
	@Override
	public void CallPowerSavingSystem() {
	
		// Get State of Charge
		stateOfCharge = sensor.getStateOfCharge();
		
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
		
		print.printMessage(PSMessage);
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
		
		String temp = "Optimal Temperature Range: " + optimalTemperatureRange[0] + " -> " +optimalTemperatureRange[1];
		print.printMessage(temp);
	}

	@Override
	public float[] GetOptimalTemperature() {
		return optimalTemperatureRange;
	}

	@Override
	public void TogglePowerSavingMode() {
		powerSavingEnabled = !powerSavingEnabled;
		if(stateOfCharge >= 0.2f) {
			powerSavingEnabled = true;
		}
		
		print.printMessage("Power Saving Mode is " + powerSavingEnabled);
	}

	public static PowerSavingModeControllerImpl getInstance() {
		return instance;
	}
	
}
