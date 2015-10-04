package net.theb2tech.rpg_battle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Balázs on 28/09/2015.
 */
public class infos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infos);
    }

    public void ClickOnClasses(View v) {
        Intent intent = new Intent(this, heroClasses.class);
        startActivity(intent);
    }
}