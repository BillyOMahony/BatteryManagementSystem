package com.bms.controller;

public interface SensorController {

	public float getCoolantPressure();

	public float getCoolantVelocity();

	public float getBatteryTemperature();

	public float getStateOfCharge();

	/**
	 * sensor inputs for charging and discharging
	 */
	public boolean isBreakChargeEnabled();

	public float getBatterPercentage();

	public boolean isCharging();

	public float getDistanceTravelled();

	public float getVoltage();

	public float getCurrent();

}
