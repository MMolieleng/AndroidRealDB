# AndroidRealDB
Realm is a mobile database like SQLite for mobile apps. It makes database management much more easier than SQLite and it is also more effecitient than SQLite.

This app can be used as a template for Realm database driven aandroid app, there is nothing much implemented in the app except the basics of Realm

##How to initialize Realm in your app
Create a class that extends Application


```java

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
```
