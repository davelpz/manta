package dev.davelpz.manta;

public class Sphere {
    private Vec center;
    private double radius;
    private PixelRGB color;
    private int specular;

    public Sphere(Vec center, double radius, PixelRGB color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.specular = -1;
    }

    public Sphere(Vec center, double radius, PixelRGB color, int specular) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.specular = specular;
    }

    public Vec getCenter() {
        return center;
    }

    public void setCenter(Vec center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public PixelRGB getColor() {
        return color;
    }

    public void setColor(PixelRGB color) {
        this.color = color;
    }

    public int getSpecular() {
        return specular;
    }

    public void setSpecular(int specular) {
        this.specular = specular;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                ", color=" + color +
                ", specular=" + specular +
                '}';
    }
}
