package com.bms.controller;

public interface PowerSavingModeController {
	public void CallPowerSavingSystem();
	public float[] GetOptimalTemperature();
	public void TogglePowerSavingMode();
}
