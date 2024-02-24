package image_char_matching;

public class SubImgCharMatcher {

    private AsciiOrderLinkedListMap asciiHshmap;
    private final char[] charset;

    public SubImgCharMatcher(char[] charset){ //hashmap
        this.charset = charset;
    }

    public char getCharByImageBrightness(double brightness){
        return asciiHshmap.getChar(brightness);
    }

    public void addChar(char c){
        asciiHshmap.addChar(c);
    }

    public void removeChar(char c){
        asciiHshmap.removeChar(c);
    }

}
