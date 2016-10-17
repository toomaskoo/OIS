import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

//pohiliides
public class main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ÕLLEINFOSÜSTEEM");

        Button ostaButton = new Button("OSTA");
        Button inimButton = new Button("LISA INIMESI");
        Button laduButton = new Button("LADU");

        HBox menyy = new HBox(0, ostaButton, inimButton, laduButton);
        menyy.setAlignment(Pos.TOP_CENTER);

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
