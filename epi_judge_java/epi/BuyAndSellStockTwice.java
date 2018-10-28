package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    Double minPrice=Double.MAX_VALUE,reverseProfit=0.0,forwardProfit=0.0;
    Double maxPrice=Double.MIN_VALUE,profit=0.0;
    List<Double> forward=new ArrayList<>();
    for(Double price:prices){
      forward.add(Math.max(profit,price-minPrice));
      forwardProfit=Math.max(forwardProfit,Math.max(profit,price-minPrice));
      minPrice=Math.min(minPrice,price);
    }
    for(int k=prices.size()-1;k>=1;k--){
      reverseProfit=Math.max(reverseProfit,maxPrice-prices.get(k));
      profit=Math.max(profit,forward.get(k-1)+reverseProfit);
      maxPrice=Math.max(prices.get(k),maxPrice);
    }
    return Math.max(profit,forwardProfit);  //Fix if there can be at most two buy and sells
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
