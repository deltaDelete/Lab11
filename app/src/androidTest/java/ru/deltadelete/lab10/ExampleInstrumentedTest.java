package ru.deltadelete.lab10;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import ru.deltadelete.lab10.entities.Country;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("ru.deltadelete.lab10", appContext.getPackageName());
    }

    @Test
    public void checkDbInsert() {
        AppDatabase db = Room.databaseBuilder(InstrumentationRegistry.getInstrumentation().getTargetContext(),
                AppDatabase.class, "towns-db").build();

        Country c = new Country(0, "Россия", "RU");
        db.countryDao().insertAll(c);

        Country c1 = db.countryDao().getAll().get(0);
        try {
            Assert.assertEquals(c.getName(), c1.getName());
            Assert.assertEquals(c.getCode(), c1.getCode());
        }
        finally {
            db.countryDao().delete(c1);
        }
    }
}