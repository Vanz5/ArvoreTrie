package br.com.ufrn.imd.van.trie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void insert() {
        Tree trie = new Tree();
        trie.insert("teste");
        assertTrue(trie.search("teste"));
        assertFalse(trie.search("oito"));
    }

    @Test
    public void search() {
        Tree trie = new Tree();
        trie.insert("adeus");
        assertTrue(trie.search("adeus"));
        assertFalse(trie.search("oito"));
    }

    @Test
    public void autocomplete() {
        Tree trie = new Tree();
        List<String> wordsTest = new ArrayList<>();
        trie.insert("a");
        trie.insert("ama");
        wordsTest.add("ama");
        trie.insert("amar");
        wordsTest.add("amar");
        trie.insert("ame");
        wordsTest.add("ame");
        trie.insert("amei");
        wordsTest.add("amei");
        trie.insert("ameixa");
        wordsTest.add("ameixa");

        List<String> words = trie.autocomplete("a");
        assertEquals(words, wordsTest);
    }

    @Test
    public void remove() {
        Tree trie = new Tree();
        trie.insert("teste");
        trie.insert("oito");
        trie.remove("teste");
        assertTrue(trie.search("oito"));
        assertFalse(trie.search("teste"));
    }
}