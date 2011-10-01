package com.wallacesolutions.loancalculator.views.payment;

public interface ILoanPaymentView {

	public void setDisplayedPayment(String text);
	public String getAmount();
	public String getLength();
	public String getRate();
	public void setToastMessage(String text);
	public void clearSoftKeyboard();
}
