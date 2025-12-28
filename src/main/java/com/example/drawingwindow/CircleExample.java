package com.example.drawingwindow;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Random;

public class CircleExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {

            Pane root = new Pane();
            root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        Circle circle = new Circle(5);
                        randomColor(circle);
                        circle.setCenterX(mouseEvent.getX());
                        circle.setCenterY(mouseEvent.getY());
                        root.getChildren().addAll(circle);
                    }else if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
                        root.getChildren().removeAll((Node) mouseEvent.getTarget());
                    }
                /*
                circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                            root.getChildren().removeAll(circle);
                        }
                    }
                });*/
                }
            });

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Kreis Zeichnen");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void randomColor(Shape s){
        Random random = new Random();
        Color c = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        s.setFill(c);
    }
}
