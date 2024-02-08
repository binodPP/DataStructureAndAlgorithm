package com.leetcodeproblem.trie;

public class TrieNode {
    private static final int ALPHABET_SIZE  =26;
    TrieNode links[];
    boolean isEndFlag;

    public TrieNode(){
        this.links = new TrieNode[ALPHABET_SIZE];
        this.isEndFlag = false;
    }
}
