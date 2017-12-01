package com.bms.view;

import java.util.Scanner;

import com.bms.controller.ChargingControllerImpl;
import com.bms.controller.DischargingControllerImpl;
import com.bms.controller.FaultDetection;
import com.bms.controller.FaultDetectionImpl;
import com.bms.controller.PowerSavingModeController;
import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.PredictiveAnalysisImpl;
import com.bms.controller.ThermalManagementControllerImpl;

public class tempUI {

	private static FaultDetection fd;
	private static PowerSavingModeController psmc;
	private static ThermalManagementControllerImpl thermalManagementControllerImpl;
	private static ChargingControllerImpl chargingControllerImpl;
	private static DischargingControllerImpl dischargingControllerImpl;
	private static PredictiveAnalysisImpl pa;

	public static void main(String[] args) {
		psmc = PowerSavingModeControllerImpl.getInstance();
		fd = FaultDetectionImpl.getInstance();
		thermalManagementControllerImpl = ThermalManagementControllerImpl.getInstance();
		chargingControllerImpl=ChargingControllerImpl.getInstance();
		dischargingControllerImpl=DischargingControllerImpl.getInstance();
		pa = PredictiveAnalysisImpl.getInstance();
		
		HCI();
	}

	static void HCI() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();

			switch (input) {
			case "t":
				// Run Thermal Management System
				thermalManagementControllerImpl.callThermalManagementSystem();
				break;
			case "p":
				// Run power saving system
				psmc.CallPowerSavingSystem();
				break;
			case "a":
				// Run Predictive Analysis System
				pa.CallPredictiveAnalysis();
				break;
			case "c":
				// Run Charging System
				chargingControllerImpl.callChargingSystem();
				thermalManagementControllerImpl.callThermalManagementSystem();
				fd.CallFaultDetectiomSystem();
				break;
			case "d":
				// Run Discharging System
				dischargingControllerImpl.callDischargingSystem();
				thermalManagementControllerImpl.callThermalManagementSystem();
				fd.CallFaultDetectiomSystem();
				break;
			case "f":
				fd.CallFaultDetectiomSystem();
				// Run fault detection
				break;
			case "all":
				// Run everything
				psmc.CallPowerSavingSystem();
				thermalManagementControllerImpl.callThermalManagementSystem();
				chargingControllerImpl.callChargingSystem();
				dischargingControllerImpl.callDischargingSystem();
				pa.CallPredictiveAnalysis();			
				fd.CallFaultDetectiomSystem();
				
				
				break;
			case "toggle":
				// Toggles Power Saving Mode
				psmc.TogglePowerSavingMode();
				break;
			}
		}
	}

}
