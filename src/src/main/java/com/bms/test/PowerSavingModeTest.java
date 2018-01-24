package com.bms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;

class PowerSavingModeTest {

	@Test
	void test() {
		
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
				
		// This one fails
		//assertTrue(Arrays.equals(InitialOptimalTempRange, IncorrectRangeExample), "Arrays are not identical");		
		
		//fail("Not yet implemented");
	}

}
