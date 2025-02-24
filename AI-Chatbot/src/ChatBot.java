import java.util.HashMap;
import java.util.List;

public class ChatBot {
    private final Trie trie = new Trie();
    private final HashMap<String, String> responseMap = new HashMap<>();

    public ChatBot() {
        loadPhrases();
        loadResponses();
    }

    private void loadPhrases() {
        // Example phrases
        trie.insert("hello");
        trie.insert("how are you");
        trie.insert("help");
        trie.insert("what is your name");
        trie.insert("thank you");
    }

    private void loadResponses() {
        // Example responses
        responseMap.put("hello", "Hi! How can I help you?");
        responseMap.put("how are you", "I'm good! How about you?");
        responseMap.put("help", "Sure, what do you need help with?");
        responseMap.put("what is your name", "I'm an AI chatbot.");
        responseMap.put("thank you", "You're welcome!");
        responseMap.put("can i talk with you", "Sure, I'm here to talk with you");
    }

    public List<String> getSuggestions(String prefix) {
        return trie.search(prefix.toLowerCase());
    }

    public String getResponse(String query) {
        return responseMap.getOrDefault(query.toLowerCase(), "I don't understand that. Can you rephrase?");
    }
}
