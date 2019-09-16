package Facebook;

/**
 * @leetcode https://leetcode.com/problems/validate-ip-address/
 * @Time N
 * @Space N
 */
public class ValidIPAddress {
    public String validIPAddress(String ip) {
        if (isValidIpv4(ip)) {
            return "IPv4";
        } else if (isValidIpv6(ip)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIpv4(String ip) {
        if (ip.length() < 7) {
            return false;
        } else if (ip.startsWith(".") || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }

        String[] array = ip.split("\\.");
        if (array.length != 4) {
            return false;
        }

        for (String str : array) {
            if (!isValidIpv4Token(str)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIpv4Token(String token) {
        if (token.startsWith("0") && token.length() > 1) {
            return false;
        }

        try {
            int digit = Integer.parseInt(token);
            if (digit < 0 || digit > 255) {
                return false;
            } else if (digit == 0 && token.length() > 1) {
                return false;
            }
        } catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    private boolean isValidIpv6(String ip) {
        if (ip.length() < 15) {
            return false;
        } else if (ip.startsWith(":") || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }

        String[] array = ip.split(":");
        if (array.length != 8) {
            return false;
        }

        for (String token : array) {
            if (!isValidIpv6Token(token)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIpv6Token(String token) {
        if (token.length() == 0 || token.length() > 4) {
            return false;
        }

        for (int i = 0; i < token.length(); i++) {
            char ch = token.charAt(i);
            boolean isDigit = (ch >= '0' && ch <= '9');
            boolean isLowerCase = (ch >= 'a' && ch <= 'f');
            boolean isUpperCase = (ch >= 'A' && ch <= 'F');

            if (!(isDigit || isLowerCase || isUpperCase)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "2001:db8:85a3:0::8a2E:0370:7334";
        String[] array = input.split(":");

        // System.out.println(array.length);
        // System.out.println(':' >= 'a' && ':' <= 'f');
        for (String str : array) {
            System.out.println(str + " " + str.length());
        }
    }
}
