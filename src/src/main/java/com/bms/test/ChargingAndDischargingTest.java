package com.bms.test;

import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.model.ChargingAndDischargingModelImpl;

public class ChargingAndDischargingTest {
	private SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	private ChargingAndDischargingModelImpl psm = ChargingAndDischargingModelImpl.getInstance();

	/*
	 * Checks the status when charger is plugged in and battery is fully charged
	 */
	@Test
	void testCheckBatteryChargeStateHigh() {
		
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(100);
		psm.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());

		// assertTrue(Arrays.equals(psm.GetOptimalTemperature(),
		// ExpectedOptimalTempRange), "Arrays are not identical");
	}

	/*
	 * Checks for low battery percentage
	 * should display the battery percentage
	 */
	@Test
	void testBatteryChargeStateLow() {
		
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(1);
		psm.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for low battery percentage and charger is not plugged in
	 *  should alert the user to charge the battery
	 */
	@Test
	void testBatteryDischargeState() {
		
		sensor.setIsCharging(false);
		sensor.setBatteryPercentage(1);
		psm.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}

	/*
	 * Checks for high battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testBatteryDischargingInValidState() {
		
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(105);
		psm.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
	
	/*
	 * Checks for high battery percentage (when sensor input is erroneous)
	 */
	@Test
	void testSensorInValidState() {
		
		sensor.setIsCharging(true);
		sensor.setBatteryPercentage(-1);
		psm.checkBatteryLevel(sensor.getBatterPercentage(), sensor.isCharging());
	}
}
