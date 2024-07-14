import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0, n = formula.length();
        
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                int count = 0;
                
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                
                if (count == 0) count = 1;
                
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stack.pop();
                    
                    for (String key : temp.keySet()) {
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * count);
                    }
                }
            } else {
                int start = i;
                i++;
                
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);
                
                start = i;
                int count = 0;
                
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                
                if (count == 0) count = 1;
                
                map.put(element, map.getOrDefault(element, 0) + count);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> elements = new ArrayList<>(map.keySet());
        Collections.sort(elements);
        
        for (String key : elements) {
            sb.append(key);
            int count = map.get(key);
            if (count > 1) sb.append(count);
        }
        
        return sb.toString();
    }
}