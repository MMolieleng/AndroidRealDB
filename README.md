# Android Realm
Realm is a mobile database with its own persistence engine built for simplicity and speed to replace the traditional SQLite

This app can be used as a template for Realm database driven aandroid app, there is nothing much implemented in the app except the basics of Realm

## Documentation 
Realm's documentation can be found here https://realm.io/docs/java/latest/

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
