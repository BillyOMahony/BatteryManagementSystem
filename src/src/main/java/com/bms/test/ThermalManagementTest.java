package com.bms.test;


import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.controller.ThermalManagementControllerImpl;

public class ThermalManagementTest {

	@Test
	void testInvalidTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(-200.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();		
	}
	
	@Test
	void testInvalidTemperature2() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(200.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();		
	}
	
	@Test
	void testValidTemperatureHeating() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(10.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();		
	}
	
	@Test
	void testValidTemperatureCooling() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(70.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();		
	}
	
	@Test
	void testValidTemperatureNoChange() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(30.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();		
	}
}
