package com.wallacesolutions.loancalculator.presenters.payment;

import java.math.BigDecimal;

import com.wallacesolutions.loancalculator.business.LoanPaymentCalculator;
import com.wallacesolutions.loancalculator.model.Loan;
import com.wallacesolutions.loancalculator.views.payment.ILoanPaymentView;

public class LoanPaymentPresenter {
	private ILoanPaymentView _view;

	public LoanPaymentPresenter(ILoanPaymentView view)
	{
		_view = view;
	}

	public void calculatePayment() {
		//Clear currently displayed payment
		clearPayment();
		
		if(validateInput())
		{			
			LoanPaymentCalculator calc = new LoanPaymentCalculator();
			Loan loan = new Loan(new BigDecimal(_view.getAmount()),
					new BigDecimal(_view.getLength()),
					new BigDecimal(_view.getRate()));

			BigDecimal payment = calc.calculatePayment(loan);

			_view.setDisplayedPayment(payment.toString());
		}
		else
		{			
			_view.setToastMessage("All fields must be entered!");
		}
	}

	private void clearPayment() {
		_view.setDisplayedPayment("");		
	}

	private boolean validateInput()
	{
		return _view.getAmount() != null && !_view.getAmount().equals("") &&
		       _view.getLength() != null && !_view.getLength().equals("") &&
		       _view.getRate() != null && !_view.getRate().equals("");
	}
}
