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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

            //documents Karma

            //creates a new document with random ID
            Document document = database.createDocument();
            Log.i(TAG, "generated document ID is: " + document.getId());

            //create a new document wirh specified ID
            Document idDocument = database.getDocument("axc144430@utdallas.edu");
            Log.i(TAG, "generated document ID is: " + idDocument.getId());

            Map<String, Object> map = new HashMap<>();
            map.put("name", "Akash Chaturvedi");
            map.put("Age", 26);

            try {
                //save the properties to the document
                //The data is now persisted to the database
                idDocument.putProperties(map);
                
            } catch(Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            Log.e(TAG, "Cannot create Manager instance", e);
            return;
        }
        Log.i(TAG, "came here" + this.getFilesDir().toString());
    }
}
