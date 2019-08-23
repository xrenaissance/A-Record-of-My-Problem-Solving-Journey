package TagedByCompany.DropBoxTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/find-duplicate-file-in-system/
 * @param N = number of dirs = length of paths
 * @param M = number of diffenent content
 * @Time N * M
 * @Space N + M
 */
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return result;
        }
        Map<String, List<String>> filePath = new HashMap<>();
        for (String path : paths) {
            String[] docPath = path.split(" ");
            String dir = docPath[0];
            for (int i = 1; i < docPath.length; i++) {
                String[] fileContent = docPath[i].split("\\(");
                String file = fileContent[0];
                String content = fileContent[1].substring(0, fileContent[1].length() - 1);
                String absolutePath = new StringBuilder().append(dir)
                        .append("/")
                        .append(file).toString();
                filePath.computeIfAbsent(content, key -> new ArrayList<>()).add(absolutePath);
            }
        }
        for (Map.Entry<String, List<String>> entry : filePath.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        String path = "root/a 1.txt(abcd) 2.txt(efgh)";
        String[] docPath = path.split(" ");
        String dir = docPath[0];
        for (int i = 1; i < docPath.length; i++) {
            String[] fileContent = docPath[i].split("\\(");
            String file = fileContent[0];
            String content = fileContent[1].substring(0, fileContent[1].length() - 1);
            map.putIfAbsent(content, new ArrayList<> ());
            map.get(content).add(dir + "/" + file);
        }
        for (Map.Entry<String, List <String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
