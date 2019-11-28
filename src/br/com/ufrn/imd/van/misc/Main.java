package br.com.ufrn.imd.van.misc;

import br.com.ufrn.imd.van.trie.Tree;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Tree trie = new Tree();

        //Inserindo palavras dadas como exemplo no pdf do trabalho
        trie.insert("a");
        trie.insert("ama");
        trie.insert("amar");
        trie.insert("ame");
        trie.insert("amei");
        trie.insert("ameixa");
        trie.insert("oi");
        trie.insert("oito");
        trie.insert("eu");
        trie.insert("ela");
        trie.insert("elas");
        trie.insert("ele");
        trie.insert("eles");

        //Conferindo se  palavras foram inseridas
        System.out.println("------Teste inserir e buscar------");
        if(trie.search("amar")){
            System.out.println("Amar foi encontrada");
        }
        else{
            System.out.println("Amar não foi encontrada");
        }
        if(trie.search("oito")){
            System.out.println("oito foi encontrada");
        }
        else{
            System.out.println("oito não foi encontrada");
        }
        if(trie.search("ela")){
            System.out.println("ela foi encontrada");
        }
        else{
            System.out.println("ela não foi encontrada");
        }
        if(trie.search("amante")){
            System.out.println("Amante foi encontrada");
        }
        else{
            System.out.println("amante não foi encontrada");
        }

        //Teste remover
        System.out.println("------Teste remover------");
        trie.remove("ela");

        if(trie.search("ela")){
            System.out.println("ela foi encontrada");
        }
        else{
            System.out.println("ela não foi encontrada");
        }

        //Teste Autocompletar

        System.out.println("------Teste autocompletar------");
        List<String> words = trie.autocomplete("a");
        System.out.println("prefix - a");
        for (String s: words){
            System.out.println(s);
        }
    }
}
