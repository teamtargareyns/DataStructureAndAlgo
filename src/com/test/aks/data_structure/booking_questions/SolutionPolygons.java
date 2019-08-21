package com.test.aks.data_structure.booking_questions;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionPolygons {

    static class Polygons {
        int countSquare, countRect, countOthers;

        public Polygons() {
            countSquare = 0;
            countRect = 0;
            countOthers = 0;
        }

        public void addNewPolygon(int a, int b, int c, int d) {
            // TODO Auto-generated method stub
            if (a <= 0 || b <= 0 || c <= 0 | d <= 0) {
                this.countOthers++;
                return;
            }

            if (a == c && b == d) {
                if (a == b) {
                    this.countSquare++;
                } else {
                    this.countRect++;
                }
            } else {
                this.countOthers++;
            }
        }

        public int getCountSquare() {
            return countSquare;
        }

        public int getCountRect() {
            return countRect;
        }

        public int getCountOthers() {
            return countOthers;
        }


    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


        Scanner scanner = new Scanner(System.in);
        Polygons p = new Polygons();
        while (scanner.hasNextLine()) {
            String[] sideIntegers = scanner.nextLine().split("\\s");
            int []intCoordinates = Arrays.stream(sideIntegers).mapToInt(a->{
                int value = Integer.valueOf(a.trim()).intValue();
                if (value < -2000 || value > 2000) {
                    throw new RuntimeException("Incorrect side length : " + value);
                }
                return value;
            }).toArray();

            if (intCoordinates.length != 4) {
                throw new RuntimeException("Incorrect number of side lengths : " + intCoordinates.length);
            }

            int a = intCoordinates[0];
            int b = intCoordinates[1];
            int c = intCoordinates[2];
            int d = intCoordinates[3];

            p.addNewPolygon(a, b, c, d);
        }

        scanner.close();

        System.out.println(p.getCountSquare() + " " +
                p.getCountRect() + " " +
                p.getCountOthers());
    }
}
