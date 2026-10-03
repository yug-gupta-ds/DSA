class Trie {

    class Node {
        Node[] child = new Node[26];
        boolean isEnd;
    }

    Node root = new Node();

    public void insert(String word) {
        Node cur = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (cur.child[i] == null)
                cur.child[i] = new Node();

            cur = cur.child[i];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = find(word);
        return cur != null && cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String s) {
        Node cur = root;

        for (char c : s.toCharArray()) {
            int i = c - 'a';

            if (cur.child[i] == null)
                return null;

            cur = cur.child[i];
        }

        return cur;
    }
}