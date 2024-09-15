class Solution {
    public String maxValue(String n, int x) {
    //        if (n.charAt(0) == '-') {
////            return x + n;
//            for (int i = 1; i < n.length(); i++) {
//                if (n.charAt(i) > (char) (x + '0')) {
//                    return n.substring(0, i) + x + n.substring(i);
//                }
//            }
//            return n + x;
//        }
//        return checkAllPossibleWay(n, x);
//    }
//
//    static String checkAllPossibleWay(String n, int x) {
//        String maxi = x + n;
//        int len = n.length();
//
//        for (int i = 0; i <= len; i++) {
//            String curr = n.substring(0, i) + x + n.substring(i);
//            if (curr.compareTo(maxi) > 0) {
//                maxi = curr;
//            }
//        }
//        return maxi;
        char curr = (char) (x + '0');

        if (n.charAt(0) == '-') {
            for (int i = 1; i < n.length(); i++) {
                if (n.charAt(i) > curr) {
                    return n.substring(0, i) + curr + n.substring(i);
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) < curr) {
                    return n.substring(0, i) + curr + n.substring(i);
                }
            }
        }
        return n + curr;
    }
}