package com.bms.test;


import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.controller.ThermalManagementControllerImpl;

public class ThermalManagementTest {

	@Test
	void testInvalidLowTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		Float tempertaure = -200.0f;
		sensor.setBatteryTemperature(tempertaure);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testInvalidLowTemperatureBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		Float tempertaure = -20.0f;
		sensor.setBatteryTemperature(tempertaure);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidHighTemperatureBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		Float tempertaure = 91.0f;
		sensor.setBatteryTemperature(tempertaure);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidHighTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		Float tempertaure = 200.0f;
		sensor.setBatteryTemperature(tempertaure);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureHeating() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(10.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureCooling() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(70.0f);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureNoChange() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		Float temperature = 30.0f;
		sensor.setBatteryTemperature(temperature);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is" + temperature);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
}
