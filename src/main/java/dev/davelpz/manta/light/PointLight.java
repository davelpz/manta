package dev.davelpz.manta.light;

import dev.davelpz.manta.Vec;

public class PointLight extends AbstractLight {
    private Vec position;

    public PointLight(double intensity, Vec position) {
        setIntensity(intensity);
        setPosition(position);
    }

    public Vec getPosition() {
        return position;
    }

    public void setPosition(Vec position) {
        this.position = position;
    }

    @Override public double compute(Vec p, Vec n) {
        Vec l = Vec.sub(getPosition(), p);
        double n_dot_l = Vec.dot(n,l);
        if (n_dot_l > 0.0) {
            return getIntensity() * n_dot_l/(n.length() * l.length());
        } else {
            return 0.0;
        }
    }
}
