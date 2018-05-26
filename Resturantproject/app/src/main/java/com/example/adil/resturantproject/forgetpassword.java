package com.example.adil.resturantproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class forgetpassword extends AppCompatActivity {
    EditText updatename,updatepassword;

    databasehelper helper;
    Button updatedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

            helper = new databasehelper(this);


//
//            updatename=(EditText)findViewById(R.id.updatename);
//            updatepassword=(EditText)findViewById(R.id.updatepassword);
//            updatedata=(Button)findViewById(R.id.updatebutton);
//            updatedata.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    helper.update(updatename.getText().toString(),updatepassword.getText().toString());
//                    Toast.makeText(forgetpassword.this, "Data has been UPDATED", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
