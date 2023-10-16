package com.example.demo1;

public class Point {
     private int x,y,cluster;

     public Point(int x, int y) {
          this.x = x;
          this.y = y;
          cluster=-1;
     }
     public int getX() {
          return x;
     }
     public int getY() {
          return y;
     }

     public void setCluster(int cluster) {
          this.cluster = cluster;
     }

     public int getCluster() {
          return cluster;
     }

}

