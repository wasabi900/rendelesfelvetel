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
 * Az adatbazisban egy rendelot reprezentalo osztaly.
 */
@Entity
public class Rendelo {

    /**
     * Alapertelmezett id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;

    /**
     * Rendelo neve.
     */
    private String nev;

    /**
     * Rendelo telefonszama.
     */
    private String telefon;

    /**
     * Rendelo cime.
     */
    private String cim;

    /**
     * Visszaadja a rendelo id-jat.
     * @return a rendelo id-ja
     */
    public int getId() {
        return id;
    }

    /**
     * Beallitja a rendelo id-jat.
     * @param id a beallitando rendelo id-ja
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Visszaadja a rendelo nevet.
     * @return a rendelo neve
     */
    public String getNev() {
        return nev;
    }

    /**
     * Beallitja a rendelo nevet.
     * @param nev a beallitando rendelo neve
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * Visszaadja rendelo telefonszamat.
     * @return a rendelo telefonszama
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Beallitja a rendelo telefonszamat.
     * @param telefon a beallitando rendelo telefonszama
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * visszaadja a rendelo cimet.
     * @return a rendelo cime
     */
    public String getCim() {
        return cim;
    }

    /**
     * Beallitja a rendelo cimet.
     * @param cim a beillatando rendelo cime.
     */
    public void setCim(String cim) {
        this.cim = cim;
    }

    /**
     * Ures konstruktor.
     */
    public Rendelo(){
    }
}
