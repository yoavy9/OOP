package image_char_matching;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Inspired by, and partly copied from
 * https://github.com/korhner/asciimg/blob/95c7764a6abe0e893fae56b3b6b580e09e1de209/src/main/java/io/korhner/asciimg/image/AsciiImgCache.java
 * described in the blog:
 * https://dzone.com/articles/ascii-art-generator-java
 * Adaptations made by Dan Nirel and again by Rachel Behar.
 * The class converts characters to a binary "image" (2D array of booleans).
 */
public class CharConverter {
    private static final double X_OFFSET_FACTOR = 0.2;
    private static final double Y_OFFSET_FACTOR = 0.75;
    private static final String FONT_NAME = "Courier New";
    public static final int DEFAULT_PIXEL_RESOLUTION = 16;



    /**
     * Renders a given character, according to how it looks in the font specified in the
     * constructor, to a square black&white image (2D array of booleans),
     * whose dimension in pixels is specified.
     */
    public static boolean[][] convertToBoolArray(char c) {
        BufferedImage img = getBufferedImage(c, FONT_NAME, DEFAULT_PIXEL_RESOLUTION);
        boolean[][] matrix = new boolean[DEFAULT_PIXEL_RESOLUTION][DEFAULT_PIXEL_RESOLUTION];
        for(int y = 0 ; y < DEFAULT_PIXEL_RESOLUTION ; y++) {
            for(int x = 0 ; x < DEFAULT_PIXEL_RESOLUTION ; x++) {
                matrix[y][x] = img.getRGB(x, y) == 0; //is the color black
            }
        }
        return matrix;
    }


    /**
     * Calculates the brightness of a character based on its representation
     * in a boolean matrix and maps it to a value between the minimum and maximum
     * brightness defined in an AsciiOrderLinkedListMap.
     * @param c The character to calculate the brightness for.
     * @param max,min The max and min values in map.
     * @return The normalized brightness value of the character.
     */
     public static double calcBrightness(char c, double min, double max){
        double initialBrightness = countNumTrue(convertToBoolArray(c));
        double newCharBrightness = (initialBrightness-min)/(max-min);
        return Math.abs(newCharBrightness);
     }

    /**
     * Counts the number of 'true' values in a 2D boolean array, representing
     * the pixelated version of a character, and normalizes it based on a predefined
     * pixel resolution to calculate the character's brightness.
     * @param matrix The 2D boolean array representing the character.
     * @return The normalized count of 'true' values, representing the character's brightness.
     */
    private static double countNumTrue(boolean[][] matrix){
        int count =0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]){
                    count++;
                }
            }
        }
        return (double)count/DEFAULT_PIXEL_RESOLUTION;
    }

    private static BufferedImage getBufferedImage(char c, String fontName, int pixelsPerRow) {
        String charStr = Character.toString(c);
        Font font = new Font(fontName, Font.PLAIN, pixelsPerRow);
        BufferedImage img = new BufferedImage(pixelsPerRow, pixelsPerRow, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setFont(font);
        int xOffset = (int)Math.round(pixelsPerRow *X_OFFSET_FACTOR);
        int yOffset = (int)Math.round(pixelsPerRow *Y_OFFSET_FACTOR);
        g.drawString(charStr, xOffset, yOffset);
        return img;
    }

}
