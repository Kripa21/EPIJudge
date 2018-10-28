package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    int end=maxAdvanceSteps.size()-1;
    int maxReach=maxAdvanceSteps.get(0);
    for (int i=0;i<=maxReach;i++){
      maxReach=Math.max(i+maxAdvanceSteps.get(i),maxReach);
      if(maxReach>=end){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
