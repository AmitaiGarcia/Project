package unittests.renderer;

import primitives.Color;
import renderer.ImageWriter;

import org.junit.Test;

public class ImageWriterTests {
    @Test
    public void gridTest() {
        ImageWriter imageWriter = new ImageWriter("grid test", 800, 500);

        // Painting the grid's background
        for (int i = 0; i < 800; i++)
            for (int j = 0; j < 500; j++)
                imageWriter.writePixel(i, j, new Color(60, 80, 120));

        // Painting the vertical lines of the grid
        for (int i = 1; i < 16; i++)
            for (int j = 0; j < 500; j++)
                imageWriter.writePixel(i * 50, j, new Color(20, 20, 20));

        // Painting the horizontal lines of the grid
        for (int i = 0; i < 800; i++)
            for (int j = 1; j < 10; j++)
                imageWriter.writePixel(i, j * 50, new Color(20, 20, 20));

        imageWriter.writeToImage();
    }
}
