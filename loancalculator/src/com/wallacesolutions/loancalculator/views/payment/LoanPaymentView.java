package com.wallacesolutions.loancalculator.views.payment;

import com.wallacesolutions.loancalculator.R;
import com.wallacesolutions.loancalculator.presenters.payment.LoanPaymentPresenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoanPaymentView extends Activity implements ILoanPaymentView {
	
	private LoanPaymentPresenter _presenter;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loanpayment);
		_presenter = new LoanPaymentPresenter(this);
	}

	public void calcButtonClick(View view) {
		_presenter.calculatePayment();
	}

	@Override
	public String getRate() {
		EditText rateText = (EditText) findViewById(R.id.interestRate);
		return rateText.getText().toString();
	}

	@Override
	public String getLength() {
		EditText lengthText = (EditText) findViewById(R.id.loanLength);
		return lengthText.getText().toString();
	}

	@Override
	public String getAmount() {
		EditText amountText = (EditText) findViewById(R.id.amountFinanced);
		return amountText.getText().toString();
	}

	@Override
	public void setDisplayedPayment(String text) {
		TextView paymentText = (TextView) findViewById(R.id.paymentText);
		paymentText.setText(text);
	}

	@Override
	public void setToastMessage(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT ).show();	
	}

}