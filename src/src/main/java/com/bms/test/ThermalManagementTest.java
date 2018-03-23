package com.bms.test;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.controller.ThermalManagementControllerImpl;

public class ThermalManagementTest {

	Random rng = new Random();

	/*
	 * Randomised test
	 */
	@Test
	void testRandomTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		
		float max = 90.0f;
		float min = -18.0f;
		float temperature = min + rng.nextFloat() * (max - min);
		
		float maxP = 101325.0f;
		float minP = 100000.0f;
		float pressure = minP + rng.nextFloat() * (maxP - minP);
		
		sensor.setBatteryTemperature(temperature);
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Random Temperature is " +temperature);
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	
	
	/*
	 * test case where temperature is lower than the minimum valid temperature range
	 */
	@Test
	void testInvalidLowTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = -200.0f;
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		sensor.setBatteryTemperature(tempertaure);		
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testInvalidLowTemperature2() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = -20.0f;
		sensor.setBatteryTemperature(tempertaure);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidLowTemperatureBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = -19.0f;
		sensor.setBatteryTemperature(tempertaure);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testValidHighTemperatureBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = 90.0f;
		sensor.setBatteryTemperature(tempertaure);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidHighTemperatureBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = 91.0f;
		sensor.setBatteryTemperature(tempertaure);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidCoolantPressure() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = 87.0f;
		float pressure = 101326.0f;
		sensor.setBatteryTemperature(tempertaure);
		sensor.setCoolantPressure(pressure);
		// Power saving mode off by default.
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	@Test
	void testInvalidHighTemperature() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float tempertaure = 200.0f;
		sensor.setBatteryTemperature(tempertaure);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is " +tempertaure);
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureHeating() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(10.0f);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureHeatingBoundary() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(-18.0f);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();
		System.out.println("\n");
	}
	
	@Test
	void testValidTemperatureCooling() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		sensor.setBatteryTemperature(70.0f);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
	
	
	@Test
	void testValidTemperatureNoChange() {
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		float temperature = 30.0f;
		sensor.setBatteryTemperature(temperature);
		float pressure = 100023.0f;
		sensor.setCoolantPressure(pressure);
		ThermalManagementControllerImpl controllerImpl = ThermalManagementControllerImpl.getInstance();
		System.out.println("Temperature is" + temperature);
		controllerImpl.callThermalManagementSystem();	
		System.out.println("\n");
	}
}
