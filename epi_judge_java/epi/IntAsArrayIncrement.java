package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    // TODO - you fill in here.

    //If you convert  it to array , then for adding the carry bit you might have to shift(o(n))
    //Use array list, shift operation is 0(1)
    /**
     Integer a[]=(Integer[]) A.toArray();
     int sum=0,carry=0;
     for (int i =a.length -1;i>=0;i--){
     sum=a[i]+1;
     a[i]=(sum+carry)%10;
     carry=sum/10;
     }
     **/
    int carry=1,val=0,n=A.size()-1;
    while (carry>0 & n>=0){
      val=(A.get(n)+carry)%10;
      carry=(A.get(n)+carry)/10;
      A.set(n,val);
      n--;
    }
    if (carry>0){
      A.add(0,carry);
    }

    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
