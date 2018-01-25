package com.bms.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.ThermalManagementControllerImpl;

public class ThermalManagementTest {

	@Test
	void test() {
		
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		controllerImpl.callThermalManagementSystem();		
		float[] ExpectedOptimalTempRange = {30.f, 40.f};
		float[] IncorrectRangeExample = {1.f, 2.f};

		
	}
}
