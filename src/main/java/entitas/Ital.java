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
 * Az adatbazisban egy italt reprezentalo osztaly.
 */
@Entity
public class Ital {

    /**
     * Alapertelmezett id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * Az ital neve.
     */
    private String nev;

    /**
     * Az ital ara.
     */
    private int ar;

    /**
     * Visszaadja az ital id-jat.
     * @return az ital id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Beallitja az ital id-jat.
     * @param id a beallitando ital id-ja.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja az ital nevet.
     * @param nev a beallitando ital neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaajda az ital nevet.
     * @return az ital neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Visszaajda az ital arat.
     * @return az ital ara
     */
    public int getAr() {
        return ar;
    }

    /**
     * Beallitja az ital arat.
     * @param ar a beallitando ital ara
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * Ures konstruktor.
     */
    public Ital() {
    }
}
