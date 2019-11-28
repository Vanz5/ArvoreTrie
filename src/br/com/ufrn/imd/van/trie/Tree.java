package br.com.ufrn.imd.van.trie;

import java.util.*;

public class Tree {
    private Node root;

    public Tree() {
        root = new Node();
    }

    //Inserindo palavra na arvore
    public void insert(String word){
        Node node = this.root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i); //Percorre a palavra
            if(!node.getChildren().containsKey(c)){ //Procura se já existe o nó filho com o caractere
                node.getChildren().put(c , new Node()); //Caso não exista o filho, o adiciona
            }
            node = node.getChildren().get(c); //parte para o filho existente ou o recentemente criado
        }
        node.setWord(true); //Variavel responsável para lembrar quando uma sequencia de nós forma uma palavra
        node.setWordString(word);
    }

    //buscando palavra na arvore
    public boolean search(String word){
        Node node = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.getChildren().containsKey(c)){ //caso o caracter da sequencia não seja encontrado, retorna false
                return false;
            }
            node = node.getChildren().get(c); //caso tenha sido encontrado move para ele
        }
        return node.isWord();
    }

    //Autocompletar
    public List<String> autocomplete(String prefix){
        List<String> words = new ArrayList<>();
        Node node = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!node.getChildren().containsKey(c)){
                return Collections.emptyList();
            }
            node = node.getChildren().get(c);
        }
        wordList(words, node, prefix);
        return words;
    }
    public void  wordList(List<String> words,Node node, String prefix){
        if(node.isWord()&&!node.getWordString().equalsIgnoreCase(prefix)){ //Confirma se o nó guarda alguma palavra E não é o prefixo dado
            words.add(node.getWordString());
        }
        for (Map.Entry<Character, Node> entry : node.getChildren().entrySet()){ //Iteração para que sejam checados todos os nós abaixo do inicial
            Node child = entry.getValue();
            List<String> childwords = new ArrayList<>();
            wordList(childwords, child, prefix);
            words.addAll(childwords);
        }
    }

    //Removendo uma palavra da arvore
    public void remove(String word){
        Node node = this.root;
        if(this.search(word)){ //Confere se a palavra está presente na trie
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i); //Percorre a palavra
                node = node.getChildren().get(c); //percorrer a arvore até chegar no ultimo character
            }
            node.setWord(false); //remove a palavra
        }
    }
}
