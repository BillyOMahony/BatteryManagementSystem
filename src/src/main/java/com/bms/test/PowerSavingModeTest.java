package com.bms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.SensorControllerImpl;

class PowerSavingModeTest {

	@Test
	void test() {
		
		
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();

		// Start with 50% battery
		sensor.setStateOfCharge(0.5f);
		
		// Power saving mode off by default.
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();
		psm.CallPowerSavingSystem();
		
		float[] ExpectedOptimalTempRange = {30.f, 40.f};
		float[] IncorrectRangeExample = {1.f, 2.f};

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");
		
		// Toggles power saving mode, Optimal Temperature values should change
		psm.TogglePowerSavingMode();
		psm.CallPowerSavingSystem();
		
		ExpectedOptimalTempRange[0] = 20.f;
		ExpectedOptimalTempRange[1] = 30.f;

		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");
		
		// Set battery to 15%, which means power saving mode must be enabled
		sensor.setStateOfCharge(.15f);

		// Temp range should remain 20 - 30
		psm.CallPowerSavingSystem();
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");
		
		// Try to turn power saving mode off
		psm.TogglePowerSavingMode();
		
		// Temp range should remain 20 - 30
		psm.CallPowerSavingSystem();
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");
		
		// Set battery back to 50%
		sensor.setStateOfCharge(.5f);

		// Temp range should remain 20 - 30
		psm.CallPowerSavingSystem();
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");
		
		// Try to toggle power saving mode
		psm.TogglePowerSavingMode();

		// Temp range should now be 30 - 40
		psm.CallPowerSavingSystem();

		ExpectedOptimalTempRange[0] = 30.f;
		ExpectedOptimalTempRange[1] = 40.f;
		
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");

		// Set battery percentage to 15%
		sensor.setStateOfCharge(.15f);
		
		// Temp range should be 20 - 30
		psm.CallPowerSavingSystem();
		
		ExpectedOptimalTempRange[0] = 20.f;
		ExpectedOptimalTempRange[1] = 30.f;
		
		assertTrue(Arrays.equals(psm.GetOptimalTemperature(), ExpectedOptimalTempRange), "Arrays are not identical");

		
		
		
		
		
		

		
		
		// This one fails
		//assertTrue(Arrays.equals(InitialOptimalTempRange, IncorrectRangeExample), "Arrays are not identical");		
		
		//fail("Not yet implemented");
	}

}
