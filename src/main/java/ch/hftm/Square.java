package ch.hftm;

import javafx.scene.layout.StackPane;

public class Square extends StackPane {

    public int x;
    public int y;
    public boolean occupied;
    String name;

    public Square(int y, int x) {
        this.x = x;
        this.y = y;
        this.occupied = false;
        this.name = Coordinates.fromCoordinatesToNo(x, y).getNotation();
    }

    @Override
    public String toString() {
        String status;
        if (this.occupied)
            status = "Occupied";
        else
            status = "Not occupied";
        // return "Square" + this.x + this.y + " - " + status;
        return "Square";
    }

    public void setName(String name) {
        this.name = name;
    }

}
