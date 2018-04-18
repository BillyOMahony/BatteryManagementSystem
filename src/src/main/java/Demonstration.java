import com.bms.controller.ChargingControllerImpl;
import com.bms.controller.DischargingControllerImpl;
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
		
		int secondCounter = 0;
		
		ChargingControllerImpl chargingController = ChargingControllerImpl.getInstance();
		DischargingControllerImpl dischargingController = DischargingControllerImpl.getInstance();
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
			
			// This is called every loop
			demoBattery.CallDemoBatteryController(runTimeSeconds, deltaTime);
			
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
				
				chargingController.callChargingSystem();
				dischargingController.callDischargingSystem();
				powerSavingController.CallPowerSavingSystem();
				thermalManagementController.callThermalManagementSystem();
			}
			
			// This runs every 10 seconds
			tenSecondTimer += deltaTime;
			if(tenSecondTimer >= 10) {
				tenSecondTimer -= 10;
				
				predictiveAnalysis.CallPredictiveAnalysis();
				System.out.println("Distance Travelled: "+ sensor.getDistanceTravelled());
			}
		}
		
	}

}
