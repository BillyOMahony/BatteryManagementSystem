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
		powerSavingEnabled = model.CheckPowerSavingStatus(isPowerSavingEnabled(), stateOfCharge);
		optimalTemperatureRange = model.SetOptimalTemperature(isPowerSavingEnabled());
	}

	@Override
	public float[] GetOptimalTemperature() {
		return optimalTemperatureRange;
	}

	@Override
	public void TogglePowerSavingMode() {
		setPowerSavingEnabled(!isPowerSavingEnabled());
		if(stateOfCharge <= 0.2f) {
			setPowerSavingEnabled(true);
		}
		
		print.printMessage("Power Saving Mode is " + isPowerSavingEnabled());
	}

	public static PowerSavingModeControllerImpl getInstance() {
		return instance;
	}

	public boolean isPowerSavingEnabled() {
		return powerSavingEnabled;
	}

	public void setPowerSavingEnabled(boolean powerSavingEnabled) {
		this.powerSavingEnabled = powerSavingEnabled;
	}
	
}
