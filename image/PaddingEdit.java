package image;



import java.awt.Color;
import java.io.IOException;
public class PaddingEdit implements ImageEditing{

    public Image execute(Image image){
        int newWidth = findClosestPowerOf2(image.getWidth());
        int newHeight = findClosestPowerOf2(image.getHeight());
        int colPadding = (newWidth-image.getWidth())/2;
        int rowPadding = (newHeight-image.getHeight())/2;

        Color[][] paddedArray = new Color[newHeight][newWidth];

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j <newWidth ; j++) {
                paddedArray[i][j] = Color.WHITE;
            }
        }
        for (int i = rowPadding; i <newHeight-rowPadding ; i++) {
            for (int j = colPadding; j <newWidth-colPadding ; j++) {
                paddedArray[i][j] = image.getPixel(i-rowPadding,j-colPadding);
            }
        }
        return new Image(paddedArray,newWidth,newHeight);
        


    }

    private  int findClosestPowerOf2(int size) {
        if (size <= 0) return 1; // Edge case handling
        if (((size - 1) & size) == 0) return size; // Check if 'size' is already a power of 2

        int lowerPowerOf2 = (int) Math.pow(2, (int) (Math.log(size) / Math.log(2)));
        int higherPowerOf2 = lowerPowerOf2 * 2;

        // Determine which power of 2 is closer to 'size'
        if (size - lowerPowerOf2 < higherPowerOf2 - size) {
            return lowerPowerOf2;
        } else {
            return higherPowerOf2;
        }
    }

}
