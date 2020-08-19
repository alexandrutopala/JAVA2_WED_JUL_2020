package db;

import javax.persistence.Entity;

@Entity
public class Pisica extends Animal {

    private int vieti;

    public int getVieti() {
        return vieti;
    }

    public void setVieti(int vieti) {
        this.vieti = vieti;
    }
}
