package dev.davelpz.manta.light;

import dev.davelpz.manta.Vec;

public class AmbientLight extends AbstractLight {

    public AmbientLight(double intensity) {
        setIntensity(intensity);
    }

    @Override public double compute(Vec p, Vec n, Vec v, int s) {
        return getIntensity();
    }
}
