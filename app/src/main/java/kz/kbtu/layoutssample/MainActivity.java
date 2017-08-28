package kz.kbtu.layoutssample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    boolean isOp = false;
    String firstNumber = "";
    String secondNumber = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.input1);
    }




    public void onClick(View v){
        if (isOp){
            firstNumber = mEditText.getText().toString();
            mEditText.setText("");
            isOp = false;
        }
        Button button = (Button) v;
        mEditText.setText(mEditText.getText().toString()+button.getText());
    }


    public void sum(View v){
        isOp = true;
    }


    public void equal(View v){
        secondNumber = mEditText.getText().toString();

        Integer result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        mEditText.setText(result.toString());
    }
}
