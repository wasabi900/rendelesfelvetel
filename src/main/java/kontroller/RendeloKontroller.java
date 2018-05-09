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

import entitas.Rendeles;
import entitas.Rendelo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class RendeloKontroller {

    public  DAO dao;

    @FXML
    public TextField telefon;

    @FXML
    public TextField nev;

    @FXML
    public TextField cim;

    @FXML TextField kedvezmeny;

    @FXML
    public Button mentes;

    @FXML
    public Button vissza;

    public Rendeles rendeles;

    private Logger logger = LoggerFactory.getLogger(RendeloKontroller.class);

    @FXML
    public void rendelesZaras() throws IOException {

        rendeles.rendelo = dao.ujRendelo(telefon.getText(),nev.getText(),cim.getText());
        rendeles.setKedvezmeny(kedvezmeny.getText());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Blokk.fxml"));
        Parent root = (Parent) loader.load();
        BlokkKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st=(Stage) (mentes.getScene().getWindow());
        st.setTitle("Rendeles zarasa");
        st.setScene(s);
        st.show();
    }

    @FXML
    public void keres() {
        Rendelo rendelo = dao.keresRendelo(telefon.getText());
        if(rendelo != null) {
            nev.setText(rendelo.getNev());
            cim.setText(rendelo.getCim());
        } else
            logger.info("Nem letezik ilyen telefonszammal entitas.");
    }

    @FXML
    public void vissza() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/KajaLista.fxml"));
        Parent root = (Parent) loader.load();
        KajaListaKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st = (Stage) (vissza.getScene().getWindow());
        st.setTitle("Arucsoport");
        st.setScene(s);
        st.show();
    }

}
