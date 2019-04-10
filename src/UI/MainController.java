package UI;

import Domain.Eveniment;
import Domain.ValidatorException;
import Service.EvenimentService;
//import Service.ClientService;
//import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    public TableView tblEvents;
    public TableColumn colIdEvent;
    public TableColumn colNameEvent;
    public TableColumn colEventDate;
    public TableColumn colEventDuration;
    public TableColumn colEventStartingTime;
    //    public TableColumn colSugarFreeCake;
    public TextField txtEventID;
//    public CheckBox chkSugarFree;
    public TextField txtEventName;
    public TextField txtEventDate;
    public TextField txtEventDuration;
    public TextField txtEventStartingTime;
    public Button btnAddEvent;

    private EvenimentService evenimentService;
    private ObservableList<Eveniment> eveniments = FXCollections.observableArrayList();

    public void setServices(EvenimentService evenimentService) {
        this.evenimentService = evenimentService;

    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            eveniments.addAll(evenimentService.getAll());
            tblEvents.setItems(eveniments);
        });
    }

    public void btnAddEvent(ActionEvent actionEvent) {
        try {
            String id = txtEventID.getText();
            String name = txtEventName.getText();
            String date = txtEventDate.getText();
            String duration = txtEventDuration.getText();
            String startingTime = txtEventStartingTime.getText();

            evenimentService.addOrUpdate(id, name, date, duration, startingTime);

            eveniments.clear();
            eveniments.addAll(evenimentService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }
}
