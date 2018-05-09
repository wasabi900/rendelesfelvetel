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

/**
 * A rendelheto teteleket reprezentalo osztaly.
 */
public class Tetel {

    /**
     * A tetel neve.
     */
    public String nev;

    /**
     * A tetel ara.
     */
    public int ar;

    /**
     * A tetel mennyisege.
     */
    public int mennyiseg;

    /**
     * Visszaadja a tetel nevet,arat es mennyiseget.
     * @param nev a tetel neve
     * @param ar a tetel ara
     * @param mennyiseg a tetel mennyisege
     */
    public Tetel(String nev, int ar, int mennyiseg) {
        this.nev = nev;
        this.ar = ar;
        this.mennyiseg = mennyiseg;
    }
}
