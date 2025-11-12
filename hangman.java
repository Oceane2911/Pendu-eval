import java.util.Scanner;
import java.util.Random;


class Hangman {
    /**
     * List of 5 word
     * random choice word in display
     * 
     */

    public static String[] listWord = {
            "bonjour",
            "entrez",
            "ordinateur",
            "cahier",
            "telephone"
    };

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] params) {

        hidden(randomWord());
        play(randomWord());

    };

    public static String randomWord() {

        Random r = new Random();
        String word = listWord[r.nextInt(listWord.length)];
        return word;
    };

    public static String hidden(String word) {
        String m = "";
        int n = word.length();
        for (int i = 0; i <= n; i++) {
            m = m + '-';
        }
        System.out.println(m);
        return m;
    };

    public static void play(String word) {
        boolean l = false;
        int round = 7;
        int letterTrouve = 0;
        while (round > 0 || letterTrouve != word.length()) {
            System.out.println("choissez une lettre: ");
            String let = scan.nextLine();
            char letter = let.charAt(0);
            for (int i = 0; i < word.length(); i++) {
                char lettre = word.charAt(i);
                // listLetter.add(lettre);

                if (lettre == letter) {

                    System.out.println(
                            "La letter '" + letter + "' est bien présente dans le mot à la" + (i + 1) + " ème place");
                    letterTrouve++;
                    l = true;
                }
            }
            if (l == true) {
                l= false;
            }else{
                System.out.println("la lettre " + letter + " n'est pas dans le mot. Recommencez");
                round--;
            }
            if (letterTrouve == word.length()) {
                System.out.println("Bravo vous avez trouvez le mot: " + word);
                break;
            }
            if (round == 0) {
                System.out.println("Dommage le mot etait: " + word);
                break;
            }
        }
    }

};