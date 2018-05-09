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

import entitas.Munkatars;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class StartKontroller {

    public DAO dao;

    @FXML
    public Button eladas;
    @FXML
    public Button munkatarsfelv;

    @FXML
    public TextField nev;

    @FXML
    public Label hibasFelhJelsz;

    @FXML
    public TextField jelszo;

    private Logger logger = LoggerFactory.getLogger(StartKontroller.class);

    @FXML
    private void tovabbKajakhoz() throws IOException {
        Munkatars munkatars = dao.bejelentkeztetMunkatars(nev.getText(),jelszo.getText());
        if(munkatars == null) {
            hibasFelhJelsz.setText("Hibas felhasznalonev, vagy jelszo!");
            logger.error("Hibas felhasznalonev, vagy jelszo!");
            return;
        }
        logger.info("Sikeres bejelentkezes!");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/KajaLista.fxml"));
        Parent root = (Parent) loader.load();
        KajaListaKontroller kont = loader.getController();
        kont.dao = dao;
        kont.munkatars = munkatars;
        Scene s = new Scene(root);
        Stage st=(Stage) (eladas.getScene().getWindow());
        st.setTitle("Arucsoport");
        st.setScene(s);
        st.show();
    }

    @FXML
    private void munkatarsfelv() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/MunkatarsFelv.fxml"));
        Parent root = (Parent)loader.load();
        Scene s = new Scene(root);
        MunkatarsFelvKontroller kont = loader.getController();
        kont.dao = dao;
        Stage st=(Stage) (munkatarsfelv.getScene().getWindow());
        st.setTitle("Udvozlunk kedves Uj Munkatars");
        st.setScene(s);
        st.show();
    }
}
