class Solution {
     static class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        /*       String[] ans = new String[heights.length];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        System.out.println(map);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            ans[heights.length-i-1] = map.get(heights[i]);
        }
        */
    /*    int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people, (a, b) -> b.height - a.height);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = people[i].name;
        }

        return ans;

     */
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[indices[i]];
        }

        return ans;
    }
}