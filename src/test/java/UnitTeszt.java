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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnitTeszt {

    @Test
    public void tesztSetKedvezmeny() {
        Rendeles rendeles = new Rendeles();

        rendeles.setKedvezmeny(10);
        Assert.assertEquals(10, rendeles.kedvezmeny);

        rendeles.setKedvezmeny(150);
        Assert.assertEquals(100, rendeles.kedvezmeny);

        rendeles.setKedvezmeny(-5);
        Assert.assertEquals(0, rendeles.kedvezmeny);


        rendeles.setKedvezmeny("25");
        Assert.assertEquals(25, rendeles.kedvezmeny);

        rendeles.setKedvezmeny("150");
        Assert.assertEquals(100, rendeles.kedvezmeny);

        rendeles.setKedvezmeny("-5");
        Assert.assertEquals(0, rendeles.kedvezmeny);
    }
    @Test
    public void tesztHozzaadTetelEloetel(){
        Rendeles rendeles = new Rendeles();
        Eloetel eloetel = new Eloetel();
        eloetel.setNev("Tat?r beef steak");
        eloetel.setAr(1690);

        rendeles.hozzaadTetel(eloetel);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(1, rendeles.lista.get(0).mennyiseg);

        rendeles.hozzaadTetel(eloetel);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(2, rendeles.lista.get(0).mennyiseg);
    }

    @Test
    public void tesztHozzaadTetelFoetel(){
        Rendeles rendeles = new Rendeles();
        Foetel foetel = new Foetel();
        foetel.setNev("Fokhagym?s csirke");
        foetel.setAr(1790);

        rendeles.hozzaadTetel(foetel);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(1, rendeles.lista.get(0).mennyiseg);

        rendeles.hozzaadTetel(foetel);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(2, rendeles.lista.get(0).mennyiseg);
    }

    @Test
    public void tesztHozzaadTetelDesszert(){
        Rendeles rendeles = new Rendeles();
        Desszert desszert = new Desszert();
        desszert.setNev("Churros");
        desszert.setAr(690);

        rendeles.hozzaadTetel(desszert);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(1, rendeles.lista.get(0).mennyiseg);

        rendeles.hozzaadTetel(desszert);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(2, rendeles.lista.get(0).mennyiseg);
    }

    @Test
    public void tesztHozzaadTetelItal(){
        Rendeles rendeles = new Rendeles();
        Ital ital = new Ital();
        ital.setNev("Pepsi (0.33)");
        ital.setAr(150);

        rendeles.hozzaadTetel(ital);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(1, rendeles.lista.get(0).mennyiseg);

        rendeles.hozzaadTetel(ital);
        Assert.assertEquals(1, rendeles.lista.size());
        Assert.assertEquals(2, rendeles.lista.get(0).mennyiseg);
    }

    @Test
    public void tesztGetOsszeg() {
        Rendeles rendeles = new Rendeles();
        Foetel foetel = new Foetel();
        foetel.setNev("Fokhagym?s csirke");
        foetel.setAr(1790);
        rendeles.hozzaadTetel(foetel);
        Assert.assertEquals(1790, rendeles.getOsszeg());

        rendeles.setKedvezmeny(10);
        Assert.assertEquals(1790-179, rendeles.getOsszeg());

        rendeles.setKedvezmeny(100);
        Assert.assertEquals(0, rendeles.getOsszeg());

    }

    @Test
    public void tesztGetOsszegMennyiseggel(){

        Rendeles rendeles = new Rendeles();
        Foetel foetel = new Foetel();
        foetel.setNev("Fokhagym?s csirke");
        foetel.setAr(1790);
        rendeles.hozzaadTetel(foetel);
        rendeles.hozzaadTetel(foetel);
        rendeles.setKedvezmeny(0);
        Assert.assertEquals(2*1790, rendeles.getOsszeg());

        rendeles.setKedvezmeny(10);
        Assert.assertEquals(2*(1790-179), rendeles.getOsszeg());

        rendeles.setKedvezmeny(100);
        Assert.assertEquals(0, rendeles.getOsszeg());
    }
}
