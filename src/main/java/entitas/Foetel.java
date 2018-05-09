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
 * Az adatbazisban egy foetelt reprezentalo osztaly.
 */
@Entity
public class Foetel {

    /**
     * Alapertelmezett azonosito.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * A foetel neve.
     */
    private String nev;

    /**
     * A foetel ara.
     */
    private int ar;

    /**
     * Visszadja a foetel id-jat.
     * @return a foetel id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Beillitja a foetel id-jat.
     * @param id a beallitando foetel id-ja
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja a foetel nevet.
     * @param nev a beallitando foetel nevet
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja a foetel nevet.
     * @return a foetel neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Visszaadja a foetel arat.
     * @return a foetel ?ara
     */
    public int getAr() {
        return ar;
    }

    /**
     * Beallitja a foetel arat.
     * @param ar a beallitando foetel ara
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * Ures konstruktor.
     */
    public Foetel() {
    }
}
