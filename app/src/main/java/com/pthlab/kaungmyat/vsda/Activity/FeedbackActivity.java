package com.pthlab.kaungmyat.vsda.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.pthlab.kaungmyat.vsda.R;
import androidx.annotation.Nullable;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_feedback_layout);
    }
}
