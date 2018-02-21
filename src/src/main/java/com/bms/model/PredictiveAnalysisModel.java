package com.bms.model;

public interface PredictiveAnalysisModel {
	public float rangeCalculator(float soc, float distance);
	public float fuelEffCal(float soc, float distance);
}
