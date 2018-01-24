package com.bms.controller;

public interface SensorController {

	public float getCoolantPressure();

	public void setCoolantPressure(float newCoolantPressure);

	public float getCoolantVelocity();

	public float getCoolantCurrent();

	public void setCoolantCurrent(float newCoolantCurrent);

	public void setCoolantVelocity(float newCoolantVelocity);

	public void setBatteryPercentage(float batteryPercentage);

	public float getBatteryTemperature();

	public void setBatteryTemperature(float newBatteryTemperature);

	public float getStateOfCharge();

	public void setStateOfCharge(float newStateOfCharge);

	/**
	 * sensor inputs for charging and discharging
	 */
	public boolean isBreakChargeEnabled();

	public float getBatterPercentage();

	public boolean isCharging();

	public float getDistanceTravelled();

	public void setDistanceTravelled(float newDistanceTravelled);

	public float getVoltage();

	public void setVolage(float newVoltage);

	public float getCurrent();

	public void setCurrent(float newCurrent);

}
