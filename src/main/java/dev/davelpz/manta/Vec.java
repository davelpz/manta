package dev.davelpz.manta;

public class Vec {
    double[] e = new double[3];

    public Vec() {
    }

    public Vec(float e0, float e1, float e2) {
        e[0] = e0;
        e[1] = e1;
        e[2] = e2;
    }

    public Vec(double e0, double e1, double e2) {
        e[0] = e0;
        e[1] = e1;
        e[2] = e2;
    }

    public static Vec clone(Vec t) {
        return new Vec(t.e[0], t.e[1], t.e[2]);
    }

    public double x() {
        return e[0];
    }

    public double y() {
        return e[1];
    }

    public double z() {
        return e[2];
    }

    public double r() {
        return e[0];
    }

    public double g() {
        return e[1];
    }

    public double b() {
        return e[2];
    }

    public static Vec plus(Vec a) {
        return a;
    }

    public static Vec neg(Vec a) {
        return new Vec(-a.x(), -a.y(), -a.z());
    }

    public double get(int i) {
        return e[i];
    }

    public void set(int i, double value) {
        e[i] = value;
    }

    public double length() {
        return Math.sqrt(e[0] * e[0] + e[1] * e[1] + e[2] * e[2]);
    }

    public double squared_length() {
        return e[0] * e[0] + e[1] * e[1] + e[2] * e[2];
    }

    public String toString() {
        return "Vec(" + e[0] + "," + e[1] + "," + e[2] + ")";
    }

    public void make_unit_vector() {
        double k = 1.0f / length();
        e[0] *= k;
        e[1] *= k;
        e[2] *= k;
    }

    public static Vec add(Vec a, Vec b) {
        return new Vec(a.x() + b.x(), a.y() + b.y(), a.z() + b.z());
    }

    public static Vec sub(Vec a, Vec b) {
        return new Vec(a.x() - b.x(), a.y() - b.y(), a.z() - b.z());
    }

    public static Vec mul(Vec a, Vec b) {
        return new Vec(a.x() * b.x(), a.y() * b.y(), a.z() * b.z());
    }

    public static Vec div(Vec a, Vec b) {
        return new Vec(a.x() / b.x(), a.y() / b.y(), a.z() / b.z());
    }

    public static Vec mul(Vec a, double t) {
        return new Vec(a.x() * t, a.y() * t, a.z() * t);
    }

    public static Vec mul(double t, Vec a) {
        return new Vec(a.x() * t, a.y() * t, a.z() * t);
    }

    public static Vec div(Vec a, double t) {
        return new Vec(a.x() / t, a.y() / t, a.z() / t);
    }

    public static double dot(Vec a, Vec b) {
        return a.x() * b.x() + a.y() * b.y() + a.z() * b.z();
    }

    public static Vec cross(Vec a, Vec b) {
        return new Vec(a.y() * b.z() - a.z() * b.y(), -(a.x() * b.z() - a.z() * b.x()), a.x() * b.y() - a.y() * b.x());
    }

    public Vec add(Vec a) {
        e[0] += a.x();
        e[1] += a.y();
        e[2] += a.z();
        return this;
    }

    public Vec mul(Vec a) {
        e[0] *= a.x();
        e[1] *= a.y();
        e[2] *= a.z();
        return this;
    }

    public Vec div(Vec a) {
        e[0] /= a.x();
        e[1] /= a.y();
        e[2] /= a.z();
        return this;
    }

    public Vec sub(Vec a) {
        e[0] -= a.x();
        e[1] -= a.y();
        e[2] -= a.z();
        return this;
    }

    public Vec mul(double t) {
        e[0] *= t;
        e[1] *= t;
        e[2] *= t;
        return this;
    }

    public Vec div(double t) {
        e[0] /= t;
        e[1] /= t;
        e[2] /= t;
        return this;
    }

    public Vec sqrt() {
        e[0] = Math.sqrt(e[0]);
        e[1] = Math.sqrt(e[1]);
        e[2] = Math.sqrt(e[2]);
        return this;
    }

    public static Vec unit_vector(Vec v) {
        return Vec.div(v, v.length());
    }

    public void clamp(double min, double max) {
        if (e[0] < min)
            e[0] = min;
        else if (e[0] > max)
            e[0] = max;

        if (e[1] < min)
            e[1] = min;
        else if (e[1] > max)
            e[1] = max;

        if (e[2] < min)
            e[2] = min;
        else if (e[2] > max)
            e[2] = max;
    }
}