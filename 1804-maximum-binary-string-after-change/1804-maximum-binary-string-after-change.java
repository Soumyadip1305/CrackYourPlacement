class Solution {
    public String maximumBinaryString(String binary) {
         int n = binary.length();
        int cntZ = 0;
        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                if (pos == -1) pos = i;
                cntZ++;
            }
        }

        if (cntZ <= 1) if (cntZ <= 1) return binary;

        return "1".repeat(Math.max(0, pos + cntZ - 1)) +
                '0' +
                "1".repeat(Math.max(0, n - (pos + cntZ)));
    }
}

/*

000110
100110
110110

110101
110011
111011


*/