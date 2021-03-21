public class app {
    public static void main(String[] args) {
        StringBuilder concatString = new StringBuilder();
        for (String arg : args) {
            concatString.append(concatString.toString().concat(arg));
        }
        StringBuilder stringBuilder = new StringBuilder(concatString.toString());
        CleanOneSymbolWords(stringBuilder);
        String cleanedString = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder(cleanedString.trim());
        CleanSpaces(stringBuilder1);
        String result = stringBuilder1.toString();
        System.out.println(result);
    }

    public static void CleanSpaces(StringBuilder s) {
        for (int i = 0; i < s.length() - 2; ++i)
            if ((s.charAt(i) == ' ') && (s.charAt(i + 1) == ' ')) {
                s.deleteCharAt(i);
                --i;
            }
    }
    public static void CleanOneSymbolWords(StringBuilder s){
        if (s.charAt(s.length() - 2) == ' '){
            s.deleteCharAt(s.length() - 1);
        }
        for (int i = 1; i < s.length() - 1; ++i){
            if ((s.charAt(i - 1) == ' ') && (s.charAt(i + 1) == ' ')){
                s.deleteCharAt(i);
                --i;
            }
        }
    }
}