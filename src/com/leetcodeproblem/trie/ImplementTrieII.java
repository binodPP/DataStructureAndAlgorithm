/*
package com.leetcodeproblem.trie;

//https://takeuforward.org/data-structure/implement-trie-ii/
public class ImplementTrieII {
    private TrieNode root;
    public ImplementTrieII() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            int index = word.charAt(i) - 'a';
            if(trieNode.links[index] == null){
                trieNode.links[index] = new TrieNode();
            }
            trieNode = trieNode.links[index];
        }
        trieNode.isEndFlag=true;
    }

    public int countEqualsWords(String word){
        TrieNode trieNode = root;
        for (int i=0; i < word.length(); i++ ){
            int index = word.charAt(i) - 'a';
            if(trieNode.links[index] == null){
                return 0;
            }
            trieNode = trieNode.links[index];
        }
        return countWords(trieNode);
    }

    private int countWords(TrieNode node) {
       int count=0;
       if(node.isEndFlag){
           count++;
       }
        for ( TrieNode childLinks: node.links) {
            if(childLinks != null){
                count = count + countWords(childLinks);
            }
        }
       return count;
    }



    public static void main(String[] args) {
        ImplementTrieII trie=new ImplementTrieII();
        // Inserting words
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Counting equal words
        System.out.println("Count of 'app': " + trie.countEqualsWords("app"));
        System.out.println("Count of 'apple': " + trie.countEqualsWords("apple"));

        // Deleting a word
        trie.delete("apple");

        // Finding words with a prefix
        trie.startsWith("app");
        //T.insert("apple");
        //T.insert("apps");
        //T.insert("apps");
        */
/*String word1 = "apps";
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
        System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));*//*

    }
}
*/
