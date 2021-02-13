package dev.davelpz.manta;

public class PixelRGB extends Vec {

    public PixelRGB() {
        super();
    }

    public PixelRGB(float e0, float e1, float e2) {
        super(e0,e1,e2);
    }

    public PixelRGB(double e0, double e1, double e2) {
        super(e0,e1,e2);
    }

    public String toString() {
        return "PixelRGB(" + e[0] + "," + e[1] + "," + e[2] + ")";
    }
}
