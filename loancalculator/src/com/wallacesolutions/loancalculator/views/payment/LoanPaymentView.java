package com.wallacesolutions.loancalculator.views.payment;

import com.wallacesolutions.loancalculator.R;
import com.wallacesolutions.loancalculator.presenters.payment.LoanPaymentPresenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class LoanPaymentView extends Activity implements ILoanPaymentView {
	
	private LoanPaymentPresenter _presenter;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loanpayment);
		
		createEditorActionListener();
		_presenter = new LoanPaymentPresenter(this);
	}

		private void createEditorActionListener() {
			EditText rateField = (EditText) findViewById(R.id.interestRate);

			rateField.setOnEditorActionListener(new OnEditorActionListener() {
			    @Override
			    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			        if (actionId == EditorInfo.IME_ACTION_DONE ||
			        	event.getKeyCode() == KeyEvent.FLAG_EDITOR_ACTION ||
			        	event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
			        {
			            _presenter.calculatePayment();
			        }
			        return false;
			    }
			});
		
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

	@Override
	public void clearSoftKeyboard() {
		EditText rateText = (EditText) findViewById(R.id.interestRate);
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rateText.getApplicationWindowToken(), 0);
		
	}
}