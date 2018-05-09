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
 * Az adatbazisban egy munkatarsat reprezentalo osztaly.
 */
@Entity
public class Munkatars {

    /**
     * Alapertelmezett id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * A munkatars jelszava.
     */
    private String jelszo;

    /**
     * A munkatars neve.
     */
    private String nev;

    /**
     * Visszaadja a munkatars jelszavat.
     * @return a munkatars jelszava
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Beallitja a munkatars jelszavat.
     * @param jelszo a beallitando munkatars jelszava
     */
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    /**
     * Visszaajda a munkatars nevet.
     * @return a munkatars neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Beallitja a munkatars nevet.
     * @param nev a beallitando munkatars neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Ures konstruktor.
     */
    public Munkatars(){

    }
}
