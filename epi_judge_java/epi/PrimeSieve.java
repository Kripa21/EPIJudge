package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    List<Integer> primes=new ArrayList<>();
    if(n==1)
      return primes;
    //List<Boolean> isPrime=new ArrayList<>(n);
    //When you call new ArrayList<Integer>(10), you are setting the list's initial capacity, not its size.
    List<Boolean> isPrime=new ArrayList<>(Collections.nCopies(n+1,Boolean.TRUE));

    isPrime.set(0,Boolean.FALSE);
    isPrime.set(1,Boolean.FALSE);
    for(int i=2;i<n+1;i++){
      if(isPrime.get(i)){
        primes.add(i);
        for(int k=i,inc=k;k<n+1;k=k+inc){
          isPrime.set(k,Boolean.FALSE);
        }
      }
    }
    return primes;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
