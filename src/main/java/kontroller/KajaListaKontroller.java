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

import entitas.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class KajaListaKontroller {

    public DAO dao;

    public Munkatars munkatars;
    public Rendeles rendeles;

    @FXML
    public Button kilepes;

    @FXML
    public Button eloetelek;
    @FXML
    public Button foetelek;
    @FXML
    public Button desszertek;
    @FXML
    public Button italok;

    @FXML
    public TableView<Tetel> rendelestabla;

    @FXML
    public TableColumn<Tetel, String> kajaneve;
    @FXML
    public TableColumn<Tetel, Integer> kajaara;
    @FXML
    public TableColumn<Tetel, Integer> kajamennyisege;
    @FXML
    public Label vegosszeg;
    @FXML
    public Label valasszKajat;

    @FXML
    public Button kesz;


    private Logger logger = LoggerFactory.getLogger(KajaListaKontroller.class);

    @FXML
    private void vissza() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Start.fxml"));
        Parent root = (Parent) loader.load();
        StartKontroller kont = loader.getController();
        kont.dao = dao;
        Scene s = new Scene(root);
        Stage st=(Stage) (kilepes.getScene().getWindow());
        st.setTitle("Kezdolap");
        st.setScene(s);
        st.show();
    }


    @FXML
    private void rendelesfelv() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Rendelo.fxml"));
        Parent root = (Parent) loader.load();
        RendeloKontroller kont = loader.getController();
        kont.dao = dao;
        kont.rendeles = rendeles;
        if(rendeles.lista.size()==0){
            valasszKajat.setText("Valassz valami kajcsit!");
            return;
        }
        Scene s = new Scene(root);
        Stage st=(Stage) (kesz.getScene().getWindow());
        st.setTitle("Rendelo adatai");
        st.setScene(s);
        st.show();
        logger.info("Tovabb a rendelo adataihoz");
    }

    @FXML
    private void eloetelekhez() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Eloetelek.fxml"));
        Parent root = (Parent) loader.load();
        EloetelekKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st=(Stage) (eloetelek.getScene().getWindow());
        st.setTitle("Eloetelek");
        st.setScene(s);
        st.show();
        logger.info("Tovabb az eloetelekhze");
    }

    @FXML
    private void foetelekhez() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Foetelek.fxml"));
        Parent root = (Parent) loader.load();
        FoetelekKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st=(Stage) (foetelek.getScene().getWindow());
        st.setTitle("Foetelek");
        st.setScene(s);
        st.show();
        logger.info("Tovabb a foetelekhez");
    }

    @FXML
    private void desszertekhez() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Desszertek.fxml"));
        Parent root = (Parent) loader.load();
        DesszertekKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st=(Stage) (desszertek.getScene().getWindow());
        st.setTitle("Desszertek");
        st.setScene(s);
        st.show();
        logger.info("Tovabb a desszertekhez");
    }

    @FXML
    private void italokhoz() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Italok.fxml"));
        Parent root = (Parent) loader.load();
        ItalokKontroller kont = loader.getController();
        kont.dao = dao;
        kont.setRendeles(rendeles);
        Scene s = new Scene(root);
        Stage st=(Stage) (italok.getScene().getWindow());
        st.setTitle("Italok");
        st.setScene(s);
        st.show();
        logger.info("Tovabb az italokhoz");
    }


    public void setRendeles(Rendeles rendeles) {
        this.rendeles = rendeles;
        rendelestabla.setItems(rendeles.lista);
        refresh();
    }

    private void refresh() {
        vegosszeg.setText(rendeles.getOsszeg()+" Ft");
        rendelestabla.refresh();
    }

    @FXML
    public void initialize() {
        rendeles = new Rendeles();
        kajaneve.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nev));
        kajaara.setCellValueFactory(cellData -> new SimpleIntegerProperty(new Integer(cellData.getValue().ar)).asObject());
        kajamennyisege.setCellValueFactory(cellData -> new SimpleIntegerProperty(new Integer(cellData.getValue().mennyiseg)).asObject());

    }

}
