package Lab3;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


import java.util.Arrays;

public class Task2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //1. У вікні застосунку за допомогою прямокутників різного кольору
    //намалювати стовпчасту діаграму, яка відображає доходи фірми за
    //чотири квартали. Додати написи з числовим значенням доходу. Напис
    //повинен мати наступні характеристики: розмір 18пт, колір синій,
    //курсив. Обов’язково зобразити осі координат. Зверху посередині
    //додати назву діаграми (характеристики напису обрати самостійно).
    @Override
    public void start(Stage primaryStage) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>
            observableArrayList(Arrays.asList("Q1","Q2","Q3","Q4")));
        xAxis.setLabel("Quarter");
        xAxis.tickLabelFontProperty().set(Font.font("Monospace",FontPosture.ITALIC,18));
        xAxis.setTickLabelFill(Color.BLUE);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Money earned");
        yAxis.tickLabelFontProperty().set(Font.font("Monospace", FontPosture.ITALIC,18));
        yAxis.setTickLabelFill(Color.BLUE);

        BarChart<String, Number> newChart = new BarChart<>(xAxis, yAxis);
        newChart.setTitle("Company income 2021-2022");
        newChart.setStyle("-fx-font-size: " + 18 + "px;");

        XYChart.Series<String, Number> year2021 = new XYChart.Series<>();
        year2021.setName("Income for 2021");
        year2021.getData().add(new XYChart.Data<>("Q1", 2000));
        year2021.getData().add(new XYChart.Data<>("Q2", 3200));
        year2021.getData().add(new XYChart.Data<>("Q3", 1800));
        year2021.getData().add(new XYChart.Data<>("Q4", 4100));

        XYChart.Series<String, Number> year2022 = new XYChart.Series<>();
        year2022.setName("Income for 2022");
        year2022.getData().add(new XYChart.Data<>("Q1", 3500));
        year2022.getData().add(new XYChart.Data<>("Q2", 2000));
        year2022.getData().add(new XYChart.Data<>("Q3", 1300));
        year2022.getData().add(new XYChart.Data<>("Q4", 5300));


        newChart.getData().addAll(year2021, year2022);

        Group root = new Group(newChart);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Nikitenko-pp-41");
        primaryStage.show();
    }
}
