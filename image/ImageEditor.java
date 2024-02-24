package image;

/**
 * Defines a contract for image editing operations. Implementations of this interface
 * are expected to provide specific image processing or editing functionality.
 */
public interface ImageEditor {
     /**
      * Executes an image editing operation on the provided Image object.
      *
      * @param image The Image object to be processed.
      * @return The Image object after applying the editing operation.
      */
     Image paddImage(Image image);

     Image changeColorScheme(Image image);

     Image getSubImage(Image image, int resolution);



}
