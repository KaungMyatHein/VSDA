package com.pthlab.kaungmyat.vsda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pthlab.kaungmyat.vsda.R;
import androidx.annotation.Nullable;

/****** 12/31/2018 BY HSS *******/
/****** Feedback Activity *******/

public class FeedbackActivity extends AppCompatActivity {

    TextView feedback_name, feedback_phone, feedback_email, feedback_msg;
    Button feedback_submit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_layout);

        feedback_name =findViewById(R.id.feedback_name);
        feedback_phone =findViewById(R.id.feedback_phone);
        feedback_email=findViewById(R.id.feedback_email);
        feedback_msg =findViewById(R.id.feedback_message);
        feedback_submit = findViewById(R.id.feedback_submit);

        String username= feedback_name.getText().toString();
        String userphone = feedback_phone.getText().toString();
        String useremail = feedback_email.getText().toString();
        String message = feedback_msg.getText().toString();
       final String send_message = message +"\n"+ "Name : " + username +"\n" +"Phone Number : " +"\n"+ userphone ;


        feedback_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "susandarswe.mm@gmail.com", "kaungmyat9702@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Feedback From VSDA User");
                email.putExtra(Intent.EXTRA_TEXT, send_message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
