import java.util.*;

class Solution {
    Map<String, List<String>> parent = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(
            String beginWord, String endWord, List<String> wordList) {

        parent.clear();
        ans.clear();

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dict.remove(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            Set<String> used = new HashSet<>();

            for (int size = q.size(); size > 0; size--) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        arr[i] = c;
                        String next = new String(arr);

                        if (dict.contains(next)) {
                            parent.computeIfAbsent(next,
                                x -> new ArrayList<>()).add(word);

                            if (used.add(next))
                                q.offer(next);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }
                    arr[i] = old;
                }
            }

            dict.removeAll(used);
        }

        if (found)
            dfs(endWord, beginWord, new ArrayList<>());

        return ans;
    }

    void dfs(String word, String begin, List<String> path) {
        path.add(word);

        if (word.equals(begin)) {
            List<String> res = new ArrayList<>(path);
            Collections.reverse(res);
            ans.add(res);
        } else {
            for (String p : parent.getOrDefault(word,
                    Collections.emptyList())) {
                dfs(p, begin, path);
            }
        }

        path.remove(path.size() - 1);
    }
}