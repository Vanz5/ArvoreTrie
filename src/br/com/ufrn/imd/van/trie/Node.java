package br.com.ufrn.imd.van.trie;

import java.util.*;

public class Node {
    private HashMap<Character, Node> children = new HashMap<>(); //map que contem todos os filhos desse nó
    private boolean isWord;
    private String wordString;

    public Node() {
        this.isWord = false;
    }

    public HashMap<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, Node> children) {
        this.children = children;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public boolean isWord() {
        return isWord;
    }

    public String getWordString() {
        return wordString;
    }

    public void setWordString(String wordString) {
        this.wordString = wordString;
    }
}
