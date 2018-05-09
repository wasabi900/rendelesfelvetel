package entitas;

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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Az adatbazisban egy desszertet reprezentalo osztaly.
 */
@Entity
public class Desszert {

    /**
     * Alapertelmezett azonosito.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * A desszert neve.
     */
    private String nev;

    /**
     * A desszert ara.
     */
    private int ar;

    /**
     * Visszaadja a desszert id-jat.
     * @return a desszert id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Beallitja a desszert id-jat.
     * @param id a beallitando id-ja
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja a desszert nevet.
     * @param nev a beallitando desszert neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a desszert nevet.
     * @return a desszert neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Visszaadja a desszert arat.
     * @return a desszert ara
     */
    public int getAr() {
        return ar;
    }

    /**
     * Beallitja a desszert arat.
     * @param ar a beallitando desszert ara
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * Ures konstruktor.
     */
    public Desszert() {
    }
}
