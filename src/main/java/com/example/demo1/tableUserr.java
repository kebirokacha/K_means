package com.example.demo1;

public class tableUserr {
    int points;
    int ColonX;
    int ColonY;

    public tableUserr() {
//        this.points=0;
//        this.ColonX=0;
//        this.ColonY=0;
    }

    public tableUserr(int points, int colonX, int colonY) {
        this.points = points;
        ColonX = colonX;
        ColonY = colonY;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getColonX() {
        return ColonX;
    }

    public void setColonX(int colonX) {
        ColonX = colonX;
    }

    public int getColonY() {
        return ColonY;
    }

    public void setColonY(int colonY) {
        ColonY = colonY;
    }
}
