package ascii_art;

public class AsciiArtAlgorithm {

    // part 1 - set ascii brightness values




    // part 2 - divide orig image into subimages and convert to ascii
    public void (Image image, int resolution){
        int subImageWidth = image.getWidth() / resolution;
        int subImageHeight = image.getHeight() / resolution;
        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                Image subImage = getSubImage(i * subImageWidth,
                        j * subImageHeight,
                        subImageWidth,
                        subImageHeight);
                double brightness = calcSubImageBrightness(subImage);
            }
        }
    }
    // part 3

    // part 4
}
