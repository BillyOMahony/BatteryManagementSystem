package com.bms.model;

public class ThermalManagementModelImpl implements ThermalManagementModel{

	//Singleton
	private static final ThermalManagementModelImpl instance = new ThermalManagementModelImpl();
		
	
	@Override
	public boolean checkTemperature(float temperature) {
		// TODO Auto-generated method stub
		if(temperature > 90.0f || temperature < -18.0f) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkCoolentLeak(float velocity, float Pressure) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean Compare(float temperature, float[] optimalTemperature) {
		boolean faultFlag = false;
		faultFlag = checkTemperature(temperature);
		if(faultFlag == false) {
			if(temperature < optimalTemperature[0]) {
				heatingMechanism(temperature);
			}
			if(temperature > optimalTemperature[1]) {
				coolingMechanism(temperature);
			}
			if(temperature < optimalTemperature[1] && temperature >= optimalTemperature[0]) {
				System.out.println("Thermal Management System: Temperature is in the optimal range");
			}
			return faultFlag;
		}else
		{
			return faultFlag;
		}		
	}
	
	public void coolingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Cooling the battery");
	}
	
	public void heatingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Heating the battery");
	}
	
	public static ThermalManagementModelImpl getInstance() {
		return instance;
	}
	
}