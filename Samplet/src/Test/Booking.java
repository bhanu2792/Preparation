package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Booking {

  public static void main(String[] arg0) {

    List<List<Integer>> employeeCalls = new ArrayList<List<Integer>>();
    List<Integer> ar = new ArrayList<Integer>();
    ar.add(1);
    ar.add(1481122000);
    ar.add(1481122020);
    employeeCalls.add(ar);

    List<Integer> ar1 = new ArrayList<Integer>();
    ar1.add(3);
    ar1.add(1481122000);
    ar1.add(1481122020);
    employeeCalls.add(ar1);

    List<Integer> ar2 = new ArrayList<Integer>();
    ar2.add(1);
    ar2.add(1481122020);
    ar2.add(1481122040);
    employeeCalls.add(ar2);
    
    List<Integer> ar3 = new ArrayList<Integer>();
    ar3.add(2);
    ar3.add(1481122020);
    ar3.add(1481122040);
    employeeCalls.add(ar3);
    
    List<Integer> ar4 = new ArrayList<Integer>();
    ar4.add(3);
    ar4.add(1481122040);
    ar4.add(1481122060);
    employeeCalls.add(ar4);
    
    List<Integer> ar5 = new ArrayList<Integer>();
    ar5.add(1);
    ar5.add(1481122050);
    ar5.add(1481122060);
    employeeCalls.add(ar5);
    
    List<Integer> ar6 = new ArrayList<Integer>();
    ar6.add(3);
    ar6.add(1481122070);
    ar6.add(1481122090);
    employeeCalls.add(ar6);

    List<List<Integer>> an = employeeWithLesserThanKBreaks(employeeCalls, 2);
    for (List<Integer> a : an) {
      for (Integer m : a) {
        System.out.print(m + " ");
      }
      System.out.println();
    }

  }

  static class EmpTime {
    int startTime;
    int endTime;

    public EmpTime(int s, int e) {
      // TODO Auto-generated constructor stub
      startTime = s;
      endTime = e;
    }
  }

  public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
    // Write your code here

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashMap<Integer, ArrayList<EmpTime>> hm = new HashMap<Integer, ArrayList<EmpTime>>();
    for (List<Integer> l : employeeCalls) {
      ArrayList<EmpTime> list;
      if (hm.containsKey(l.get(0))) {
        list = hm.get(l.get(0));
      } else {
        list = new ArrayList<EmpTime>();
      }
      list.add(new EmpTime(l.get(1), l.get(2)));
      hm.put(l.get(0), list);
    }

    Iterator<Map.Entry<Integer, ArrayList<EmpTime>>> itr = hm.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<Integer, ArrayList<EmpTime>> li = itr.next();
      int count = 0;
      List<EmpTime> empTime = li.getValue();
      int size = empTime.size();
      for (int i = 0; i < size - 1; i++) {
        if (empTime.get(i).endTime < empTime.get(i + 1).startTime) {
          count++;
        }
      }
      if (count < k) {
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(li.getKey());
        ls.add(count);
        ans.add(ls);
      }
    }
    return ans;
  }
}
