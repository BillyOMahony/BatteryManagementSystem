package com.bms.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bms.controller.PowerSavingModeControllerImpl;
import com.bms.controller.PredictiveAnalysisImpl;
import com.bms.controller.SensorControllerImpl;
import com.bms.dao.PredictiveAnalysisDaoImpl;
import com.bms.model.PredictiveAnalysisModelImpl;

class PredictiveAnalysisTest {
	
	float output;
	float expected;
	
	SensorControllerImpl sensor = SensorControllerImpl.getInstance();
	PredictiveAnalysisImpl pa = PredictiveAnalysisImpl.getInstance();
	PredictiveAnalysisDaoImpl dao = PredictiveAnalysisDaoImpl.getInstance();
	PredictiveAnalysisModelImpl model = PredictiveAnalysisModelImpl.getInstance();
	
	/*
	 *test when distance travelled is positive and loss of charge is positive
	 */
	@Test
	void testDistancePositiveAndLossOfChargePositive() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.42f);
		sensor.setDistanceTravelled(500000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 1: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is positive and loss of charge is zero
	 */
	@Test
	void testDistancePositiveAndLossOfChargeZero() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.4f);
		sensor.setDistanceTravelled(520000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.4f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 2: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is positive and loss of charge is negative
	 */
	@Test
	void testDistancePositiveAndLossOfChargeNegative() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.7f);
		sensor.setDistanceTravelled(510000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 3: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is zero and loss of charge is positive
	 */
	@Test
	void testDistanceZeroAndLossOfChargeIsPositive() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.4f);
		sensor.setDistanceTravelled(490000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 4: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is zero and loss of charge zero
	 */
	@Test
	void testDistanceZeroAndLossOfChargeZero() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.45f);
		sensor.setDistanceTravelled(490000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 5: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is zero and loss of charge is negative
	 */
	@Test
	void testDistanceZeroAndLossOfChargeNegative() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.6f);
		sensor.setDistanceTravelled(490000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 6: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	
	/*
	 *test when distance travelled is negative and loss of charge is negative
	 */
	@Test
	void testDistanceNegativeAndLossOfChargeNegative() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.55f);
		sensor.setDistanceTravelled(480000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.45f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 7: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	
	/*
	 *test when distance travelled is negative and loss of charge is zero
	 */
	@Test
	void testDistanceNegativeAndLossOfChargeZero() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.52f);
		sensor.setDistanceTravelled(480000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.52f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 8: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	/*
	 *test when distance travelled is negative and loss of charge is positive
	 */
	@Test
	void testDistanceNegativeAndLossOfChargePositive() {
		//fail("Not yet implemented");
		sensor.setStateOfCharge(.22f);
		sensor.setDistanceTravelled(480000); //distance in meters - this is the odometer distance
		dao.setDistance(490000);
		dao.setSoc(.52f);
		output = pa.CallPredictiveAnalysis();
		expected = Math.round(sensor.getStateOfCharge()*dao.getEfficiency());
		System.out.println("TEST 9: the answer is "+output+", expecting: "+expected);
		assertEquals(expected, output);
	}
	
	
	/*
	 *test to ensure CallPredictiveAnalysis() returns a value
	 */
	@Test
	void testCallPredictiveAnalysisReturnsValue() {
		float value = pa.CallPredictiveAnalysis();
		assertNotNull(value);
	}
	
	/*
	 *test to ensure rangeCalculator() returns a value
	 */
	@Test
	void testRangeCalculatorReturnsValue() {
		float value = model.rangeCalculator(0.2f, 1234.6f);
		assertNotNull(value);
	}
	
	/*
	 *test to ensure fuelEffCal() returns a correct value
	 *when lossOfCharge <= 0, value for efficiency doesn't matter
	 */
	@Test
	void testFuelEffCalWhenLocLessThanZero() {
		dao.setEfficiency(100f);
		dao.setSoc(1);
		float outputValue = model.fuelEffCal(-1f, 6f);
		float expectedValue = 100;
		assertEquals(expectedValue, outputValue);
	}
	
	/*
	 *test to ensure fuelEffCal() returns a correct value
	 *when lossOfCharge > 0, value for efficiency <= 0
	 */
	@Test
	void testFuelEffCalWhenLocLessMoreThanZeroAndEffLessThanZero() {
		dao.setDistance(4999);
		dao.setEfficiency(10f);
		float outputValue = model.fuelEffCal(-0.5f, -1f);
		float expectedValue = 10;
		assertEquals(expectedValue, outputValue);
	}
	
	/*
	 *test to ensure fuelEffCal() returns a correct value
	 *when lossOfCharge > 0, value for efficiency > 0
	 */
	@Test
	void testFuelEffCalWhenLocLessMoreThanZeroAndEffMoreThanZero() {
		dao.setDistance(1);
		dao.setSoc(1);
		float outputValue = model.fuelEffCal(0f, 5001f);
		float expectedValue = 5;
		assertEquals(expectedValue, outputValue);
	}
	
}
