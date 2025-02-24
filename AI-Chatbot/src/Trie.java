import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') continue;
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') continue;
            int index = c - 'a';
            if (node.children[index] == null) {
                return new ArrayList<>();
            }
            node = node.children[index];
        }
        List<String> results = new ArrayList<>();
        collectSuggestions(node, prefix, results);
        return results;
    }

    private void collectSuggestions(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                collectSuggestions(node.children[i], prefix + (char) (i + 'a'), results);
            }
        }
    }
}

