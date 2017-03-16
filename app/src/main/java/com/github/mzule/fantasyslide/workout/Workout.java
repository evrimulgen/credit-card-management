package com.github.mzule.fantasyslide.workout;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

/**
 * Created by shanhong on 3/16/17.
 */

public class Workout {
    public String id;

    public String name;

    public String content;

    public String video;

    public int dark;

    public int light;

    public Workout(@NonNull String id,
                   @NonNull String name,
                   @NonNull String content,
                   @NonNull String video,
                   @ColorRes int dark,
                   @ColorRes int light) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.video = video;
        this.dark = dark;
        this.light = light;
    }
}
