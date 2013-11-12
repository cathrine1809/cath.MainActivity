package unikl.edu.stu0113.simplecalculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	EditText text1;
	EditText text2;
	Spinner spinner;
	Button buttonClear;
	Button buttonCalculate;
	TextView txtViewResult;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        spinner = (Spinner) findViewById(R.id.spinner_entries);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonCalculate = (Button) findViewById(R.id.buttonCalc);
        txtViewResult = (TextView) findViewById(R.id.textView1);
        
        buttonClear.setOnClickListener(this);
        buttonCalculate.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.buttonClear:
			clearInput();
			break;
		case R.id.buttonCalc:
			calculate();
			break;

		default:
			break;
		}
		
	}
	
	private void clearInput(){
		text1.setText("");
		text2.setText("");
		spinner.setSelection(0);
	}
	
	private void calculate(){
		String num1Str = text1.getText().toString();
		String num2Str = text2.getText().toString();
		String operation = (String) spinner.getSelectedItem();
		
		double num1 = Double.parseDouble(num1Str);
		double num2 = Double.parseDouble(num2Str);
		double result = 0.0; 
		
		if (operation.equals("+")) {
			result = num1 + num2;
		}else if (operation.equals("-")) {
			result = num1 - num2;
		}else if (operation.equals("*")) {
			result = num1 * num2;
		}else if (operation.equals("/")) {
			result = num1 / num2;
		}
		txtViewResult.setText(""+result);
	}

    
}
