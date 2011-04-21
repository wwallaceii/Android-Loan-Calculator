package com.wallacesolutions.loancalculator.test.views.payment;

import java.math.BigDecimal;

import com.wallacesolutions.loancalculator.model.Loan;
import com.wallacesolutions.loancalculator.views.payment.ILoanPaymentView;

public class TestLoanPaymentView implements ILoanPaymentView{
	private String _paymentText;
	private String _toastText;
	private String _amount;
	private String _length;
	private String _rate;
	
	public TestLoanPaymentView(String amount,
			                   String length,
			                   String rate)
	{
		_amount = amount;
		_length = length;
		_rate = rate;
	}
	
	@Override
	public void setDisplayedPayment(String text) {
		_paymentText = text;			
	}

	public String getDisplayedPayment() {
		return _paymentText;
	}

	@Override
	public String getAmount() {
		return _amount;
	}
	
	public void setAmount(String amount)
	{
		_amount = amount;
	}

	@Override
	public String getLength() {
		return _length;
	}

	public void setLength(String length)
	{
		_length = length;
	}
	
	@Override
	public String getRate() {
		return _rate;
	}

	public void setRate(String rate)
	{
		_rate = rate;
	}
	
	@Override
	public void setToastMessage(String text) {
		_toastText = text;		
	}
	
	public String getToastMessage()
	{
		return _toastText;
	}
}
