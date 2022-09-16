package graphsPepcoding;

import java.util.LinkedList;
import java.util.Queue;
//Isko isliye rakha hai taaki hum bfs krte waqt ye jo nya treeka seekhe hai direction mei move krne ka using dirs, wo revise kr ske.
//Similar problems flood fill leetcode
public class rottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orangesRotting(int[][] grid) {
		Queue<Pair> q = new LinkedList<>();
		int fresh = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pair(i, j));
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}
		if (fresh == 0)
			return 0;

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int level = -1;

		while (q.size() > 0) {
			int size = q.size();
			level++;
			while (size-- > 0) {
				Pair rem = q.remove();

				for (int i = 0; i < dirs.length; i++) {
					int rdash = rem.row + dirs[i][0];
					int coldash = rem.col + dirs[i][1];
					if (rdash >= 0 && rdash < grid.length && coldash >= 0 && coldash < grid[0].length
							&& grid[rdash][coldash] == 1) {
						q.add(new Pair(rdash, coldash));
						grid[rdash][coldash] = 0;
						fresh--;
					}
				}
			}
		}

		if (fresh == 0)
			return level;
		else
			return -1;

	}

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}
