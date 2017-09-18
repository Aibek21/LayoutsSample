package kz.kbtu.layoutssample.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import kz.kbtu.layoutssample.R;

public class DatabaseActivity extends AppCompatActivity {


    private static final String TAG = "DatabaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


//        save();

        read();
    }



    public void save(){
        SQLiteDatabase database = new DBHelper(this).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Employer.COLUMN_NAME, "Name");
        values.put(DBContract.Employer.COLUMN_DESCRIPTION, "Desc");


        long newRowId = database.insert(DBContract.Employer.TABLE_NAME, null, values);

        Toast.makeText(this, "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();
    }



    public void read(){

        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();

        String[] projection = {
                DBContract.Employer._ID,
                DBContract.Employer.COLUMN_NAME,
                DBContract.Employer.COLUMN_DESCRIPTION,
                DBContract.Employer.COLUMN_FOUNDED_DATE
        };

        String selection =
                DBContract.Employer.COLUMN_NAME + " like ? and " +
                        DBContract.Employer.COLUMN_DESCRIPTION + " like ?";

        String name = "MyName";
        String desc = "My Employee";
        String[] selectionArgs = {"%" + name + "%", "%" + desc + "%"};

        Cursor cursor = database.query(
                DBContract.Employer.TABLE_NAME,     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // don't sort
        );

        Log.e(TAG, "The total cursor count is " + cursor.getCount());

//        cursor.moveToFirst();
//
//        String nameString = cursor.getString(cursor.getColumnIndexOrThrow(DBContract.Employer.COLUMN_NAME));
//        Toast.makeText(this, nameString, Toast.LENGTH_SHORT).show();

        while (cursor.moveToNext()){
            String nameString = cursor.getString(cursor.getColumnIndexOrThrow(DBContract.Employer.COLUMN_NAME));
            Toast.makeText(this, nameString, Toast.LENGTH_SHORT).show();
        }

    }
}
