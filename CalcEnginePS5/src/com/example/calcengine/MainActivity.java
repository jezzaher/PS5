package com.example.calcengine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;






public class MainActivity extends Activity implements OnClickListener {
	Button Calculate;
	EditText InvestmentAmnt;
	Spinner Yrs;
	EditText Annual_Interest_Rte;
	EditText Future_Val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculate =(Button) findViewById(R.id.Calculate);
        InvestmentAmnt=(EditText) findViewById(R.id.NInvestment_Amount);
        Yrs=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> yr=ArrayAdapter.createFromResource(this,R.array.numOfyears, android.R.layout.simple_list_item_1);
        yr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Yrs.setAdapter(yr);
        Annual_Interest_Rte=(EditText) findViewById(R.id.NAnnnual_Interest_Rate);
        Future_Val=(EditText) findViewById(R.id.NFuture_Value);
        Calculate.setOnClickListener(new View.OnClickListener(){
        	
			@Override
        	public void onClick(View v) {
        		double myInvestmentAmount=Double.parseDouble(InvestmentAmnt.getText().toString());
        		InvestmentAmnt.setText( String.format( " %.2f", myInvestmentAmount ) );
        		int myYears=Integer.parseInt(Yrs.getSelectedItem().toString());
        		double myAnnual_Interest_Rate=Double.parseDouble(Annual_Interest_Rte.getText().toString());
        		Annual_Interest_Rte.setText( String.format( " %.2f", myAnnual_Interest_Rate ));
        		double myFuture_Val= myInvestmentAmount*Math.pow((1+myAnnual_Interest_Rate/100),myYears);	
        		Future_Val.setText(myFuture_Val+" ");
        		Future_Val.setText( String.format( " %.2f", myFuture_Val ));
        		
        	}
        });
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



	


	

  
}
