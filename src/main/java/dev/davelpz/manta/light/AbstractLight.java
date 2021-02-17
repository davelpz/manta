package dev.davelpz.manta.light;

import dev.davelpz.manta.Vec;

public abstract class AbstractLight {

    private double intensity;

    public abstract double compute(Vec p, Vec n);

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }
}
