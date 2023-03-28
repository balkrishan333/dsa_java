import java.util.*;

public class HexToBase62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a hexadecimal number: ");
        String hex = sc.nextLine();
        String base62 = convertHexToBase62(hex);
        System.out.println("Base-62 representation: " + base62);
    }
    
    public static String convertHexToBase62(String hex) {
        String base62Chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String base62 = "";
        long decimal = Long.parseLong(hex, 16);
        while (decimal > 0) {
            int remainder = (int) (decimal % 62);
            base62 = base62Chars.charAt(remainder) + base62;
            decimal /= 62;
        }
        return base62;
    }
}
