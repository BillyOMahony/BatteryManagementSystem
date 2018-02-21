package com.bms.model;

public class ThermalManagementModelImpl implements ThermalManagementModel{

	//Singleton
	private static final ThermalManagementModelImpl instance = new ThermalManagementModelImpl();
		
	private double velocity;
	private float coolantTemp;
	
	@Override
	public boolean checkTemperature(float temperature) {
		// TODO Auto-generated method stub
		if(temperature > 90.0f || temperature < -18.0f) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkCoolentLeak(float velocity, float pressure) {
		// TODO Auto-generated method stub
		if(pressure > 100000 && pressure < 101325 )
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean Compare(float temperature, float[] optimalTemperature) {
		boolean faultFlag = false;
		
		faultFlag = checkTemperature(temperature);
		if(faultFlag == false) {
			checkForHeatingCooling(temperature, optimalTemperature);
			return faultFlag;
		}else
		{
			return faultFlag;
		}		
	}
	
	public String checkForHeatingCooling(float temperature, float[] optimalTemperature) {
		String result = "no change";
		if(temperature < optimalTemperature[0]) {
			result = heatingMechanism(temperature);
		}
		if(temperature > optimalTemperature[1]) {
			result = coolingMechanism(temperature);
		}
		if(temperature < optimalTemperature[1] && temperature >= optimalTemperature[0]) {
			System.out.println("Thermal Management System: Temperature is in the optimal range");
		}
		return result;
	}
	
	public String coolingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Cooling the battery");
		velocity = 0.01;
		coolantTemp = 20;
		return "cool";
	}
	
	public String heatingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Heating the battery");
		velocity = 0.01;
		return "heat";
	}
	
	public static ThermalManagementModelImpl getInstance() {
		return instance;
	}
	
}