package com.bms.controller;

public class SensorControllerImpl implements SensorController {

	private static final SensorControllerImpl instance = new SensorControllerImpl();

	private SensorControllerImpl() {
		System.out.println("Sensor Created");
	}

	private boolean isCharging;

	private boolean isBreakChargingEnabled;

	public static SensorControllerImpl getInstance() {
		return instance;
	}

	@Override
	public float getCoolantPressure() {
		// TODO Auto-generated method stub
		return 0.0f;
	}

	@Override
	public float getCoolantVelocity() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public float getBatteryTemperature() {
		// TODO Auto-generated method stub
		return 50.0f;
	}

	@Override
	public float getStateOfCharge() {
		// TODO Auto-generated method stub
		// StateOfCharge should be between 0 and 1.
		// 1 = 100%, 0 = 0%

		return 0.3f;
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
		return 50;
	}

	@Override
	public float getCurrent() {
		// TODO Auto-generated method stub
		return 100;
	}
	public float getCoolantCurrent() {
		// TODO Auto-generated method stub
		return 0.2f;
	}

	@Override
	public float getDistanceTravelled() {
		// TODO Auto-generated method stub
		return 8008.5f;
	}
	
}