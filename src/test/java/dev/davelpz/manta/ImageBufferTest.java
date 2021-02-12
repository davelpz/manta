package dev.davelpz.manta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageBufferTest {

    @org.junit.jupiter.api.Test void writePPM() throws IOException {
        ImageBuffer buffer = new ImageBuffer(500,500);
        for (int x=0;x<500;x++) {
            PixelRGB pixel = new PixelRGB(128,128,128);
            buffer.setPixel(x,250, pixel);
        }
        BufferedWriter output = new BufferedWriter(new FileWriter("output.ppm"));
        buffer.writePPM(output);
    }
}