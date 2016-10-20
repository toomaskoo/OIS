import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

//pohiliides
public class main extends Application {



    public static void createNewDatabase(String fileName) {
        fileName = new String("OIS.db");
        String url = "jdbc:sqlite:/home/Projects/OIS/db/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ÕLLEINFOSÜSTEEM");


        Button ostaButton = new Button("OSTA ÕLUT");
        Button inimButton = new Button("LISA INIMESI");
        Button laduButton = new Button("LADU (VALVE / MAJAVANEM)");

        HBox menyy = new HBox(0);
        menyy.getChildren().addAll(ostaButton, inimButton, laduButton);
        menyy.setAlignment(Pos.TOP_LEFT);

        StackPane oisMain = new StackPane();
        oisMain.getChildren().addAll(menyy);
        Scene mainScene = new Scene(oisMain, 1024, 768);



        Inimene vend = null;
        ladu olled = null;



        primaryStage.setScene(mainScene);
        ostaButton.setOnAction(event -> primaryStage.setScene(mainScene));
        inimButton.setOnAction(event -> primaryStage.setScene(vend.inimScene));
        laduButton.setOnAction(event -> primaryStage.setScene(olled.olledesisestamine));
        primaryStage.show();

    }
}
