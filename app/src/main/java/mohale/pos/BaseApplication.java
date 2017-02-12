package mohale.pos;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by user on 2/12/2017.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        Realm.init(getBaseContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
