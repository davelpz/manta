package dev.davelpz.manta;

import java.util.stream.Stream;

public class PixelStream {
    public int x;
    public int y;

    public PixelStream(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Stream<PixelStream> genStream(final double nx, final double ny) {
        return genStream(((int) nx), ((int) ny));
    }

    public static Stream<PixelStream> genStream(final int nx, final int ny) {
        final boolean evenx = (nx % 2) == 0;
        final int startx = -nx/2;
        final int endx = evenx ? (nx/2)-1 : nx/2;
        final boolean eveny = (ny % 2) == 0;
        final int starty = -ny/2;
        final int endy = eveny ? (ny/2)-1 : ny/2;

        Stream<PixelStream> stream = Stream.iterate(new PixelStream(startx, starty), p -> {
            if (p.x == startx && p.y == endy+1) {
                return false;
            } else {
                return true;
            }
        }, p -> {
            int tx = p.x;
            int ty = p.y;

            if (tx < endx) {
                tx++;
            } else {
                tx = startx;
                ty++;
            }

            return new PixelStream(tx, ty);
        });

        return stream;
    }

    public String toString() {
        return "PixelStream(" + x + "," + y + ")";
    }
}
