import java.util.ArrayList;
import java.util.Scanner;

// 0 is safe
// 1 is not
class Path {
	int row;
	int col;

	Path(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class ContestQue4 {
	public static int minSize = 0;
	static ArrayList<Path> result = new ArrayList<>();

	static boolean isSafe(int maze[][], int x, int y, int N, int M, int visited[][]) {
		return (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] == 0 && visited[x][y] == 0);
	}

	static boolean solveMaze(int maze[][], int N, int M, int si, int sj, int di, int dj, int visited[][],
			ArrayList<Path> path) {
		if (solveMazeUtil(maze, si, sj, di, dj, N, M, visited, path) == false) {
			return false;
		}
		return true;
	}

	static void printPath(ArrayList<Path> path) {
		int l = path.size();
		for (int i = 0; i < l; i++) {
			if (i < l - 1)
				System.out.print(path.get(i).row + "," + path.get(i).col + "-> ");
			else
				System.out.print(path.get(i).row + "," + path.get(i).col);
		}
	}

	static boolean solveMazeUtil(int maze[][], int x, int y, int di, int dj, int N, int M, int visited[][],
			ArrayList<Path> path) {
		if (x == di && y == dj) {
			if (path.size() < minSize) {
				minSize = path.size();
				result.clear();
				for (Path i : path)
					result.add(new Path(i.row, i.col));
				result.add(new Path(x, y));
			}
		}
		if (isSafe(maze, x, y, N, M, visited) == true) {
			visited[x][y] = 1;
			path.add(new Path(x, y));
			if (solveMazeUtil(maze, x + 1, y, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x + 1, y + 1, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x + 1, y - 1, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x - 1, y, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x - 1, y + 1, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x - 1, y - 1, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x, y + 1, di, dj, N, M, visited, path))
				return true;
			if (solveMazeUtil(maze, x, y - 1, di, dj, N, M, visited, path))
				return true;
			visited[x][y] = 0;
			path.remove(path.size() - 1);
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		int T, si, sj, di, dj, N, M, B;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int maze[][] = new int[N][M];
			B = sc.nextInt();
			si = sc.nextInt();
			sj = sc.nextInt();
			di = sc.nextInt();
			dj = sc.nextInt();
			for (int j = 0; j < B; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				maze[x][y] = 1;
			}
			int visited[][] = new int[N][M];
			ArrayList<Path> path = new ArrayList<>();
			result = new ArrayList<>();
			minSize = Integer.MAX_VALUE;
			solveMaze(maze, N, M, si, sj, di, dj, visited, path);
			if (result.size() > 0) {
				System.out.println(result.size() - 1);
				printPath(result);
			} else {
				System.out.println("-1");
			}
		}

	}

}
