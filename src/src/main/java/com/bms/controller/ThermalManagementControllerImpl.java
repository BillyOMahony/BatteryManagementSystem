package com.bms.controller;
//Controller class

import com.bms.model.ThermalManagementModelImpl;
import com.bms.view.PrintThermalManagement;

public class ThermalManagementControllerImpl implements ThermalManagementController{

	private ThermalManagementModelImpl model;
	private PrintThermalManagement view;
	private SensorControllerImpl sensor;
	private float temperature;
	private float velocity;
	private float pressure;
	private float[] optimalTemp;
	boolean leakageFlag, tempFlag;

	private PowerSavingModeController powerSavingModeController;
	
	//Singleton
	private static final ThermalManagementControllerImpl instance = new ThermalManagementControllerImpl();
		
	public ThermalManagementControllerImpl(ThermalManagementModelImpl model, PrintThermalManagement view){
		this.model = model;
		this.view = view;
		powerSavingModeController = PowerSavingModeControllerImpl.getInstance();
		sensor = SensorControllerImpl.getInstance();

	}

	public ThermalManagementControllerImpl() {
		// TODO Auto-generated constructor stub
		model = ThermalManagementModelImpl.getInstance();
		view = PrintThermalManagement.getInstance();
		powerSavingModeController = PowerSavingModeControllerImpl.getInstance();
		sensor = SensorControllerImpl.getInstance();
	}

	@Override
	public void callThermalManagementSystem() {
		// TODO Auto-generated method stub
		try {
		temperature = sensor.getBatteryTemperature();
		/*velocity = sensor.getCoolantVelocity();
		pressure = sensor.getCoolantPressure();*/
		optimalTemp = powerSavingModeController.GetOptimalTemperature();
		
		tempFlag = model.Compare(temperature, optimalTemp);
		updateView();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : "+ e);
		}
	}

	public void updateView(){	
		String message = "";
		if(tempFlag == true) {
			message = "Emergency Evacuation Alert! Temperaure not in normal range";
		}else
		{
			message = "System is in safe range";
		}
		view.DisplayThermalManagementMessage(message);
	}
	
	public static ThermalManagementControllerImpl getInstance() {
		return instance;
	}

}
