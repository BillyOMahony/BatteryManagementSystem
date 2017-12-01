package com.bms.view;

public class ChargingAndDischargingView {
	// Singleton
	private static final ChargingAndDischargingView instance = new ChargingAndDischargingView();

	public void DisplayChargingMessage(String message) {
		System.out.println(message);
	}
	public void DisplayDisChargingMessage(String message) {
		System.out.println(message);
	}
	public static ChargingAndDischargingView getInstance() {
		return instance;
	}
}
