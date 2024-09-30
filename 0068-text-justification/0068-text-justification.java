class Solution {
    public List<String> fullJustify(String[] words, int maxi) {
        List<String> ans = new ArrayList<>();
    String[] cur = new String[words.length];
    int cnt = 0;
    int ind = 0;

    for (String it : words) {
        if (it.length() + ind + cnt > maxi) {
            for (int i = 0; i < maxi - cnt; i++) {
                cur[i % (ind - 1 > 0 ? ind - 1 : 1)] += " ";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ind; i++) {
                sb.append(cur[i]);
            }
            ans.add(sb.toString());
            ind = 0;
            cnt = 0;
        }
        cur[ind++] = it;
        cnt += it.length();
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ind; i++) {
        sb.append(cur[i]);
        if (i != ind - 1) sb.append(" ");
    }
    while (sb.length() < maxi) sb.append(" ");
    ans.add(sb.toString());

    return ans;
    }
}