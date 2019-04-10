import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.EvenimentService;
//import Service.ClientService;
//import Service.TransactionService;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Eveniment> evenimentValidator = new EvenimentValidator();
//        IValidator<Client> clientValidator = new ClientValidator();
//        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Eveniment> evenimentRepository = new InMemoryRepository<>(evenimentValidator);
//        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
//        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        EvenimentService evenimentService = new EvenimentService(evenimentRepository);
        evenimentService.addOrUpdate("1", "eveniment 1", "10.10.2018", "100", "100");
        evenimentService.addOrUpdate("2", "eveniment 2", "11.10.2018", "200", "10");
        evenimentService.addOrUpdate("3", "eveniment 3", "12.10.2018", "300", "1");

//        ClientService clientService = new ClientService(clientRepository);
//        TransactionService transactionService = new TransactionService(transactionRepository, evenimentRepository);

        MainController mainController =  fxmlLoader.getController();
        mainController.setServices(evenimentService);

        primaryStage.setTitle("Time manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}


