package TagedByCompany.Google;

/**
 * @leetcode https://leetcode.com/problems/defanging-an-ip-address/
 * @Time N
 * @Space N
 */
public class DefanginganIPAddress {
    // return address.replace(".", "[.]");
    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0)  {
            return address;
        }
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < address.length(); i ++) {
            if (address.charAt(i) == '.') {
                sol.append("[.]");
            } else {
                sol.append(address.charAt(i));
            }
        }
        return sol.toString();
    }

}
