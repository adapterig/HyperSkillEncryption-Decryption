package encryptdecrypt;

public abstract class Encoder {
    public abstract String encode(String input, int shift);
    public abstract String decode(String input, int shift);
}
