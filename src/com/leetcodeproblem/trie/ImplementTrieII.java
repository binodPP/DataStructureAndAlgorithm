package com.leetcodeproblem.trie;

//https://takeuforward.org/data-structure/implement-trie-ii/
public class ImplementTrieII {

    private TrieNode root;

    private int countEqualWord=0;
    private int countPrefixMatchWord=0;

    public ImplementTrieII() {
        root = new TrieNode();
    }

    //insert word into Tri data structure
    public void insert(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                trieNode.putChar(ch, new TrieNode());
            }

            trieNode = trieNode.getCharKey(ch);
            increasePrefix();
        }
        increaseEnd();
    }

    //countWordsEqualTo word into Tri data structure
    public int countWordsEqualTo(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                return 0;
            }
            trieNode = trieNode.getCharKey(ch);
        }

        return getEnd();
    }

    //count word startWith into Tri data structure
    public int countWordsStartingWith(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                return 0;
            }
            trieNode = trieNode.getCharKey(ch);
        }

        return getPrefix();
    }

    //delete word startWith into Tri data structure
    public void delete(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                return;
            }
            trieNode = trieNode.getCharKey(ch);
            reducePrefix();
        }
        deleteEnd();
    }


    public void increaseEnd() {
        countEqualWord++;
    }
    public void increasePrefix() {
        countPrefixMatchWord++;
    }
    public void deleteEnd() {
        countEqualWord--;
    }
    public void reducePrefix() {
        countPrefixMatchWord--;
    }
    public int getEnd() {
        return countEqualWord;
    }
    public int getPrefix() {
        return countPrefixMatchWord;
    }


    public static void main(String[] args) {
        ImplementTrieII T=new ImplementTrieII();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");
        String word1 = "apps";
        System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith
                (word3));
        String word4 = "appl";
        System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith
                (word4));
        T.delete(word1);
        System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));
    }
}
