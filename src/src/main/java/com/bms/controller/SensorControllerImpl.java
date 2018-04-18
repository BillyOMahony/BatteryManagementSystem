package com.bms.controller;

import java.util.Random;

public class SensorControllerImpl implements SensorController {

	volatile float coolantPressure = 101000.0f;
	volatile float coolantVelocity = 0.0f;
	volatile float batteryTemperature = 50.f;
	volatile float stateOfCharge = 0.5f;
	volatile float voltage = 0.f;
	volatile float current = 0.f;
	volatile float coolantCurrent = 0.f;
	volatile float distanceTravelled = 0f;
	volatile float batteryPercentage = 1f;

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

		return coolantPressure;
	}

	@Override
	public float getCoolantVelocity() {

		return coolantVelocity;
	}

	@Override
	public float getBatteryTemperature() {

		return batteryTemperature;
	}

	@Override
	public float getStateOfCharge() {
		// StateOfCharge should be between 0 and 1.
		// 1 = 100%, 0 = 0%

		return stateOfCharge;
	}

	@Override
	public boolean isBreakChargeEnabled() {

		return isBreakChargingEnabled;
	}

	@Override
	public float getBatterPercentage() {

		return batteryPercentage;
	}

	@Override
	public boolean isCharging() {

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

		return voltage;
	}

	@Override
	public float getCurrent() {

		return current;
	}
	@Override
	public float getCoolantCurrent() {

		return coolantCurrent;
	}
	
	@Override
	public void setCoolantCurrent(float newCoolantCurrent) {

		coolantCurrent = newCoolantCurrent;
	}
	@Override
	public float getDistanceTravelled() {

		return distanceTravelled;
	}

	@Override
	public void setCoolantPressure(float newCoolantPressure) {

		coolantPressure = newCoolantPressure;
	}

	@Override
	public void setCoolantVelocity(float newCoolantVelocity) {

		coolantVelocity = newCoolantVelocity;
	}

	@Override
	public void setBatteryTemperature(float newBatteryTemperature) {

		batteryTemperature = newBatteryTemperature;
	}

	@Override
	public void setStateOfCharge(float newStateOfCharge) {

		stateOfCharge = newStateOfCharge;
	}

	@Override
	public void setDistanceTravelled(float newDistanceTravelled) {

		distanceTravelled = newDistanceTravelled;
	}

	@Override
	public void setVolage(float newVoltage) {

		voltage = newVoltage;
	}

	@Override
	public void setCurrent(float newCurrent) {

		current = newCurrent;
	}

	@Override
	public void setBatteryPercentage(float batteryPercentage) {

		this.batteryPercentage = batteryPercentage;
	}

	public float generateRandomNumbers(float min, float max) {
		Random r = new Random();
		float random = min + r.nextFloat() * (max - min);
		return random;
	}
	public double generateRandomDoubleNumbers(double min, double max) {
		Random r = new Random();
		double random = min + r.nextDouble() * (max - min);
		return random;
	}
	public void setRandomValues() {
		setCoolantPressure(generateRandomNumbers(100000.0f, 101000.9f));
		setCoolantVelocity(generateRandomNumbers(0.0f, 99.9f));
		setBatteryTemperature(generateRandomNumbers(0.0f, 100.0f));
		setStateOfCharge(generateRandomNumbers(0.0f, 99.9f));
		setVolage(generateRandomNumbers(0.0f, 99.9f));
		setCurrent(generateRandomNumbers(0.0f, 99.9f));
		setCoolantCurrent(generateRandomNumbers(0.0f, 99.9f));
		setDistanceTravelled(generateRandomNumbers(0.0f, 99999.9f));
		setBatteryPercentage(generateRandomNumbers(0.0f, 100.0f));
	}
}