package com.bms.test;

import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.model.FaultDetectionModel;
import com.bms.model.FaultDetectionModelImpl;
import com.bms.controller.FaultDetectionImpl;




public class FaultDetectionTest {
	

	SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	FaultDetectionImpl fdm = FaultDetectionImpl.getInstance();
//	PowerSavingModeControllerImpl psm = PowerSavingModeControllerImpl.getInstance();
 
 @Test
 void testcase1() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 12.5f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  fdm.CallFaultDetectiomSystem();
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature); 
  System.out.println("\n");
 }
 
 
 
 @Test
 void testcase2() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 12.5f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase3() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 12.5f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase4() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 12.5f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase5() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 12.5f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase6() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 13f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase7() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 11f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase8() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 11f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase9() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 13f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase10() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 13f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase11() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.5f;
  Float voltage = 11f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase12() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 13f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase13() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 11f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase14() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 11f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase15() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 13f; 
  Float temperature = 33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase16() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 12.5f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase17() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 12.5f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase18() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 12.5f; 
  Float temperature = 00f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase19() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 12.5f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase20() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 11f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase21() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 13f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase22() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 13f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase23() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 11f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase24() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 2.2f;
  Float voltage = 11f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase25() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 13f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase26() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 13f; 
  Float temperature = -33f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 
 @Test
 void testcase27() {
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = 0.2f;
  Float voltage = 11f; 
  Float temperature = 99f;
  sensor.setCurrent(current);
  sensor.setCoolantVelocity(voltage);
  sensor.setBatteryTemperature(temperature);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current + "     " + "voltage is " +voltage + "     " +"temperature is " +temperature);
  fdml.CheckCurrent(current);
  fdml.CheckVelocity(voltage);
  fdml.CheckTeperature(temperature);
  System.out.println("\n");
 }
 

}