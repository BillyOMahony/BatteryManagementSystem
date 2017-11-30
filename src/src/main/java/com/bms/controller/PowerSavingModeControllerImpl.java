package com.bms.controller;

import com.bms.model.PowerSavingModeModelImpl;
import com.bms.view.PrintPowerSavingMode;

public class PowerSavingModeControllerImpl implements PowerSavingModeController{

	private float[] optimalTemperatureRange = new float[]{20.0f, 30.0f};;
	private boolean powerSavingEnabled = false;
	private float stateOfCharge = 0;
	private String PSMessage;
	private SensorControllerImpl sensor;
	private PrintPowerSavingMode print;
	private PowerSavingModeModelImpl model = PowerSavingModeModelImpl.getInstance();
	
	//Singleton
	private static final PowerSavingModeControllerImpl instance = new PowerSavingModeControllerImpl();
	
	private PowerSavingModeControllerImpl() {
		sensor = SensorControllerImpl.getInstance();
		print = new PrintPowerSavingMode();
	}
	
	@Override
	public void CallPowerSavingSystem() {
	
		// Get State of Charge
		stateOfCharge = sensor.getStateOfCharge();
		
		model.CheckPowerSavingStatus(powerSavingEnabled, stateOfCharge);
		model.SetOptimalTemperature(powerSavingEnabled);
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
