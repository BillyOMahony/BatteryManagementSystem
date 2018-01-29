package com.bms.model;

import com.bms.view.PrintPowerSavingMode;

public class PowerSavingModeModelImpl implements PowerSavingModeModel{
	
	PrintPowerSavingMode print;
	
	private static final PowerSavingModeModelImpl instance = new PowerSavingModeModelImpl();
	
	private PowerSavingModeModelImpl() {
		print = new PrintPowerSavingMode();
	}
	
	String PSMessage;
	
	@Override
	public boolean CheckPowerSavingStatus(boolean powerSavingEnabled, float stateOfCharge) {
		PSMessage = "";
		boolean powerSavingModeEnabled;
		
		System.out.println("\nSoC = " + stateOfCharge + " PSE = " + powerSavingEnabled);
		
		if(powerSavingEnabled || stateOfCharge <= .2f) {
			PSMessage = "Power Saving Mode Enabled";
			powerSavingModeEnabled = true;
		}else{
			PSMessage = "Power Saving Mode Disabled";
			powerSavingModeEnabled = false;
		}
		
		print.printMessage(PSMessage);
		return powerSavingModeEnabled;
	}
	
	@Override
	public float[] SetOptimalTemperature(boolean powerSavingEnabled) {
		float[] optimalTemperatureRange;
		if(powerSavingEnabled) {
			optimalTemperatureRange = new float[]{20.0f, 30.0f};
		}else {
			optimalTemperatureRange = new float[] {30.0f, 40.0f};
		}
		
		String temp = "Optimal Temperature Range: " + optimalTemperatureRange[0] + " -> " +optimalTemperatureRange[1];
		print.printMessage(temp);
		
		return optimalTemperatureRange;
	}

	
	public static PowerSavingModeModelImpl getInstance() {
		return instance;
	}
}
