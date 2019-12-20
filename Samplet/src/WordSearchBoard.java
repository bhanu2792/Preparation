import java.util.ArrayList;
import java.util.HashSet;

public class WordSearchBoard {

	public static void main(String[] arg0) {
		ArrayList<String> s = new ArrayList<String>();
		String A = "BCCECCAGAG";
		String B = "BDDEACADCD";
		String C = "BFDAAFBEGB";
		String D = "FEDAEEECAG";
		String E = "DADFAAEDCC";
		String F = "CBAAFAFGGC";
		String G = "FCGFBADAAA";
		String H = "BAGEFBEAEE";
		String I = "FGAFGBBFAE";
		String J = "ABCDFAGFEE";
		s.add(A);
		s.add(B);
		s.add(C);
		s.add(D);
		s.add(E);
		s.add(F);
		s.add(G);
		s.add(H);
		s.add(I);
		s.add(J);
		int ans = exist(s, "DACCAAB");
		System.out.println(ans);
	}

	public static int exist(ArrayList<String> A, String B) {
		int row = A.size();
		int col = A.get(0).length();
		boolean[][] isVisit = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A.get(i).charAt(j) == B.charAt(0) && isVisit[i][j] == false) {
					HashSet<Character> hs = new HashSet<Character>();
					hs.add(B.charAt(0));
					if (DFS(A, B, isVisit, i, j, hs, 1, B.charAt(0)) == 1)
						return 1;
				}
			}
		}
		return 0;
	}

	public static boolean isValid(ArrayList<String> A, String B, int ro, int co, boolean[][] visit, int idx) {
		if (ro >= 0 && ro < A.size() && co >= 0 && co < A.get(0).length() && !visit[ro][co]
				&& A.get(ro).charAt(co) == B.charAt(idx)) {
			return true;
		}

		return false;
	}

	public static int DFS(ArrayList<String> A, String B, boolean[][] visit, int r, int c, HashSet<Character> hs,
			int count, char prev) {
		int[] row = { -1, 0, 0, 1 };
		int[] col = { 0, -1, 1, 0 };
		int lf = 0;
		int rf = 0;
		visit[r][c] = true;
		if (count == B.length()) {
			return 1;
		}

		for (int i = 0; i < 4; i++) {
			if (isValid(A, B, r + row[i], c + col[i], visit, count)) {
				hs.add(B.charAt(count));
				prev = B.charAt(count);
				lf = DFS(A, B, visit, r + row[i], c + col[i], hs, count + 1, prev);
			} else if (hs.contains(B.charAt(count)) && prev != B.charAt(count)) {
				prev = B.charAt(count);
				rf = DFS(A, B, visit, r, c, hs, count + 1, prev);
			}

		}

		return lf | rf;
	}
}
