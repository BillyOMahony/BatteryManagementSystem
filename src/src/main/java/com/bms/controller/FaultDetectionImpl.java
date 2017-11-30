package com.bms.controller;

import com.bms.view.PrintFaultDetection;

public class FaultDetectionImpl implements FaultDetection {
	private String FDMessage;
	float temperature;
	float velocity;
	float current;
	float soc;
	private SensorControllerImpl sensor;
	private PrintFaultDetection print;


	private static final FaultDetectionImpl instance = new FaultDetectionImpl();
	
	private FaultDetectionImpl() {
		sensor = SensorControllerImpl.getInstance();
		print = new PrintFaultDetection();
	}
	

	
	public static FaultDetectionImpl getInstance() {
		return instance;
	}
	
@Override
public void CallFaultDetectiomSystem() {
	// TODO Auto-generated method stub
	velocity = sensor.getCoolantVelocity();
	current = sensor.getCoolantCurrent();
	temperature = sensor.getBatteryTemperature();
	
	
	CheckVelocity();
	CheckCurrent();
	CheckTeperature();
}

public void CheckVelocity() {
	FDMessage = "";
	if(velocity <= 12.8 &&velocity >=12.0) {
		FDMessage = "velocity is normal";
		
	}else{
		FDMessage = "velocity is innormal ";
	}
	
	print.printMessage(FDMessage);
}
public void CheckCurrent() {
	FDMessage = "";
	if(current <= 0.4 ) {
		FDMessage = "current is normal";
		
	}else{
		FDMessage = "current is innormal ";
	}
	
	print.printMessage(FDMessage);
}
public void CheckTeperature() {
	FDMessage = "";
	if(temperature <= 75 && temperature >=20 ) {
		FDMessage = "temperature is normal";
		
	}else{
		FDMessage = "temperature is innormal ";
	}
	
	print.printMessage(FDMessage);
}

}


	
	