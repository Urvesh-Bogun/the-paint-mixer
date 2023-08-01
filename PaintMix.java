public class PaintMix
{
    private char[] paint = new char[5];
    
    public PaintMix(char[] paint)
    {
        this.paint = paint;
    }
    
    public char getPaint(int i)
    {
        return this.paint[i];
    }
    
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < paint.length; i++)
        {
            result.append(paint[i]);
        }
        return result.toString();
    }
}