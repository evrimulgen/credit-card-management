package com.github.mzule.fantasyslide.calendar;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.github.mzule.fantasyslide.base.BaseActivity;
import com.github.mzule.fantasyslide.app.R;
import com.github.mzule.fantasyslide.calendar.decorator.EventDecorator;
import com.github.mzule.fantasyslide.calendar.decorator.HighlightWeekendsDecorator;
import com.github.mzule.fantasyslide.calendar.decorator.MySelectorDecorator;
import com.github.mzule.fantasyslide.calendar.decorator.OneDayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scheng on 3/11/17.
 */

public class BasicActivityDecorated extends BaseActivity implements OnDateSelectedListener {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();

    @Bind(R.id.calendarView)
    MaterialCalendarView widget;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_material_calendar_decorated);
        ButterKnife.bind(this);

        widget.setOnDateChangedListener(this);
        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);

        Calendar instance = Calendar.getInstance();
        widget.setSelectedDate(instance.getTime());

        Calendar instance1 = Calendar.getInstance();
        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);

        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);

        widget.state().edit()
                .setMinimumDate(instance1.getTime())
                .setMaximumDate(instance2.getTime())
                .commit();

        widget.addDecorators(
                new MySelectorDecorator(this),
                new HighlightWeekendsDecorator(),
                oneDayDecorator
        );

        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
        oneDayDecorator.setDate(date.getDate());
        widget.invalidateDecorators();
    }

    /**
     * Simulate an API call to show how to add decorators
     */
    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -2);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                CalendarDay day = CalendarDay.from(calendar);
                dates.add(day);
                calendar.add(Calendar.DATE, 5);
            }

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            widget.addDecorator(new EventDecorator(Color.RED, calendarDays));
        }
    }
}
