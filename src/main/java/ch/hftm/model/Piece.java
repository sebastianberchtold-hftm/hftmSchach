package ch.hftm.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import ch.hftm.Square;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class Piece extends ImageView implements Serializable {
    protected EColorPiece color;
    public String type;
    public int x;
    public int y;
    ArrayList<String> possibleMoves;

    //Constructor
    public Piece(EColorPiece color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        addEventHandler();
    }

    //Getter and Setter
    public void setPiece(Image image) {
        this.setImage(image);
    }

    public void setImage() {
        String imagePath = "/pieces/" + this.color + this.type + ".png";
        Class<? extends Piece> obj = getClass();
        InputStream inputStream = obj.getResourceAsStream(imagePath);
        // InputStream inputStream = getClass().getResourceAsStream(imagePath);

        try {
            if (inputStream != null) {
                this.setPiece(new Image(inputStream));
            } else {
                System.out.println("Image could not be loaded:" + imagePath);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid image path: " + imagePath);
        }
    }

    public EColorPiece getColor() {
        return color;
    }

    public void setColorPiece(EColorPiece color) {
        this.color = color;
    }

    public int getPieceX() {
        return x;
    }

    public int getPieceY() {
        return y;
    }

    public Square getSquareByName(String name) {

        // TODO: Richtig implementieren
        /*
         * for (Square square : GameController) {
         * if (square.name.equals(name)) {
         * return square;
         * }
         * }
         */
        return new Square(1, 1);
    }

    public Piece getPieceByName(String name) {
        // TODO: Richtig implementieren
        // for (Square square : Game.cb.squares) {
        //     if (square.getChildren().size() == 0)
        //         continue;

        //     if (square.name.equals(name))
        //         return (Piece) square.getChildren().get(0);

        // }
        // return null;
        Piece test = new Pawn(EColorPiece.BLACK, 1, 1);
        return test;
    }

    //Methoden

    private void addEventHandler() {
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                checkPossibleMoves();
            }
        });
    }

    public void checkPossibleMoves() {
    }

}
