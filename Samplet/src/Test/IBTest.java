package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IBTest {
  static TrieNode root;

  static class TrieNode {
    TrieNode[] trie = new TrieNode[26];
    boolean isEndofWord;

    TrieNode() {
      isEndofWord = false;
      for (int i = 0; i < 26; i++) {
        trie[i] = null;
      }
    }
  }

  public void insert(String str) {
    int len = str.length();
    TrieNode node = root;
    for (int i = 0; i < len; i++) {
      int index = str.charAt(i) - 'a';
      if (node.trie[index] == null) {
        node.trie[index] = new TrieNode();
      }
      node = node.trie[index];
    }
    node.isEndofWord = true;
  }

  public boolean search(String str) {
    int len = str.length();
    TrieNode node = root;
    for (int i = 0; i < len; i++) {
      int index = str.charAt(i) - 'a';
      if (node.trie[index] == null) {
        return false;
      }
      node = node.trie[index];
    }
    if (node != null && node.isEndofWord == true) {
      return true;
    }
    return false;
  }

  public ArrayList<Integer> solve(String A, ArrayList<String> B) {
    String[] st = A.split("_");
    int len = st.length;
    root = new TrieNode();
    for (int i = 0; i < len; i++) {
      insert(st[i]);
    }
    HashMap<Integer, Integer> ts = new HashMap<Integer, Integer>();
    int l = B.size();
    for (int i = 0; i < l; i++) {
      String[] s = B.get(i).split("_");
      int le = s.length;
      int count = 0;
      for (int j = 0; j < le; j++) {
        if (search(s[j])) {
          count++;
        }
      }
      ts.put(i, count);
    }

    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(ts.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return (o2.getValue()).compareTo(o1.getValue());
      }
    });

    ArrayList<Integer> ans = new ArrayList<Integer>();
    for (Map.Entry<Integer, Integer> aa : list) {
      ans.add(aa.getKey());
      
    }
    
    return ans;
  }

  public static void main(String[] arg0) {
    IBTest ob = new IBTest();
    String S = "cool_ice_wifi";
    ArrayList<String> ar = new ArrayList<String>();
    ar.add("water_is_cool");
    ar.add("cold_ice_drink");
    ar.add("cool_wifi_speed");
    
    System.out.println(ob.solve(S, ar));
  }
}
