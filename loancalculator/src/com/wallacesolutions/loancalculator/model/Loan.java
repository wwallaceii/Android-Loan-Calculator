package com.wallacesolutions.loancalculator.model;

import java.math.BigDecimal;

public class Loan {

	private BigDecimal amount;
	private BigDecimal length;
	private BigDecimal rate;
	
	public Loan(BigDecimal amountFinanced,
			    BigDecimal loanLength,
			    BigDecimal interestRate)
	{
		amount = amountFinanced;
		amount.setScale(0, BigDecimal.ROUND_HALF_UP);
		length = loanLength;
		rate = interestRate;
		rate.setScale(0, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getLength() {
		return length;
	}

	public BigDecimal getRate() {
		return rate;
	}
	
	
}
