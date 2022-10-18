package Lab3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Task1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //1. У вікні застосунку розмістити три фігури: круг червоного кольору,
    //квадрат синього кольору, прямокутну трапецію зеленого кольору.
    //Створити напис біля кожної фігури, який містить інформацію про її
    //назву та колір. Напис повинен мати наступні характеристики: розмір
    //16пт, колір темно-сірий, напівжирний. В правому нижньому кутку
    //додати інформацію про розробника програми
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Task 1 Laba 3");
        Group root = new Group();
        Scene scene = new Scene(root, 700, 500, Color.AZURE);
        primaryStage.setScene(scene);
        primaryStage.show();

        ///CIRCLE
        Ellipse circle = new Ellipse(100, 100, 80, 80); //x-center y-center x-radius y-radius
        circle.setFill(Color.RED);
        root.getChildren().addAll(circle);
        ///LABEL1
        Text label1 = new Text();
        label1.setX(40);
        label1.setY(200);
        label1.setFont(Font.font("SansSerif", FontWeight.BOLD, 16));
        label1.setFill(Color.DARKGRAY);
        label1.setText("ЧЕРВОНИЙ КРУГ");
        root.getChildren().add(label1);
        ///SQUARE
        Rectangle square = new Rectangle(50, 300, 150, 150);//x y width height
        square.setFill(Color.BLUE);
        root.getChildren().addAll(square);
        ///LABEL2
        Text label2 = new Text();
        label2.setX(60);
        label2.setY(480);
        label2.setFont(Font.font("SansSerif", FontWeight.BOLD, 16));
        label2.setFill(Color.DARKGRAY);
        label2.setText("СИНІЙ КВАДРАТ");
        root.getChildren().add(label2);
        ///TRAPEZOID
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            400.0, 100.0,
            500.0, 100.0,
            600.0, 200.0,
            400.0, 200.0
        });
        polygon.setFill(Color.GREEN);
        root.getChildren().add(polygon);
        ///LABEL3
        Text label3 = new Text();
        label3.setX(400);
        label3.setY(220);
        label3.setFont(Font.font("SansSerif", FontWeight.BOLD, 16));
        label3.setFill(Color.DARKGRAY);
        label3.setText("ПРЯМОКУТНА ТРАПЕЦІЯ");
        root.getChildren().add(label3);
        ///LABEL4
        Text label4 = new Text();
        label4.setX(500);
        label4.setY(480);
        label4.setFont(Font.font("SansSerif", FontWeight.BOLD, 16));
        label4.setFill(Color.DARKGRAY);
        label4.setText("Нікітенко пп-41");
        root.getChildren().add(label4);
    }

}
