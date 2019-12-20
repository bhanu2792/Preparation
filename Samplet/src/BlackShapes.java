import java.util.ArrayList;

public class BlackShapes {
	
	public static void main(String[] arg0) {
		ArrayList<String> s = new ArrayList<String>();
		String A = "OOOXOOO";
		String B = "OOXXOXO";
		String C = "OXOOOXO";
		s.add(A);
		s.add(B);
		s.add(C);
		
		System.out.println(black(s));
	} 
	

	public static int black(ArrayList<String> A) {
		int row = A.size();
		int col = A.get(0).length();
		boolean[][] isVisit = new boolean[row][col];
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A.get(i).charAt(j) == 'X' && isVisit[i][j] == false) {
					DFS(A, isVisit, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isValid(ArrayList<String> A, int ro, int co, boolean[][] visit) {
		if (ro >= 0 && ro < A.size() && co >= 0 && co < A.get(0).length() && !visit[ro][co]
				&& A.get(ro).charAt(co) == 'X') {
			return true;
		}

		return false;
	}

	public static void DFS(ArrayList<String> A, boolean[][] visit, int r, int c) {
		int[] row = { -1, 0, 0, 1 };
		int[] col = { 0, -1, 1, 0 };

		visit[r][c] = true;

		for (int i = 0; i < 4; i++) {
			if (isValid(A, r + row[i],  c + col[i], visit)) {
				DFS(A, visit, r + row[i], c + col[i]);
			}
		}
	}
}
