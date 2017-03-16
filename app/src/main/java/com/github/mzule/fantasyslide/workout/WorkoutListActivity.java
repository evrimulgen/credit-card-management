package com.github.mzule.fantasyslide.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.mzule.fantasyslide.app.R;
import com.github.mzule.fantasyslide.base.BaseActivity;
import com.github.mzule.fantasyslide.base.BaseToolbarActivity;

/**
 * Created by shanhong on 3/16/17.
 */

public class WorkoutListActivity extends BaseToolbarActivity implements WorkoutListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent workoutIntent = new Intent(WorkoutListActivity.this, WorkoutCountdownActivity.class);
                //startActivity(workoutIntent);
            }
        });
    }

    /**
     * Callback method from {@link WorkoutListFragment.Callbacks} indicating that the workout with
     * the given ID was selected.
     */
    @Override
    public void onItemSelected(int position) {
        // Start the detail activity for the selected workout ID.
        //Intent detailIntent = new Intent(this, WorkoutDetailActivity.class);
        //detailIntent.putExtra(WorkoutDetailFragment.ARG_WORKOUT_POS, position);
        //startActivity(detailIntent);
    }

    /**
     * Add menu items to ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Handle menu item clicks
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }
}
