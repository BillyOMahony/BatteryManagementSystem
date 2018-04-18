package com.bms.controller;

public class DemoBatteryController {

	SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	
	// current speed
	// prev speed
	
	double currentSpeed = 0; // A value between 0 and 100
	double previousSpeed = 0;
	
	public void CallDemoBatteryController(double currentRunTime, double deltaTime) {
		currentRunTime -= 30; //Start speed at 0km/h
		currentSpeed = (Math.sin(currentRunTime * 0.05) * 50) + 50; // Make speed alternate between 0 and 100
		
		sensor.setDistanceTravelled(sensor.getDistanceTravelled() + (float)(currentSpeed * deltaTime));
		
		// Calculate changes to battery percentage based on speed increase.
		double speedDifference = currentSpeed - previousSpeed;
		if(speedDifference > 0) {
			// Accelerating
			
			// Battery Temp increasing
			
			// Battery Charge Decreasing
			sensor.setBatteryPercentage(sensor.getBatterPercentage() - (float)(speedDifference * deltaTime * .1));
		}
		else {
			// Breaking
			
			// Enable break charging.
			
			// Battery Temp cooling
		}
		
		//System.out.println(currentSpeed);
		previousSpeed = currentSpeed;
	}
	
}
