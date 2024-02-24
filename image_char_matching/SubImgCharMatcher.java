package image_char_matching;

import ascii_art.AsciiOrderLinkedListMap;

public class SubImgCharMatcher {

    private AsciiOrderLinkedListMap asciiHashMap;
    private final char[] charSet;

    public SubImgCharMatcher(char[] charset){ //hashmap
        this.charSet = charset;
    }

    public char getCharByImageBrightness(double brightness){
        return asciiHashMap.getChar(brightness);
    }

    public void addChar(char c){
        double brightness =
        asciiHashMap.addChar(c);
    }

    public void removeChar(char c){
        asciiHashMap.removeChar(c);
    }

}
