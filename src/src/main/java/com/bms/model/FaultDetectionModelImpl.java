package com.bms.model;

import com.bms.view.PrintFaultDetection;

public class FaultDetectionModelImpl implements FaultDetectionModel {

	//Singleton
	private static final FaultDetectionModelImpl instance = new FaultDetectionModelImpl();
	String FDMessage = "";
	private PrintFaultDetection print;
	
	public FaultDetectionModelImpl() {
		// TODO Auto-generated constructor stub
		print = new PrintFaultDetection();
	}
	
	@Override
	public void CheckVelocity(float velocity) {
		FDMessage = "";
		if(velocity <= 15 &&velocity >=10.0) {
			FDMessage = "velocity is normal";
			
		}else{
			FDMessage = "velocity is unnormal ";
		}
		
		print.printMessage(FDMessage);
	}

	@Override
	 public void CheckCurrent(float current) {
	  
	  FDMessage = "";
	  if(current <= 0.4 || current >= 2) {
	   FDMessage = "current is unnormal";
	   
	  }else{
	   FDMessage = "current is normal ";
	  }
	  
	  print.printMessage(FDMessage);
	 }

	@Override
	public void CheckTeperature(float temperature) {
		FDMessage = "";
		if(temperature <= 90 && temperature >= 10 ) {
			FDMessage = "temperature is normal";
			
		}else{
			FDMessage = "temperature is unnormal ";
		}
		
		print.printMessage(FDMessage);
		
	}
	
	public static FaultDetectionModelImpl getInstance() {
		return instance;
	
	}
}
	




	
	