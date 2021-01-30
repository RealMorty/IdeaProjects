package com.hust.cqb.BookTest.Test10Inner;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i=0;i<d.length;i++) {
            d[i] = 100*Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public void setFirst(double first) {
            this.first = first;
        }

        public double getSecond() {
            return second;
        }

        public void setSecond(double second) {
            this.second = second;
        }
    }
    public static Pair minmax(double[] values) {
        double min = values[0];
        double max = values[0];

        for (double v: values) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return new Pair(min, max);
    }
}
