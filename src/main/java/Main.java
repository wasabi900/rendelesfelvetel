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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kontroller.DAO;
import kontroller.StartKontroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main osztaly ami inicializalja a JavaFX alkalmazast es a feluleteket.
 *
 * @author Bene Miklos
 */
public class Main extends Application {

    /**
     * Logger a logolashoz.
     */
    private Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Adatbaziskezelohoz valtozo.
     */
    public DAO dao;

    /**
     * Az alkalmazas inditasi metodusa.
     * Betolti a kezdolapot es az adatbazist.
     * @param stage az alap felulet
     * @throws Exception akkor ha valami hiba lep fel a felhasznaloi felulet betoltese kozben
     */
    public void start(Stage stage)throws Exception {
        dao = new DAO();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Start.fxml"));
        Parent root = (Parent) loader.load();
        StartKontroller kont = loader.getController();
        kont.dao = dao;
        Scene s = new Scene(root);
        stage.setTitle("Kezdolap");
        stage.setScene(s);
        stage.show();
        logger.debug("Alkalmazas inditasa");

    }

    /**
     * A program leallitasakor meghivodo metodus.
     * Lezarja az adatbaziskapcsolatot.
     */
    @Override
    public void stop() {
        dao.close();
        logger.debug("Az alkalmazas bezart");
    }

    /**
     * Main metodus, ami elinditja az egesz programot.
     * @param args Parancssori argumentumok.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
