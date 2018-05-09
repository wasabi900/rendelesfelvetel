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
import entitas.Tetel;
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

import java.io.IOException;

public class BlokkKontroller {


    public DAO dao;

    @FXML
    public Label telefon;

    @FXML
    public Label nev;
    @FXML
    public Label cim;

    @FXML
    public Label kedvezmeny;

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
    public Button rendelesZaras;

    public Rendeles rendeles;

    public void vissza() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/KajaLista.fxml"));
        Parent root = (Parent) loader.load();
        KajaListaKontroller kont = loader.getController();
        kont.dao = dao;
        Scene s = new Scene(root);
        Stage st=(Stage) (rendelesZaras.getScene().getWindow());
        st.setTitle("Arucsoport");
        st.setScene(s);
        st.show();
    }


    public void setRendeles(Rendeles rendeles) {
        this.rendeles = rendeles;
        rendelestabla.setItems(rendeles.lista);
        refresh();
    }

    private void refresh() {
        vegosszeg.setText(rendeles.getOsszeg()+" Ft");
        kedvezmeny.setText(rendeles.kedvezmeny+" %");
        telefon.setText(rendeles.rendelo.getTelefon());
        nev.setText(rendeles.rendelo.getNev());
        cim.setText(rendeles.rendelo.getCim());
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
