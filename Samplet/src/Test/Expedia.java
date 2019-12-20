package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Expedia {

  public static void main(String[] arg0) {
    int employeesNodes = 5;
    int host = 1;
    List<Integer> employeesFrom = new ArrayList<Integer>();
    employeesFrom.add(1);
    employeesFrom.add(1);
    employeesFrom.add(1);
    employeesFrom.add(2);
    employeesFrom.add(3);
    List<Integer> employeesTo = new ArrayList<Integer>();
    employeesTo.add(2);
    employeesTo.add(5);
    employeesTo.add(3);
    employeesTo.add(4);
    employeesTo.add(5);
    List<Integer> ar = order(employeesNodes, employeesFrom, employeesTo, host);
    for (int i = 0; i < ar.size(); i++) {
      System.out.println(ar.get(i));
    }
  }

  static class Graph {

    ArrayList<Integer> al[];

    public Graph(int v) {

      al = new ArrayList[v + 1];
      for (int i = 0; i <= v; i++) {
        al[i] = new ArrayList<Integer>();
      }
    }

    public void add(Graph g, int u, int v) {
      al[u].add(v);
      al[v].add(u);
    }
  }

  public static List<Integer> order(int employeesNodes, List<Integer> employeesFrom, List<Integer> employeesTo,
      int host) {
    List<Integer> t = new ArrayList<Integer>();

    int len = employeesFrom.size();
    Graph g = new Graph(employeesNodes);
    for (int i = 0; i < len; i++) {
      int u = employeesFrom.get(i);
      int v = employeesTo.get(i);
      g.add(g, u, v);
    }
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    PriorityQueue<Integer> p = new PriorityQueue<Integer>();
    
    boolean[] isVisit = new boolean[g.al.length];
    q.add(host);
    isVisit[host] = true;
    boolean flag = false;
    while (!q.isEmpty() || !p.isEmpty()) {
      int n;
      if (!q.isEmpty()) {
        n = q.poll();
        flag = false;
      } else {
        n = p.poll();
        flag = true;
      }

      if (n != host) {
        t.add(n);
      }

      for (Integer i : g.al[n]) {
        if (isVisit[i] == false) {
          if (!flag) {
            p.add(i);
          } else {
            q.add(i);
          }

          isVisit[i] = true;

        }
      }
    }

    return t;
  }
}
