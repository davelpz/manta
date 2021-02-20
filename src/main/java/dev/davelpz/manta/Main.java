package dev.davelpz.manta;

import dev.davelpz.manta.light.AbstractLight;
import dev.davelpz.manta.light.AmbientLight;
import dev.davelpz.manta.light.DirectionalLight;
import dev.davelpz.manta.light.PointLight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Vec origin = new Vec(0.0, 0.0, 0.0);
    static double d = 1;
    static double vw = 1;
    static double vh = 1;
    static double cw = 750;
    static double ch = 750;
    static PixelRGB background = new PixelRGB(255, 255, 255);

    public static Vec canvasToViewport(int x, int y) {
        return new Vec(x * (vw / cw), y * (vh / ch), d);
    }

    public static double computeLighting(Vec p, Vec n, List<AbstractLight> lights) {
        double i = 0.0;

        for (AbstractLight l : lights) {
            i += l.compute(p, n);
        }

        return i;
    }

    public static PixelRGB traceRay(Vec origin, Vec d, double t_min, double t_max, List<Sphere> spheres, List<AbstractLight> lights) {
        double closest_t = Double.POSITIVE_INFINITY;
        Sphere closest_sphere = null;
        for (Sphere s : spheres) {
            Tuple2<Double, Double> t1t2 = intersectRaySphere(origin, d, s);
            //System.out.println(t1t2);
            if (t1t2.a > t_min && t1t2.a < t_max && t1t2.a < closest_t) {
                closest_t = t1t2.a;
                closest_sphere = s;
            }
            if (t1t2.b > t_min && t1t2.b < t_max && t1t2.b < closest_t) {
                closest_t = t1t2.b;
                closest_sphere = s;
            }

        }

        if (closest_sphere == null) {
            return background;
        }
        //System.out.println("closest_sphere not null");
        //return closest_sphere.getColor();
        Vec p = Vec.add(origin, Vec.mul(closest_t, d));
        Vec n = Vec.sub(p, closest_sphere.getCenter());
        n.make_unit_vector();
        return PixelRGB.mul(closest_sphere.getColor(), computeLighting(p, n, lights));
    }

    public static Tuple2<Double, Double> intersectRaySphere(Vec origin, Vec d, Sphere sphere) {
        double r = sphere.getRadius();
        Vec co = Vec.sub(origin, sphere.getCenter());
        //System.out.println(""+origin+","+sphere.getCenter()+","+co);

        double a = Vec.dot(d, d);
        double b = 2 * Vec.dot(co, d);
        double c = Vec.dot(co, co) - r * r;
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return new Tuple2<>(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        }

        double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double t2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        return new Tuple2<>(t1, t2);
    }

    public static void main(String[] args) throws IOException {
        ImageBuffer buffer = new ImageBuffer(cw, ch);
        List<Sphere> spheres = new ArrayList<>();
        spheres.add(new Sphere(new Vec(0, -1, 3), 1, new PixelRGB(255, 0, 0)));
        spheres.add(new Sphere(new Vec(2, 0, 4), 1, new PixelRGB(0, 0, 255)));
        spheres.add(new Sphere(new Vec(-2, 0, 4), 1, new PixelRGB(0, 255, 0)));
        spheres.add(new Sphere(new Vec(0, -5001, 0), 5000, new PixelRGB(255, 255, 0)));

        List<AbstractLight> lights = new ArrayList<>();
        lights.add(new AmbientLight(0.2));
        lights.add(new PointLight(0.6, new Vec(2, 1, 0)));
        lights.add(new DirectionalLight(0.2, new Vec(1, 4, 4)));

        int cwOffset = (int) (cw / 2);
        int chOffset = (int) (ch / 2);
        PixelStream.genStream(cw, ch).forEach(p -> {
            //System.out.println(p);
            Vec D = canvasToViewport(p.x, p.y);
            //System.out.println(D);
            PixelRGB color = traceRay(origin, D, 1.0, Double.POSITIVE_INFINITY, spheres, lights);
            //System.out.println(color);
            buffer.setPixel(cwOffset + p.x, chOffset + p.y, color);
        });
        BufferedWriter output = new BufferedWriter(new FileWriter("output.ppm"));
        buffer.writePPM(output);
    }
}
