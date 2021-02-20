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

    @Override public double compute(Vec p, Vec n, Vec v, int s) {
        double i;
        Vec l = Vec.sub(getPosition(), p);
        double n_dot_l = Vec.dot(n,l);
        if (n_dot_l > 0.0) {
            i = getIntensity() * n_dot_l/(n.length() * l.length());
        } else {
            i = 0.0;
        }

        if (s != -1) {
            Vec r = Vec.sub(Vec.mul(2*Vec.dot(n,l),n), l);
            double r_dot_v = Vec.dot(r,v);
            if (r_dot_v > 0) {
                i += getIntensity() * Math.pow(r_dot_v/(r.length() * v.length()), s);
            }
        }

        return i;
    }
}
