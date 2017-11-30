package com.bms.model;

public class ThermalManagementModelImpl implements ThermalManagementModel{

	@Override
	public boolean checkTemperature(float temperature) {
		// TODO Auto-generated method stub
		if(temperature > 90.0f) {
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
	public void Compare(float temperature, float[] optimalTemperature) {
		if(temperature < optimalTemperature[0]) {
			heatingMechanism(temperature);
		}
		if(temperature > optimalTemperature[1]) {
			coolingMechanism(temperature);
		}
		if(temperature < optimalTemperature[1] && temperature >= optimalTemperature[0]) {
			System.out.println("Thermal Management System: Temperature is in the optimal range");
		}
		// TODO Auto-generated method stub
		
	}
	
	public void coolingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Cooling the battery");
	}
	
	public void heatingMechanism(float temp) {
		System.out.println("Thermal Management System: Current temperature is:" + temp);
		System.out.println("Thermal Management System: Heating the battery");
	}
	
}