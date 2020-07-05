class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int length = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();

        // 数据预处理 结果类似于 <h*t,<hot,hit,hat>>
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String newWord = word.replace(word.charAt(i),'*');
                List<String> transformations = allComboDict.getOrDefault(newWord,new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord,transformations);
            }
        }

        // <word,level>
        Queue<Pair<String,Integer>>  queue = new LinkedList<>();
        queue.add(new Pair<String,Integer>(beginWord,1));

        // 用一个数据结构记录确保没有重复处理
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);

        while (!queue.isEmpty()) {
            Pair<String,Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();

            for (int i = 0; i < length; i++) {
                String newWord = word.replace(word.charAt(i),'*');
                for (String adjacentWord : allComboDict.getOrDefault(newWord,new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord,true);
                        queue.add(new Pair<String,Integer>(adjacentWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
}