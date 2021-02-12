package dev.davelpz.manta;

import java.io.IOException;
import java.io.Writer;

public class ImageBuffer {

    private PixelRGB[][] buffer;
    private int width;
    private int height;
    private PixelRGB background;

    public ImageBuffer(int width, int height, PixelRGB background) {
        this.width = width;
        this.height = height;
        buffer = new PixelRGB[width][height];
        this.background = background;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setPixel(x, y, background);
            }
        }
    }

    public ImageBuffer(int width, int height) {
        this(width, height, new PixelRGB(0, 0, 0));
    }

    public void setPixel(int x, int y, PixelRGB pixel) {
        buffer[x][y] = pixel;
    }

    public PixelRGB getPixel(int x, int y) {
        return buffer[x][y];
    }

    public void writePPM(Writer output) {
        try {
            output.write("P3\n" + width + " " + height + "\n255\n");

            for (int j = height - 1; j >= 0; j--) {
                for (int i = 0; i < width; i++) {
                    PixelRGB col = getPixel(i, j);
                    col.clamp(0.0f, 0.999999f);
                    int ir = (int) (255.99 * col.get(0));
                    int ig = (int) (255.99 * col.get(1));
                    int ib = (int) (255.99 * col.get(2));
                    output.write(ir + " " + ig + " " + ib + "\n");
                }
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
