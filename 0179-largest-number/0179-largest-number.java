class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(strArr, (a, b) -> ( b+a).compareTo(a + b));
         if (strArr[0].equals("0")) {
            return "0";
        }
        return String.join("", strArr);
    }
}