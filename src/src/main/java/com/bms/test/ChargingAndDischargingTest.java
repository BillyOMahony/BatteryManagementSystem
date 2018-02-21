package com.bms.test;

import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.model.ChargingAndDischargingModelImpl;

public class ChargingAndDischargingTest {
	private SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	private ChargingAndDischargingModelImpl chargeDischargeImp = ChargingAndDischargingModelImpl.getInstance();

	/*
	 * Checks the status when charger is plugged in and battery is fully charged
	 */
	@Test
	void testCheckBatteryChargeStateHigh() {

		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(100);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());

		// assertTrue(Arrays.equals(chargeDischargeImp.GetOptimalTemperature(),
		// ExpectedOptimalTempRange), "Arrays are not identical");
	}
	/*
	 * Checks the status when charger is un plugged and battery is fully charged
	 */
	@Test
	void testCheckBatteryDischargehargeStateHigh() {

		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(100);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());

		// assertTrue(Arrays.equals(chargeDischargeImp.GetOptimalTemperature(),
		// ExpectedOptimalTempRange), "Arrays are not identical");
	}
	/*
	 * Checks for low battery percentage should display the battery percentage
	 */
	@Test
	void testBatteryChargeStateLow() {

		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(1);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for low battery percentage and charger is not plugged in should alert
	 * the user to charge the battery
	 */
	@Test
	void testBatteryDischargeState() {

		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(1);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for high battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testBatteryChargeInValidState() {

		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(105);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for high battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testBatteryDischargeInValidState() {

		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(105);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for high battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testSensorChargeInValidState() {

		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(-1);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
	
	/*
	 * Checks for low battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testSensorInDischargeSensorState() {

		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(-1);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
	
	//Control flow test cases
	@Test
	void testChargingDischargingPathOne() {
		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(4);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
	@Test
	void testChargingDischargingPathTwo() {
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(0);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
	@Test
	void testChargingDischargingPathThree() {
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(100);
		chargeDischargeImp.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
}