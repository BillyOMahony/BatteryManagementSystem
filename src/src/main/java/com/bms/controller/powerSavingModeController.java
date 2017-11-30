package com.bms.controller;

public interface powerSavingModeController {
	public void CallPowerSavingSystem();
	public float[] GetOptimalTemperature();
	public void TogglePowerSavingMode();
}
