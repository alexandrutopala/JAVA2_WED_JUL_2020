package db;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Magazin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Valoarea mapului va fi emailul de contact ce formeaza element collection-ul
    // iar cheia va fi informatia aditionala asociata fiecarui email (in cazul nostru,
    // numele persoanei de contact cu emailul respectiv)
    @ElementCollection
    private Map<String, String> emails = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getEmails() {
        return emails;
    }

    public void setEmails(Map<String, String> emails) {
        this.emails = emails;
    }
}
