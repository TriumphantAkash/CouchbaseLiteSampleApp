package contactskeeper.achaturvedi.com.couchbaseevents;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;

/**
 * Created by achaturvedi on 11/5/2015.
 */
public class CouchbaseEventsActivity extends Activity {
    public static final String DB_NAME = "couchbaseevents";
    public static final String TAG = "couchbaseevents";
    private Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            /*
             * In Java the Manager instance and all the objects descending
             * from it may be used on any thread.
             */
            manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
        } catch (IOException e) {
            Log.e(TAG, "Cannot create Manager instance", e);
            return;
        }
        Log.i(TAG, "came here" + this.getFilesDir().toString());
    }
}
