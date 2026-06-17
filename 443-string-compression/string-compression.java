class Solution {
    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            sb.append(c);
        }

        StringBuilder newsb = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            int count = 1;

            while (i < sb.length() - 1 && sb.charAt(i) == sb.charAt(i + 1)) {
                count++;
                i++;
            }

            newsb.append(sb.charAt(i));

            if (count > 1) {
                newsb.append(count);
            }
        }

        for(int i = 0; i < newsb.length(); i++){
            chars[i] = newsb.charAt(i);
        }

        return newsb.length();
    }
}