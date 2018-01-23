package com.bms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;

class PowerSavingModeTest {

	@Test
	void test() {
		
		PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();
		
		float[] InitialOptimalTempRange = psm.GetOptimalTemperature();
		float[] ExpectedOptimalTempRange = {20.f, 30.f};
		float[] IncorrectRangeExample = {1.f, 2.f};
		
		assertTrue(Arrays.equals(InitialOptimalTempRange, ExpectedOptimalTempRange), "Arrays are not identical");
		
		// This one fails
		//assertTrue(Arrays.equals(InitialOptimalTempRange, IncorrectRangeExample), "Arrays are not identical");		
		
		//fail("Not yet implemented");
	}

}
