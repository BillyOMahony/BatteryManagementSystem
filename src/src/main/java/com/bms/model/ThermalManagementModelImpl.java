package com.bms.model;

public class ThermalManagementModelImpl implements ThermalManagementModel{

	//Singleton
	private static final ThermalManagementModelImpl instance = new ThermalManagementModelImpl();
		
	private double velocity;
	private float coolantTemp;
	
	@Override
	public boolean checkTemperature(float temperature) {
		
		if(temperature > 90.0f || temperature < -18.0f) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkCoolentLeak(float pressure) {

		if(pressure > 100000 && pressure < 101325 )
		{
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean Compare(float temperature, float[] optimalTemperature, float pressure) {
		boolean faultFlag1, faultFlag2 = false;
		
		faultFlag1 = checkTemperature(temperature);
		faultFlag2 = checkCoolentLeak(pressure);
		if(faultFlag1 == false && faultFlag2 == false) {
			checkForHeatingCooling(temperature, optimalTemperature);
			return false;
		}
		else
		{
			return true;
		}		
	}
	
	public String checkForHeatingCooling(float temperature, float[] optimalTemperature) {
		String result = "no change";
		if(temperature < optimalTemperature[0]) {
			result = heatingMechanism(temperature);
		}
		else if(temperature > optimalTemperature[1]) {
			result = coolingMechanism(temperature);
		}
		else if(temperature < optimalTemperature[1] && temperature >= optimalTemperature[0]) {
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