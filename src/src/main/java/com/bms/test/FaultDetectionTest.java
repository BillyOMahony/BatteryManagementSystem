package com.bms.test;

import org.junit.jupiter.api.Test;

import com.bms.controller.SensorControllerImpl;
import com.bms.model.FaultDetectionModelImpl;
import com.bms.controller.FaultDetectionImpl;
import com.bms.view.PrintFaultDetection;

public class FaultDetectionTest {
 
 @Test
 void testInvalidLowVoltage() {
  
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float voltage = -200.0f; 
  sensor.setCoolantVelocity(-200);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("voltage is " +voltage);
  fdml.CheckVelocity(voltage);
 
 }
 

 @Test
 void testInvalidHignVoltage() {
  
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float voltage = 200.0f;
  sensor.setCoolantVelocity(2000);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("voltage is " +voltage);
  fdml.CheckVelocity(voltage);
  

 }
 
 
 @Test
 void testvalidVoltage() {
  
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float voltage = 12.4f;
  sensor.setCoolantVelocity(12.4f);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("voltage is " +voltage);
  fdml.CheckVelocity(voltage);
  

 }
 
 
 
 
 @Test
 void testInvalidLowCurrent() {
  
  SensorControllerImpl sensor = SensorControllerImpl.getInstance();
  Float current = -2.0f;
  sensor.setCurrent(-2);
  FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
  System.out.println("Current is " +current);
  fdml.CheckCurrent(current);
  

 }
  @Test
  void testInvalidHignCurrent() {
   
   SensorControllerImpl sensor = SensorControllerImpl.getInstance();
   Float current = 2.0f;
   sensor.setCurrent(2);
   FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
   System.out.println("Current is " +current); 
   fdml.CheckCurrent(current);
  
  
 }
  
  @Test
  void testvalidCurrent() {
   
   SensorControllerImpl sensor = SensorControllerImpl.getInstance();
   Float current = 0.5f;
   sensor.setCurrent(1);
   FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
   System.out.println("current is " +current);
   fdml.CheckCurrent(current);
   

  }
  
  
  @Test
  void testinvalidHignTemperature() {
   
   SensorControllerImpl sensor = SensorControllerImpl.getInstance();
   Float temperature = 80f;
   sensor.setBatteryTemperature(80f);
   FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
   System.out.println("temperature is " +temperature);
   fdml.CheckTeperature(temperature);
   

  }

  @Test
  void testinvalidLowTemperature() {
   
   SensorControllerImpl sensor = SensorControllerImpl.getInstance();
   Float temperature = 17f;
   sensor.setBatteryTemperature(17f);
   FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
   System.out.println("temperature is " +temperature);
   fdml.CheckTeperature(temperature);
   

  }
  

  @Test
  void testinvalidTemperature() {
   
   SensorControllerImpl sensor = SensorControllerImpl.getInstance();
   Float temperature = 33f;
   sensor.setBatteryTemperature(33f);
   FaultDetectionModelImpl fdml= FaultDetectionModelImpl.getInstance();  
   System.out.println("temperature is " +temperature);
   fdml.CheckTeperature(temperature);
   

  }
  
  
}