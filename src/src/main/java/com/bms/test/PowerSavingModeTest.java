package com.bms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.SensorControllerImpl;

class PowerSavingModeTest {
	
	/*
	 * Checks that if power saving mode is on, then toggled off, and battery percentage is over 20%
	 * then Optimal Temp Range is 30 - 40
	 */
	@Test
	void testPSMOnOffBatteryOverTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.25f);
		psm.setPowerSavingEnabled(true);
		psm.TogglePowerSavingMode();
		psm.CallPowerSavingSystem();
				
		float[] ExpectedOptimalTempRange = {30.f, 40.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	
	/*
	 * Checks that if power saving mode is off, and battery percentage is over 20%
	 * then Optimal Temp Range is 30 - 40
	 */
	@Test
	void testPSMOffBatteryOverTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.25f);
		psm.setPowerSavingEnabled(false);
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {30.f, 40.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	/*
	 * Checks that if power saving mode is on, and battery percentage is over 20%
	 * then Optimal Temp Range is 20 - 30
	 */
	@Test
	void testPSMOnBatteryOverTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.25f);
		psm.setPowerSavingEnabled(true);
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	/*
	 * Checks that if power saving mode is off, and battery percentage is under 20%
	 * then Optimal Temp Range is 20 - 30
	 */
	@Test
	void testPSMOffBatteryUnderTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.15f);
		psm.setPowerSavingEnabled(false);
		psm.CallPowerSavingSystem();
		
		System.out.println(psm.GetOptimalTemperature()[0] + ", " +psm.GetOptimalTemperature()[1] + ", " + psm.getPowerSavingMode());
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};
		
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	/*
	 * Checks that if power saving mode is on, and battery percentage is under 20%
	 * then Optimal Temp Range is 20 - 30
	 */
	@Test
	void testPSMOnBatteryUnderTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.15f);
		psm.setPowerSavingEnabled(true);
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	/*
	 * Checks that if power saving mode is off, then toggled on, and battery percentage is over 20%
	 * then Optimal Temp Range is 20 - 30
	 */
	@Test
	void testPSMOffOnBatteryOverTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.25f);
		psm.setPowerSavingEnabled(false);
		psm.TogglePowerSavingMode();
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	

	/*
	 * Checks that if power saving mode is off, then toggled on, and battery percentage is under 20%
	 * then Optimal Temp Range is 20 - 30
	 */
	@Test
	void testPSMOffOnBatteryUnderTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.15f);
		psm.setPowerSavingEnabled(false);
		psm.TogglePowerSavingMode();
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
	
	/*
	 * Checks that if power saving mode is on, then toggled off, and battery percentage is under 20%
	 * then Optimal Temp Range is 20 - 30
	 * and PowerSavingMode is false
	 */
	@Test
	void testPSMOnOffBatteryUnderTwenty() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();

		sensor.setStateOfCharge(.15f);
		psm.setPowerSavingEnabled(true);
		psm.TogglePowerSavingMode();
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {20.f, 30.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");		
	}
}
