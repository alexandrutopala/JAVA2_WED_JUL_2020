package main;

import db.Depozit;

import javax.persistence.Cache;
import javax.persistence.Persistence;

public class Exemplu8 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em1 = emf.createEntityManager();
        var em2 = emf.createEntityManager();

        Cache cache = emf.getCache();

        System.out.println(cache.contains(Depozit.class, 452));

        em1.find(Depozit.class, 452);

        System.out.println(cache.contains(Depozit.class, 452));

        em2.find(Depozit.class, 452);

        cache.evict(Depozit.class); // sterge cache-urile stocate pentru toate entitatile
                                    // de tip de Depozit sau care mostenesc clasa Depozit

        em2.find(Depozit.class, 452);

        cache.evict(Depozit.class, 452); // sterge doar inregistrarea din cache a entitatii
                                            // Depozit cu id-ul 452

        cache.evictAll();
    }
}
