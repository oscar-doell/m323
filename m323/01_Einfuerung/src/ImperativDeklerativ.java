public class ImperativDeklerativ {

    public static int calculateScore(String word){
        int score = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a') {
                continue;
            }
            score++;
        }
        return score;
    }

    public static int wordScore(String word){
        return word.replace("a", "").length();
    }


    public static void main(String[] args) {
        System.out.println(calculateScore("imperative") + " " +
                calculateScore("no") + " " +
                wordScore("declarative") + " " +
                wordScore("yes")
        );
    }
}
