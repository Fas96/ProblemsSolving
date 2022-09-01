package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TriesPrefixTree;

public class TrieImpl {
  private TrieNode root;
  public TrieImpl() {
    root=new TrieNode();

  }

  public void insert(String word) {
    TrieNode curNode=root;
    char[] arr=word.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        curNode.children.put(curChar,new TrieNode());
      }
      curNode=curNode.children.get(curChar);
    }
    curNode.isWord=true;
  }

  public boolean search(String word) {
    TrieNode curNode=root;
    char[] arr=word.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        return false;
      }
      curNode=curNode.children.get(curChar);
    }
    return curNode.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode curNode=root;
    char[] arr=prefix.toCharArray();
    for(char curChar:arr){
      if(!curNode.children.containsKey(curChar)){
        return false;
      }
      curNode=curNode.children.get(curChar);
    }
    return true;
  }
}
