package kz.kbtu.layoutssample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LifecycleActivity extends AppCompatActivity  implements Blank2Fragment.OnFragmentInteractionListener{

    private static final String TAG = "LifecycleActivity";

    EditText mEditText;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        mEditText  = (EditText) findViewById(R.id.edit);
        BlankFragment fragment = new BlankFragment();
        Blank2Fragment fragment1 = new Blank2Fragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, fragment);
        transaction.add(R.id.frame2, fragment1);
        transaction.addToBackStack("fragment2");
//        transaction.add(R.id.frame2, fragment1);
        transaction.commit();




        Log.d(TAG, "onCreate");

        if (savedInstanceState != null){
            str = savedInstanceState.getString("str");
//            Log.d("String", str);
            mEditText.setText(str);
        }
    }


    public void onClick(View v){
//        Intent intent = new Intent(this, ScrollingActivity.class);
//        startActivity(intent);

//        finish();

        str = "Hello World";
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.d(TAG, "onDestroy");
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("str", mEditText.getText().toString());
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
