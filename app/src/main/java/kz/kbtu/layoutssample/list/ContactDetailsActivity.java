package kz.kbtu.layoutssample.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kz.kbtu.layoutssample.R;

public class ContactDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);


        Contacts contacts = getIntent().getParcelableExtra("contact");

        TextView textView = (TextView) findViewById(R.id.name);
        TextView textView1 = (TextView) findViewById(R.id.phone);

        textView.setText(contacts.getName());
        textView1.setText(contacts.getPhone());
    }
}
