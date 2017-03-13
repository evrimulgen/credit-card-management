package com.github.mzule.fantasyslide.camera;

import android.app.Activity;
import android.os.Bundle;

import com.github.mzule.fantasyslide.app.R;

/**
 * Created by shanhong on 3/13/17.
 */

public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

}
