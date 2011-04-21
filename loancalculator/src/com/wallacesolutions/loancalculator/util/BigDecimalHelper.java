package com.wallacesolutions.loancalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalHelper {

	public static BigDecimal divide(BigDecimal num1, BigDecimal num2)
	{
		return num1.divide(num2, 10, RoundingMode.HALF_UP);
	}
	
	public static BigDecimal multiply(BigDecimal num1, BigDecimal num2)
	{
		return num1.multiply(num2);
	}

	public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
		// TODO Auto-generated method stub
		return num1.add(num2);
	}
	
	public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
		// TODO Auto-generated method stub
		return num1.subtract(num2);
	}
	
}
