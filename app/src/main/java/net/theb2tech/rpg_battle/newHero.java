package net.theb2tech.rpg_battle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Balázs on 2015. 09. 27..
 */
public class newHero extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newhero);
    }

    public void editTextClick(View v){
        EditText editttext = (EditText) v;
        editttext.setText("");
    }
}
