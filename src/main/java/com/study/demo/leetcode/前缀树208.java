package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/7 8:11 下午
 */
public class 前缀树208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c-'a';
                if (node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix){
            Trie node =this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i) ;
                Trie[] children = node.children;
                if (children[c-'a'] == null){
                    return null;
                }
                node = children[c-'a'];
            }
            return node;
        }
    }

}
