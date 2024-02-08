/*
package com.leetcodeproblem.trie;

public class ImplementTrie1_208 {
    private static TrieNode root;

    public ImplementTrie1_208() {
        root = new TrieNode();
    }

    //insert word into Tri data structure
    public static void insert(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                trieNode.putChar(ch, new TrieNode());
            }

            trieNode = trieNode.getCharKey(ch);
        }

        trieNode.setEnd();
    }

    //search word into Tri data structure
    public static boolean search(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                return false;
            }
            trieNode = trieNode.getCharKey(ch);
        }

        if (trieNode.isEnd()){
            return true;
        }
        return false;
    }

    //find word startWith into Tri data structure
    public static boolean startWith(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            char ch= word.charAt(i);
            if(!trieNode.containsCharKey(ch)){
                return false;
            }
            trieNode = trieNode.getCharKey(ch);
        }

        return true;
    }


    public static void main(String[] args) {
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        ImplementTrie1_208 trie=new ImplementTrie1_208();

        for (int i = 0; i < value.length; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            }
            else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println( "true" );
                }
                else {
                    System.out.println("false");
                }
            }
            else {
                if (trie.startWith(value[i])) {
                    System.out.println("true" );
                }
                else {
                    System.out.println("false");
                }
            }
        }
    }

}
*/
