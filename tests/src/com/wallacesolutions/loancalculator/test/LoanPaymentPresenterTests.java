package com.wallacesolutions.loancalculator.test;

import com.wallacesolutions.loancalculator.presenters.payment.LoanPaymentPresenter;
import com.wallacesolutions.loancalculator.test.views.payment.TestLoanPaymentView;
import junit.framework.TestCase;

public class LoanPaymentPresenterTests extends TestCase {

	private TestLoanPaymentView _loanPaymentViewCorrectPayment;
	private TestLoanPaymentView _loanPaymentViewEmptyAmount;
	private TestLoanPaymentView _loanPaymentViewEmptyLength;
	private TestLoanPaymentView _loanPaymentViewEmptyRate;
	private LoanPaymentPresenter _loanPaymentPresenter;
	
	protected void setUp() throws Exception {
		super.setUp();
		_loanPaymentViewCorrectPayment = new TestLoanPaymentView("272473.00",
												   				 "30",
        										                 "5.25");
		
		_loanPaymentViewEmptyAmount = new TestLoanPaymentView("",
				                                              "30",
				                                              "5.25");
		_loanPaymentViewEmptyLength = new TestLoanPaymentView("272473.00",
                											  "",
                											  "5.25");
		_loanPaymentViewEmptyRate = new TestLoanPaymentView("272473.00",
                											"30",
                											"");
	}

	public void testCorrectPayment()
	{
		_loanPaymentPresenter = new LoanPaymentPresenter(_loanPaymentViewCorrectPayment);
		_loanPaymentPresenter.calculatePayment();
		assertEquals("1504.61", _loanPaymentViewCorrectPayment.getDisplayedPayment());
	}
	
	
	public void testToastMessageDisplayedForMissingAmount()
	{
		_loanPaymentPresenter = new LoanPaymentPresenter(_loanPaymentViewEmptyAmount);
		_loanPaymentPresenter.calculatePayment();
		assertEquals("All fields must be entered!", _loanPaymentViewEmptyAmount.getToastMessage());
	}
	
	public void testToastMessageDisplayedForMissingLength()
	{
		_loanPaymentPresenter = new LoanPaymentPresenter(_loanPaymentViewEmptyLength);
		_loanPaymentPresenter.calculatePayment();
		assertEquals("All fields must be entered!", _loanPaymentViewEmptyLength.getToastMessage());
	}
	
	public void testToastMessageDisplayedForMissingRate()
	{
		_loanPaymentPresenter = new LoanPaymentPresenter(_loanPaymentViewEmptyRate);
		_loanPaymentPresenter.calculatePayment();
		assertEquals("All fields must be entered!", _loanPaymentViewEmptyRate.getToastMessage());
	}
	
	public void testDisplayedPaymentResetIfNewCalculationResultsInToastMessageDisplayed()
	{
		_loanPaymentPresenter = new LoanPaymentPresenter(_loanPaymentViewCorrectPayment);
		_loanPaymentPresenter.calculatePayment();
		_loanPaymentViewCorrectPayment.setAmount("");
		_loanPaymentPresenter.calculatePayment();
		
		assertEquals("", _loanPaymentViewCorrectPayment.getDisplayedPayment());
	}
}

