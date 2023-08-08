import java.util.Arrays;

//Class representing a paintmix with a length of 5
public class PaintMix {
    private char[] paint = new char[5];
    
    public PaintMix(char[] paint) {
        this.paint = paint;
    }
    
    public char getPaint(int i) {
        return this.paint[i];
    }

    //Boolean to check if painmixes are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) { 
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaintMix paintMix = (PaintMix) o;
        return Arrays.equals(paint, paintMix.paint);
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < paint.length; i++) {
            result.append(paint[i]);
        }
        return result.toString();
    }
}