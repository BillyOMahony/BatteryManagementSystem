package com.bms.controller;

import com.bms.model.ThermalManagementModelImpl;

public class DemoBatteryController {

	SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	ThermalManagementModelImpl thermalMgmt = ThermalManagementModelImpl.getInstance();
	// current speed
	// prev speed
	
	double speedMultiplier = 1; // can be changed to 0 to stop the car essentially
	
	double currentSpeed = 0; // A value between 0 and 100
	double previousSpeed = 0;
	
	public void CallDemoBatteryController(double currentRunTime, double deltaTime) {
		currentRunTime -= 15; //Start speed at 0km/h
		currentSpeed = (Math.sin(currentRunTime * 0.1) * 50) + 50; // Make speed alternate between 0 and 100
		currentSpeed *= speedMultiplier;
		
		// Set distance traveled since last loop
		
		// km/h to m/s
		float ms = (float) (currentSpeed * 1000) / 3600;
		//System.out.println("Distance Travelled Bat " + sensor.getDistanceTravelled());
		float dstTravThisLoop = ms * (float)deltaTime;
		
		
		sensor.setDistanceTravelled(sensor.getDistanceTravelled() + dstTravThisLoop);
				
		// Calculate changes to battery percentage based on speed increase.
		double speedDifference = currentSpeed - previousSpeed;
		if(speedDifference > 0) {
			
			// Battery Temp increasing
			sensor.setBatteryTemperature(sensor.getBatteryTemperature() + (float)(speedDifference * deltaTime * 0.1));
			
			// Battery Charge Decreasing
			sensor.setBatteryPercentage(sensor.getBatterPercentage() - (float)(speedDifference * deltaTime * .01));
		}
		else {			
			// Break Charging charges battery a small amount
			sensor.setBatteryPercentage(sensor.getBatterPercentage() + (float)(speedDifference * deltaTime * .000001));
			
			// Enable break charging.
			
			
			// Battery Temp cooling
			sensor.setBatteryTemperature(sensor.getBatteryTemperature() - (float)(speedDifference * deltaTime  * 0.002));
		}
		
		
		// Thermal Management
		String tm = thermalMgmt.getControl();
		if(tm.equals("heat")){
			sensor.setBatteryTemperature(sensor.getBatteryTemperature() + 0.1f);
		}else if(tm.equals("cool")){
			sensor.setBatteryTemperature(sensor.getBatteryTemperature() - 0.1f);
		}
		
		if(sensor.getBatterPercentage() < 0){
			sensor.setBatteryPercentage(0.f);
			speedMultiplier = 0;
			previousSpeed = 0;
		}
		
		previousSpeed = currentSpeed;
	}
	
}
