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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Egy rendelest reprezentalo osztaly.
 */
public class Rendeles {

    /**
     * Logger a logolashoz.
     */
    private Logger logger = LoggerFactory.getLogger(Rendeles.class);

    /**
     * Munkatars aki felveszi a rendelest.
     */
    public Munkatars munkatars;

    /**
     * A rendelest leado szemely.
     */
    public Rendelo rendelo;


    /**
     * A rendelesbol szarmazo kedvezmeny.
     */
    public int kedvezmeny=0;

    /**
     * A rendelheto tetelek listaja.
     */
    public ObservableList<Tetel> lista;

    /**
     * Beallitja a kedvezmenyt.
     * @param kedvezmeny a beallitando kedvezmeny egesz tipuskent
     */
    public void setKedvezmeny(int kedvezmeny) {
        if(kedvezmeny > 100)
            kedvezmeny = 100;
        if(kedvezmeny < 0)
            kedvezmeny = 0;
        this.kedvezmeny = kedvezmeny;
    }

    /**
     * Beallitja a kedvezmenyt.
     * @param kedvezmeny a beallitando kedvezmeny String tipuskent
     */
    public void setKedvezmeny(String kedvezmeny) {
        try{
            int kedv = Integer.parseInt(kedvezmeny);
            setKedvezmeny(kedv);
        } catch (NumberFormatException ex) {
            logger.warn("A megadott kedvezmeny nem szam!");
        }
    }

    /**
     * Metodus ami begyujti listaba a rendelesre eddig leadott teteleket.
     */
    public Rendeles(){
        lista = FXCollections.observableArrayList();
    }


    /**
     * Metodus ami hozzaad a rendeleshez egy eloetelt.
     * Ha a tetel mar szerepel a listaban akkor noveli a mennyiseget,
     * egyebkent hozzaadja a listahoz.
     * @param eloetel a hozzaadni kivant eloetel
     */
    public void hozzaadTetel(Eloetel eloetel) {
        Tetel tetel = lista.stream().filter(p -> p.nev.equals(eloetel.getNev())).findFirst().orElse(null);
        if(tetel == null) {
            tetel = new Tetel(eloetel.getNev(), eloetel.getAr(), 1);
            lista.add(tetel);
        } else {
            tetel.mennyiseg++;
        }
    }

     /**
     * Metodus ami hozzaad a rendeleshez egy foetelt.
     * Ha a tetel mar szerepel a listaban akkor noveli a mennyiseget,
     * egyebkent hozzaadja a listahoz.
     * @param foetel a hozzaadni kivant foetel
     */
    public void hozzaadTetel(Foetel foetel) {
        Tetel tetel = lista.stream().filter(p -> p.nev.equals(foetel.getNev())).findFirst().orElse(null);
        if(tetel == null) {
            tetel = new Tetel(foetel.getNev(), foetel.getAr(), 1);
            lista.add(tetel);
        } else {
            tetel.mennyiseg++;
        }
    }

    /**
     * Metodus ami hozzaad a rendeleshez egy desszertet.
     * Ha a tetel mar szerepel a listaban akkor noveli a mennyiseget,
     * egyebkent hozzaadja a listahoz.
     * @param desszert a hozzaadni kivant desszert
     */
    public void hozzaadTetel(Desszert desszert) {
        Tetel tetel = lista.stream().filter(p -> p.nev.equals(desszert.getNev())).findFirst().orElse(null);
        if(tetel == null) {
            tetel = new Tetel(desszert.getNev(), desszert.getAr(), 1);
            lista.add(tetel);
        } else {
            tetel.mennyiseg++;
        }
    }

    /**
     * Metodus ami hozzaad a rendeleshez egy italt.
     * Ha a tetel mar szerepel a listaban akkor noveli a mennyiseget,
     * egyebkent hozzaadja a listahoz.
     * @param ital a hozzaadni kivant ital
     */
    public void hozzaadTetel(Ital ital) {
        Tetel tetel = lista.stream().filter(p -> p.nev.equals(ital.getNev())).findFirst().orElse(null);
        if(tetel == null) {
            tetel = new Tetel(ital.getNev(), ital.getAr(), 1);
            lista.add(tetel);
        } else {
            tetel.mennyiseg++;
        }
    }

    /**
     * Visszaadja a rendeles vegosszeget.
     * A visszaadott ertek mar tartalmazza a kedvezemenyt.
     * @return a rendeles vegosszege
     */
    public int getOsszeg() {
        double veglegesKedvezmeny = (100-kedvezmeny)/(double)100;
        return (int)(lista.stream().flatMapToInt(n -> IntStream.of(n.mennyiseg*n.ar)).sum()*veglegesKedvezmeny);
    }
}
