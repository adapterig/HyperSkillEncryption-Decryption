package encryptdecrypt;

public class ShiftEncoder extends Encoder {

    @Override
    public String encode(String input, int shift) {
        shift = shift%26;
        StringBuilder output = new StringBuilder("");
        for(int i = 0; i <input.length(); i++) {
            if (input.charAt(i) <=122 && input.charAt(i) >= 97) {
                output.append((char)(input.charAt(i) + shift > 122 ? input.charAt(i) + shift - 26: input.charAt(i) + shift));
            } else if (input.charAt(i) <=90 && input.charAt(i) >= 65) {
                output.append((char)(input.charAt(i) + shift > 90 ? input.charAt(i) + shift - 26: input.charAt(i) + shift));
            } else {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

    @Override
    public String decode(String input, int shift) {
        shift = shift%26;
        StringBuilder output = new StringBuilder("");
        for(int i = 0; i <input.length(); i++) {
            if (input.charAt(i) <=122 && input.charAt(i) >= 97) {
                output.append((char)(input.charAt(i) - shift < 97 ? input.charAt(i) - shift + 26: input.charAt(i) - shift));
            } else if (input.charAt(i) <=90 && input.charAt(i) >= 65) {
                output.append((char)(input.charAt(i) - shift < 65 ? input.charAt(i) - shift + 26: input.charAt(i) - shift));
            } else {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}
