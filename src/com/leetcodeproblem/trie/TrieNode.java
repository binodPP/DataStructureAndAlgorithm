package com.leetcodeproblem.trie;

public class TrieNode {
    TrieNode links[];
    boolean isEndFlag = false;

    public TrieNode(){
      links = new TrieNode[26];
    }

    public boolean containsCharKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void putChar(char ch, TrieNode trieNode){
        links[ch - 'a'] = trieNode;
    }

    public TrieNode getCharKey(char ch){
        return links[ch - 'a'];
    }

    public void setEnd(){
        isEndFlag = true;
    }
    public boolean isEnd(){
        return isEndFlag;
    }


}
