
import java.util.ArrayList;

public class CaptureRegion {

	public static void main(String[] arg0) {
		
		ArrayList<ArrayList<Character>> aa = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> s = new ArrayList<Character>();
		s.add('X');
		s.add('O');
		s.add('O');
		s.add('O');
		s.add('O');
		s.add('O');
		s.add('O');
		s.add('X');
		aa.add(s);
		
		ArrayList<Character> s1 = new ArrayList<Character>();
		s1.add('X');
		s1.add('X');
		s1.add('O');
		s1.add('O');
		s1.add('X');
		s1.add('O');
		s1.add('O');
		s1.add('X');
		aa.add(s1);
		
		ArrayList<Character> s2 = new ArrayList<Character>();
		s2.add('O');
		s2.add('X');
		s2.add('X');
		s2.add('O');
		s2.add('X');
		s2.add('O');
		s2.add('X');
		s2.add('X');
		aa.add(s2);
		
		/*
		 * ArrayList<Character> s3 = new ArrayList<Character>(); s3.add('X');
		 * s3.add('X'); s3.add('X'); s3.add('X'); aa.add(s3);
		 */
		black(aa);
	
	}

	public static void black(ArrayList<ArrayList<Character>> a) {

		int row = a.get(0).size();
		int col = a.size();
		
		int i = 0;
		int j = 0;
		
		while (j != row) {
			if (a.get(i).get(j) == 'O') {
				a.get(i).set(j, '-');
				DFS(a, i, j);
			}
		//	System.out.println("i is" + i + "j is" + j);
			j++;
		}
		i = 1;
		j = 0;
		
		while (i != col) {
		//	System.out.println("i is" + i + "j is" + j);
			if (a.get(i).get(j) == 'O') {
				a.get(i).set(j, '-');
				DFS(a, i, j);
			}
			i++;
		}
		i = a.size() - 1;
		j = 1;
		
		while (j != row) {
			if (a.get(i).get(j) == 'O') {
				a.get(i).set(j, '-');
				DFS(a, i, j);
			}
		//	System.out.println("i is" + i + "j is" + j);
			j++;
		}
		i = a.get(0).size() - 1;
		j = 1;
				
		while (j != col) {
			if (a.get(j).get(i) == 'O') {
				a.get(j).set(i, '-');
				DFS(a, j, i);
			}
		//	System.out.println("j is" + j + "i is" + i);
			j++;
		}
		
		
		for (int m=0; m<col; m++) {
			for (int n=0; n<row; n++) {
				if (a.get(m).get(n) == '-') {
					a.get(m).set(n, 'O');
				} else if (a.get(m).get(n) == 'O') {
					a.get(m).set(n, 'X');
				}
				System.out.print(a.get(m).get(n)+" ");
			}
			System.out.println(); 
		}
	} 

	public static boolean isValid(ArrayList<ArrayList<Character>> A, int ro, int co) {
		if (ro >= 0 && ro < A.size() && co >= 0 && co < A.get(0).size() && A.get(ro).get(co) == 'O') {
			return true;
		}
		return false;
	}

	public static void DFS(ArrayList<ArrayList<Character>> A, int r, int c) {
		int[] row = { -1, 0, 0, 1 };
		int[] col = { 0, -1, 1, 0 };

		for (int i = 0; i < 4; i++) {
			if (isValid(A, r + row[i], c + col[i])) {
				A.get(r + row[i]).set(c + col[i], '-');
				DFS(A, r + row[i], c + col[i]);
			}
		}
	}
}
