package com.bms.view;

public class PrintThermalManagement{
	
	//Singleton
	private static final PrintThermalManagement instance = new PrintThermalManagement();
		
	
	public void DisplayThermalManagementMessage(String message) {
		System.out.println("Thermal Management: " + message);
	}
	
	public static PrintThermalManagement getInstance() {
		return instance;
	}
	
}

