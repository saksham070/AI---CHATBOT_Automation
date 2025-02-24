import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot(); // ChatBot ka object banao
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the AI Chatbot! Type 'exit' to quit.");
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Auto-complete suggestions
            List<String> suggestions = chatBot.getSuggestions(input);
            if (!suggestions.isEmpty()) {
                System.out.println("Suggestions: " + suggestions);
            }

            // Chatbot ka response
            String response = chatBot.getResponse(input);
            System.out.println("Bot: " + response);
        }
        scanner.close();
    }
}
