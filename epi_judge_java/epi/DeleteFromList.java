package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class DeleteFromList {

  // Delete the node immediately following aNode. Assumes aNode is not a tail.
  public static void deleteList(ListNode<Integer> aNode) {
    int uniq=0;
    List<Integer> a=aNode.toArray();
    for(int i=0;i<aNode.size();i++){
      if (a.get(i)!=a.get(uniq)){
        a.set(++uniq,a.get(i));
      }
    }
    return;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
