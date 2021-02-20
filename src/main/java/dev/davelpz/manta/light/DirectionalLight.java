package dev.davelpz.manta.light;

import dev.davelpz.manta.Vec;

public class DirectionalLight extends AbstractLight {
    private Vec direction;

    public DirectionalLight(double intensity, Vec direction) {
        setIntensity(intensity);
        setDirection(direction);
    }

    public Vec getDirection() {
        return direction;
    }

    public void setDirection(Vec direction) {
        this.direction = direction;
    }

    @Override public double compute(Vec p, Vec n) {
        Vec l = getDirection();
        double n_dot_l = Vec.dot(n,l);
        if (n_dot_l > 0.0) {
            return getIntensity() * n_dot_l/(n.length() * l.length());
        } else {
            return 0.0;
        }

    }
}
