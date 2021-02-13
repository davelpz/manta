package dev.davelpz.manta;

public class Sphere {
    private Vec center;
    private double radius;
    private PixelRGB color;

    public Sphere(Vec center, double radius, PixelRGB color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
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

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}
