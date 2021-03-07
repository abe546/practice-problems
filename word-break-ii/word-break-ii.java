class Solution {

    Set<String> dict = new HashSet();

    List<String> words = new LinkedList();

    public List<String> wordBreak(String s, List<String> wordDict) {

        wordDict.stream().forEach(item -> dict.add(item));

        findWords(s, 0, new LinkedList());

        return words;

    }

    public void findWords(String input, int index, List<String> strings) {
        if (index >= input.length()) {


            StringBuilder word2 = new StringBuilder();

            word2.append(strings.get(0));

            for (int i = 1; i < strings.size(); i++) {
                String item = strings.get(i);

                word2.append(" " + item);
            }

            words.add(word2.toString());
        }

        StringBuilder word = new StringBuilder();

        for (int i = index; i < input.length(); i++) {
            word.append(input.charAt(i));

            if (dict.contains(word.toString())) {
                List<String> newStrings = new ArrayList(strings);
                newStrings.add(word.toString());


                findWords(input, i + 1, newStrings);


            }
        }
    }
}