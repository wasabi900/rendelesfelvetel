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


public class MunkatarsFelvKontroller {

    public DAO dao;
    @FXML
    public Button vissza;

    @FXML
    public Button mentes;

    @FXML
    public TextField nev;

    @FXML
    public TextField jelszo;

    @FXML
    public Label regisztracioKimenetel;

    public Rendeles rendeles;

    private Logger logger = LoggerFactory.getLogger(MunkatarsFelvKontroller.class);

    public void vissza() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Start.fxml"));
        Parent root = (Parent) loader.load();
        StartKontroller kont = loader.getController();
        kont.dao = dao;
        Scene s = new Scene(root);
        Stage st = (Stage) (vissza.getScene().getWindow());
        st.setTitle("Udvozollek");
        st.setScene(s);
        st.show();
    }

    @FXML
    public void mentes() throws IOException {
        System.out.println(nev.getText());
        System.out.println(jelszo.getText());
        if(dao.ujMunkatars(nev.getText(), jelszo.getText())) {
            regisztracioKimenetel.setText("Uj munkatars felvetele sikeres volt!");
            logger.info("Uj munkatars felvetele sikeres volt!");
        }
        else
            regisztracioKimenetel.setText("Munkatars felvetele sikertelen!");
            logger.error("Munkatars felvetele sikertelen!");
    }

}
