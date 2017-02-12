package mohale.pos.model;

import io.realm.RealmObject;

/**
 * Created by user on 2/12/2017.
 */
public class Product extends RealmObject {

    private String name;
    private int price;
    private int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
