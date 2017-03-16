package com.github.mzule.fantasyslide.workout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanhong on 3/16/17.
 */

public class WorkoutContent {
    public static List<Workout> WORKOUTS = new ArrayList<Workout>();

    public static void addWorkout(Workout workout) {
        WORKOUTS.add(workout);
    }
}
