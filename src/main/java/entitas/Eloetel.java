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
 * Az adatbazisban egy eleotelt reprezentalo osztaly.
 */
@Entity
public class Eloetel {

    /**
     * Alapertelmezett azonosito.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * Az elotetel neve.
     */
    private String nev;

    /**
     * Az eloetel ara.
     */
    private int ar;

    /**
     * Visszaadja az eloetel id-jat.
     * @return az eloetel id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Beallitja az eloetel id-jat.
     * @param id a beallitando eloetel id-ja
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja az eloetel nevet.
     * @param nev a beallitando eloetel neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja az eleotel nevet.
     * @return az eloetel neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Visszaadja az eloetel arat.
     * @return az eloetel ara
     */
    public int getAr() {
        return ar;
    }

    /**
     * Beallitja az eloetel arat.
     * @param ar a beillatando eloetel ara
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * Ures konstruktor.
     */
    public Eloetel() {
    }
}
