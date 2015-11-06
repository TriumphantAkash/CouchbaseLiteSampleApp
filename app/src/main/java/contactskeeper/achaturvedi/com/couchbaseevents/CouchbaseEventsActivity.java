package contactskeeper.achaturvedi.com.couchbaseevents;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.ManagerOptions;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;

/**
 * Created by achaturvedi on 11/5/2015.
 */
public class CouchbaseEventsActivity extends Activity {
    public static final String DB_NAME = "couchbaseevents";
    public static final String TAG = "couchbaseevents";
    private Manager manager;
    private Database database;
    private String databaseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseName = "couchbasenames";

        try {
            /*
             * In Java the Manager instance and all the objects descending
             * from it may be used on any thread.
             */
            /*
            * By default a Manager will open a Database with read/write access.
            * If you want to ensure that data can not be modified you can restrict Database access
            * to read only by passing a ManagerOptions object to the Manager constructor or initializer.
            * */
            ManagerOptions customOptions = new ManagerOptions();
            customOptions.setReadOnly(false);
            manager = new Manager(new AndroidContext(getApplicationContext()), customOptions);

            //Manager's getDatabase method creates a database and returns its instance
            database = new Database(databaseName, manager);

            //documents
        } catch (IOException e) {
            Log.e(TAG, "Cannot create Manager instance", e);
            return;
        }
        Log.i(TAG, "came here" + this.getFilesDir().toString());
    }
}
