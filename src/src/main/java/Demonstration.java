import com.bms.controller.ChargingDischargingControllerImpl;
import com.bms.controller.FaultDetectionImpl;
import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.PredictiveAnalysisImpl;
import com.bms.controller.SensorControllerImpl;
import com.bms.controller.ThermalManagementControllerImpl;
import com.bms.controller.DemoBatteryController;

public class Demonstration {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		double fiveSecondTimer = 0;
		double tenSecondTimer = 0;
		double secondTimer = 0;
		double runTimeSeconds = 0;
		double prevRunTimeSeconds = 0;
		double deltaTime = 0;
		
		double halfSecondTimer = 0;
		
		int secondCounter = 0;
		
		ChargingDischargingControllerImpl chargingDischargingController = ChargingDischargingControllerImpl.getInstance();
		FaultDetectionImpl faultDetection = FaultDetectionImpl.getInstance();
		PowerSavingModeControllerImpl powerSavingController = PowerSavingModeControllerImpl.getInstance();
		PredictiveAnalysisImpl predictiveAnalysis = PredictiveAnalysisImpl.getInstance();
		ThermalManagementControllerImpl thermalManagementController = ThermalManagementControllerImpl.getInstance();
		DemoBatteryController demoBattery = new DemoBatteryController();
		
		SensorControllerImpl sensor = SensorControllerImpl.getInstance();
		
		while(true) {
			long currentRunTime = System.nanoTime() - startTime;
			
			//Calculate deltaTime (Time since last loop in seconds)			
			runTimeSeconds = (double)currentRunTime / 1000000000.0;
			deltaTime = runTimeSeconds - prevRunTimeSeconds;
			prevRunTimeSeconds = runTimeSeconds;
			
			halfSecondTimer += deltaTime;
			
			if(halfSecondTimer >= 0.124) {
				demoBattery.CallDemoBatteryController(runTimeSeconds, halfSecondTimer);
				halfSecondTimer -= 0.124;			
			}
			
			// This is called every loop
			
			// This runs every second
			secondTimer += deltaTime;
			if(secondTimer >= 1) {
				secondTimer -= 1;
				secondCounter ++;				
				
				//faultDetection.CallFaultDetectiomSystem();
				
				System.out.println(secondCounter);
			}
			
			// This runs every 5 seconds
			fiveSecondTimer += deltaTime;
			if(fiveSecondTimer >= 5) {
				fiveSecondTimer -=5;
				
				System.out.println("\nCalling Charging and Discharging System");
				chargingDischargingController.callChargingDischargingSystem();
				
				System.out.println("\nCalling Power Saving System");
				powerSavingController.CallPowerSavingSystem();
				
				System.out.println("\nCalling Thermal Management System");
				thermalManagementController.callThermalManagementSystem();
				System.out.println("\nTemp" + sensor.getBatteryTemperature());
			}
			
			// This runs every 10 seconds
			tenSecondTimer += deltaTime;
			if(tenSecondTimer >= 10) {
				tenSecondTimer -= 10;
			
				System.out.println("\nCalling Predictive Analysis System");
				predictiveAnalysis.CallPredictiveAnalysis();
				
				// This print isn't synced unless there's a print in demobatterycontroller
				System.out.println("Distance Travelled in loop " + sensor.getDistanceTravelled());
			}
		
		}
		
	}

}
