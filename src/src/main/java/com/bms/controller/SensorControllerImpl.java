package com.bms.controller;

public class SensorControllerImpl implements SensorController {

	float CoolantPressure = 0.0f;
	float CoolantVelocity = 0.0f;
	float BatteryTemperature = 50.f;
	float StateOfCharge = 0.5f;
	float Voltage = 0.f;
	float Current = 0.f;
	float CoolantCurrent = 0.f;
	float DistanceTravelled = 8008.5f;
	
	
	private static final SensorControllerImpl instance = new SensorControllerImpl();

	private SensorControllerImpl() {
		System.out.println("Sensor Created");
	}

	private boolean isCharging = false;

	private boolean isBreakChargingEnabled = false;

	public static SensorControllerImpl getInstance() {
		return instance;
	}

	@Override
	public float getCoolantPressure() {
		// TODO Auto-generated method stub
		return CoolantPressure;
	}

	@Override
	public float getCoolantVelocity() {
		// TODO Auto-generated method stub
		return CoolantVelocity;
	}

	@Override
	public float getBatteryTemperature() {
		// TODO Auto-generated method stub
		return BatteryTemperature;
	}

	@Override
	public float getStateOfCharge() {
		// TODO Auto-generated method stub
		// StateOfCharge should be between 0 and 1.
		// 1 = 100%, 0 = 0%

		return StateOfCharge;
	}

	@Override
	public boolean isBreakChargeEnabled() {
		// TODO Auto-generated method stub
		return isBreakChargingEnabled;
	}

	@Override
	public float getBatterPercentage() {
		// TODO Auto-generated method stub
		return 0.5f;
	}

	@Override
	public boolean isCharging() {
		// TODO Auto-generated method stub
		return isCharging;
	}

	public void setIsCharging(boolean isChargingEnabled) {
		isCharging = isChargingEnabled;
	}

	public void setIsBreakCharging(boolean isBreakChargingEnabled) {
		this.isBreakChargingEnabled = isBreakChargingEnabled;
	}

	@Override
	public float getVoltage() {
		// TODO Auto-generated method stub
		return Voltage;
	}

	@Override
	public float getCurrent() {
		// TODO Auto-generated method stub
		return Current;
	}
	public float getCoolantCurrent() {
		// TODO Auto-generated method stub
		return CoolantCurrent;
	}

	@Override
	public float getDistanceTravelled() {
		// TODO Auto-generated method stub
		return DistanceTravelled;
	}

	@Override
	public void setCoolantPressure(float newCoolantPressure) {
		// TODO Auto-generated method stub
		CoolantPressure = newCoolantPressure;
	}

	@Override
	public void setCoolantVelocity(float newCoolantVelocity) {
		// TODO Auto-generated method stub
		CoolantVelocity = newCoolantVelocity;
	}

	@Override
	public void setBatteryTemperature(float newBatteryTemperature) {
		// TODO Auto-generated method stub
		BatteryTemperature = newBatteryTemperature;
	}

	@Override
	public void setStateOfCharge(float newStateOfCharge) {
		// TODO Auto-generated method stub
		StateOfCharge = newStateOfCharge;
	}

	@Override
	public void setDistanceTravelled(float newDistanceTravelled) {
		// TODO Auto-generated method stub
		DistanceTravelled = newDistanceTravelled;
	}

	@Override
	public void setVolage(float newVoltage) {
		// TODO Auto-generated method stub
		Voltage = newVoltage;
	}

	@Override
	public void setCurrent(float newCurrent) {
		// TODO Auto-generated method stub
		Current = newCurrent;
	}
	
}