package mohale.pos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import mohale.pos.model.Product;

public class MainActivity extends AppCompatActivity {

    //UI Components
    private EditText productName;
    private EditText productPrice;
    private Button submit;
    private TextView display;


    //Data Objects
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        productName = (EditText) findViewById(R.id.product_name);
        productPrice = (EditText) findViewById(R.id.product_price);
        submit = (Button) findViewById(R.id.submit_btn);
        display = (TextView) findViewById(R.id.display);

    }

    public void saveProduct(View v) {

        int priceValue = Integer.parseInt(productPrice.getText().toString());
        String item_name = productName.getText().toString();

        add_new_product(priceValue, item_name);
    }

    private void add_new_product(final int priceValue, final String item_name) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Product product = realm.createObject(Product.class);
                product.setName(item_name);
                product.setPrice(priceValue);
            }
        }, new Realm.Transaction.OnSuccess() {

            @Override
            public void onSuccess() {

                Toast.makeText(MainActivity.this, "Oh, Yes", Toast.LENGTH_SHORT).show();
                showData();
            }

            private void showData() {

                RealmQuery<Product> query = realm.where(Product.class);
                // Execute the query:
                RealmResults<Product> result1 = query.findAll();

                String res_row = "";
                for (Product p : result1) {
                    res_row += p.getName() + " " + p.getPrice() + " " + p.getId() + "\n";

                }
                display.setText(res_row);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

                Toast.makeText(MainActivity.this, "Bad " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
