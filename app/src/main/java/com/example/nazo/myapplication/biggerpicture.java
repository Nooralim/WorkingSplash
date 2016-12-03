package com.example.nazo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nazo on 12/2/2016.
 */
//this is used for when you click on the button, this is supposed to show you the second screen
public class biggerPicture extends AppCompatActivity{

    private static final String EXTRA_ANSWER_IS_TRUE = "true";

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = newIntent(packageContext, true);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);

        return i;

    }
}
