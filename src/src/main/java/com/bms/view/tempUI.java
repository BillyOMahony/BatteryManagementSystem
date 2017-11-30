package com.bms.view;

import java.util.Scanner;

import com.bms.controller.powerSavingModeControllerImpl;

public class tempUI {

	private static powerSavingModeControllerImpl psmc;
	
	public static void main(String[] args) {
		psmc = new powerSavingModeControllerImpl();
		HCI();
	}
	
	static void HCI() {
		Scanner scanner = new Scanner(System. in);
		while(true) {
			String input = scanner.nextLine();

			switch (input){
				case "t":
					//Run Thermal Management System
					break;
				case "p":
					//Run power saving system
					psmc.CallPowerSavingSystem();
					break;
				case "a":
					//Run Predictive Analysis System
					break;
				case "c":
					//Run Charging and Discharging System
					break;
				case "f":
					//Run fault detection
					break;
				case "all":
					//Run everything
					break;
				case "toggle":
					//Toggles Power Saving Mode
					psmc.TogglePowerSavingMode();
					break;
			}
		}
	}
	
	
	
}
