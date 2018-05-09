package kontroller;

/*-
 * #%L
 * order-making
 * %%
 * Copyright (C) 2018 Debreceni Egyetem
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * #L%
 */

import entitas.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Az adatbazissal kommunikalo osztaly.
 */
public class DAO {

    /**
     * Adatbaziskapcsolat letrehozasahoz szukseges valtozo.
     */
    EntityManagerFactory entityManagerFactory;

    /**
     *Adatbaziskapcsolat letrehozasahoz szukseges valtozo.
     */
    EntityManager entityManager;


    /**
     * Logger a loggolashoz.
     */
    private Logger logger = LoggerFactory.getLogger(DAO.class);

    /**
     *Adatbaziskapcsolatot letrehozo konstruktor.
     */
    public  DAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("RendelesUnit");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    /**
     * Visszaadja az adott nevu munkatarsat megkeresi az adatbazisban.
     * Ha nincs benne null-al ter vissza.
     * @param nev a munkatars neve
     * @return a megtalalt munkatars, ha nem letezik akkor null
     */
    public Munkatars keresMunkatars(String nev){
        return osszesMunkatars().stream()
                .filter(p->p.getNev().equals(nev))
                .findFirst()
                .orElse(null);
    }

    /**
     * Visszaadja az adott telefonszammal rendelo rendelot megkeresi az adatbazisban.
     * Ha nincs benne null-al ter vissza.
     * @param telefon a rendelo telefonszama
     * @return a megtalalt rendelo, ha nem letezik akkor null
     */
    public Rendelo keresRendelo(String telefon) {
        return osszesRendelo().stream()
                .filter(r -> r.getTelefon().equals(telefon))
                .findFirst()
                .orElse(null);
    }

    /**
     * Megkeresi az adatbazisban, hogy helyesek-e a megadott bejelentkezesi adatok.
     * Ha nem egyezik akkor null-al ter vissza.
     * @param nev a munkatars neve
     * @param jelszo a munkatars jelszava
     * @return a megtalalt munkatars neve es telefonszama, ha nem letezik akkor null
     */
    public Munkatars bejelentkeztetMunkatars(String nev, String jelszo){
        return osszesMunkatars().stream()
                .filter(p->p.getNev().equals(nev) && p.getJelszo().equals(jelszo))
                .findFirst()
                .orElse(null);
    }

    /**
     * Visszaadja az adatbazisban szereplo eloetelt.
     * Ha nincs benne null-al ter vissza.
     * @param nev a eloetel neve
     * @return a eloetel neve
     */
    public Eloetel keresEloetel(String nev) {
        return osszesEloetel().stream()
                .filter(p->p.getNev().equals(nev))
                .findFirst()
                .orElse(null);
    }

    /**
     * Visszaadja az adatbazisban szereplo foetelt.
     * Ha nincs benne null-al ter vissza.
     * @param nev a foetel neve
     * @return a foetel neve
     */
    public Foetel keresFoetel(String nev) {
        return osszesFoetel().stream()
                .filter(p->p.getNev().equals(nev))
                .findFirst()
                .orElse(null);
    }

    /**
     * Visszaadja az adatbazisban szereplo desszertet.
     * Ha nincs benne null-al ter vissza.
     * @param nev a desszert neve
     * @return a desszert neve
     */
    public Desszert keresDesszert(String nev) {
        return osszesDesszert().stream()
                .filter(p->p.getNev().equals(nev))
                .findFirst()
                .orElse(null);
    }

    /**
     * Visszaadja az adatbazisban szereplo italt.
     * Ha nincs benne null-al ter vissza.
     * @param nev a ital neve
     * @return a ital neve
     */
    public Ital keresItal(String nev) {
        return osszesItal().stream()
                .filter(p->p.getNev().equals(nev))
                .findFirst()
                .orElse(null);
    }

    /**
     * Uj munkatars felvetele az adatbazisba.
     * @param nev a munkatars neve
     * @param jelszo a munkatars jelszavaa
     * @return {@code true} ha a munkatars meg nincsen benne az adatbazisban {@code false} ha a munkatars mar szerepel az adatbazisban
     */
    public boolean ujMunkatars(String nev, String jelszo) {

        if(keresMunkatars(nev)!=null) {
            logger.error("Munkatars mar szerepel az adatbazisban!");
            return false;
        }
        entityManager.getTransaction().begin();
        Munkatars m = new Munkatars();
        m.setNev(nev);
        m.setJelszo(jelszo);
        entityManager.persist(m);
        entityManager.getTransaction().commit();
        return true;
    }

    /**
     * Uj rendelo felvetele az adatbazisba.
     * Ha mar rendelt az adott telefonszamon akkor visszaadja a rendelo adatait,
     * Egyebkent felveszi az adatbazibsa.
     * @param telefon a rendelo telefonszama
     * @param nev a rendelo neve
     * @param cim a rendelo cime
     * @return a rendelo peldanya
     */
    public Rendelo ujRendelo(String telefon, String nev, String cim) {
        Rendelo rendelo = keresRendelo(telefon);
        if(rendelo!=null) {
            logger.info("A rendelo mar rendelt ezelott ugyanezzen a telefonszamon");
            return rendelo;
        }
        entityManager.getTransaction().begin();
        rendelo = new Rendelo();
        rendelo.setNev(nev);
        rendelo.setTelefon(telefon);
        rendelo.setCim(cim);
        entityManager.persist(rendelo);
        entityManager.getTransaction().commit();
        return rendelo;
    }

    /**
     * Lekerdezi az osszes eloetelt az adatbazisbol.
     * @return lista a eloetelekkel
     */
    public List<Eloetel> osszesEloetel() {
        TypedQuery<Eloetel> query = entityManager.createQuery("select f from entitas.Eloetel f ", Eloetel.class);
        return query.getResultList();
    }

    /**
     * Lekerdezi az osszes foetelt az adatbazisbol.
     * @return lista a foetelekkel
     */
    public List<Foetel> osszesFoetel() {
        TypedQuery<Foetel> query = entityManager.createQuery("select f from entitas.Foetel f ", Foetel.class);
        return query.getResultList();
    }

    /**
     * Lekerdezi az osszes desszertet az adatbazisbol.
     * @return lista a desszertekkel
     */
    public List<Desszert> osszesDesszert() {
        TypedQuery<Desszert> query = entityManager.createQuery("select f from entitas.Desszert f ", Desszert.class);
        return query.getResultList();
    }

    /**
     * Lekerdezi az osszes italt az adatbazisbol.
     * @return lista a italokkal
     */
    public List<Ital> osszesItal() {
        TypedQuery<Ital> query = entityManager.createQuery("select f from entitas.Ital f ", Ital.class);
        return query.getResultList();
    }

    /**
     * Lekerdezi az osszes munkatarsat az adatbazisbol.
     * @return lista a munkatarsakkal
     */
    public List<Munkatars> osszesMunkatars() {
        TypedQuery<Munkatars> query = entityManager.createQuery("select f from entitas.Munkatars f ", Munkatars.class);
        return query.getResultList();
    }

    /**
     * Lekerdezi az osszes rendelot az adatbazisbol.
     * @return lista a rendelokkel
     */
    public List<Rendelo> osszesRendelo() {
        TypedQuery<Rendelo> query = entityManager.createQuery("select f from entitas.Rendelo f ",Rendelo.class);
        return query.getResultList();
    }

    /**
     * Bezarja az adatbazissal a kapcsolatot.
     */
    public void close() {
        if(entityManagerFactory != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
