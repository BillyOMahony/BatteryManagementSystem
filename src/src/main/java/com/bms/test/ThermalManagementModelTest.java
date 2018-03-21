package com.bms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.bms.model.ThermalManagementModelImpl;

public class ThermalManagementModelTest {
	
	@Test
	void testPath1() {
		
		ThermalManagementModelImpl model = ThermalManagementModelImpl.getInstance();
		float[] ExpectedOptimalTempRange = {20.f, 30.f};
		assertEquals("heat", model.checkForHeatingCooling(10.f, ExpectedOptimalTempRange));
	}
	
	@Test
	void testPath2() {
		
		ThermalManagementModelImpl model = ThermalManagementModelImpl.getInstance();
		float[] ExpectedOptimalTempRange = {30.f, 40.f};
		assertEquals("cool", model.checkForHeatingCooling(80.f, ExpectedOptimalTempRange));
	}
	
	@Test
	void testPath3() {
		
		ThermalManagementModelImpl model = ThermalManagementModelImpl.getInstance();
		float[] ExpectedOptimalTempRange = {30.f, 40.f};
		assertEquals("no change", model.checkForHeatingCooling(35.f, ExpectedOptimalTempRange));
	}

}
