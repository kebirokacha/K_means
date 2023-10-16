package com.example.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class K_means {
    public K_means(List<Point> points, int k) {
        this.points = points;
        K = k;
        cent = new ArrayList<>();
        initialierCenter();
    }

    private List<Point>points;
    private  List<Center>cent;
    public int K;

    public void initialierCenter() {
        Random random = new Random();
        for (int i = 0; i < K; i++){
            int randomIndex = random.nextInt(points.size());
            Center centre = new Center(points.get(randomIndex).getX(), points.get(randomIndex).getY());
            cent.add(centre);
        }
    }
    public void MiseAJourCenter(){  for (int i = 0; i < K; i++) {
        double sumX = 0;
        double sumY = 0;
        int count = 0;
        for (Point point : points) {
            if (point.getCluster() == i) {
                sumX += point.getX();
                sumY += point.getY();
                count++;
            }
        }
        if (count != 0) {
            cent.get(i).setX(sumX / count);
            cent.get(i).setY(sumY / count);
        }
    }


    }
    public void identificationOfClusters() {
        for (Point point : points) {
            double minDistance = Double.MAX_VALUE;
            int clusterId = -1;
            for (int i = 0; i < K; i++) {
                double distance = CalculateDistance(point.getX(), point.getY(), cent.get(i).getX(), cent.get(i).getY());
                if (distance < minDistance) {
                    minDistance = distance;
                    clusterId = i;
                }
            }
            point.setCluster(clusterId);
        }
    }
    public void run() {
        boolean isClustersChanged = true;
        while (isClustersChanged) {
            identificationOfClusters();
            List<Center> oldCentroids = new ArrayList<>(cent);
            MiseAJourCenter();
            if (oldCentroids.equals(cent)) {
                isClustersChanged = false;
            }
        }
    }



    public double CalculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));}


}
