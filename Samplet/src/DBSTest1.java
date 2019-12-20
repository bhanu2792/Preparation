import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DBSTest1 {

	public static void main(String[] arg0) {
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(1);
		in.add(2);
		in.add(3);
		in.add(1);
		in.add(2);
		in.add(2);

		deleteProducts(in, 2);
	}

	public static int deleteProducts(List<Integer> ids, int m) {
		// Write your code here
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (Integer i : ids) {
			if (hm.containsKey(i)) {
				hm.put(i, hm.get(i) + 1);
			} else {
				hm.put(i, 1);
			}
		}
		Map<Integer, Integer> hm1 = sortByValue(hm);
		for (Map.Entry<Integer, Integer> entry : hm1.entrySet()) {
			if (m < entry.getValue()) {
				hm.put(entry.getKey(), entry.getValue() - m);
				break;
			} else if (m > entry.getValue()) {
				m = m - entry.getValue();
				hm.remove(entry.getKey());
			} else {
				hm.remove(entry.getKey());
				break;
			}
		}

		return hm.size();
	}

	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

}
