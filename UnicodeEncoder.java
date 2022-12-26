package encryptdecrypt;

public class UnicodeEncoder extends Encoder{
    @Override
    public String encode(String input, int shift) {
        StringBuilder string = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            string.append((char) (input.charAt(i) + shift));
        }
        return string.toString();
    }

    @Override
    public String decode(String input, int shift) {
        StringBuilder string = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            string.append((char) (input.charAt(i) - shift));
        }
        return string.toString();
    }
}
