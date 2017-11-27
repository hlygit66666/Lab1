/**
 * 最短路径
 * @author asus
 *
 */
public class CalcShortestPath {

	// 当输入的word2=="**"时，计算word1与图中其他点的最短路径
	public static String calcShortestPath(VNode[] mVertex, int edge, int NumofPath, String[] StrPath, String word1,
			String word2) {
		String s = "";
		int[][] g = new int[edge + 1][edge + 1];
		int[][] path = new int[edge + 1][edge + 1];
		int pos1 = 0;
		int pos2 = 0;
		int v;
		ENode p;
		if (word2.equals("**")) {
			for (int i = 0; i < edge + 1; i++) {
				if (!(mVertex[i].data.equals(word1)) && mVertex[i].data != "**" && mVertex[i].data != "*") {
					NumofPath = 0;
					for (int j = 0; j < 100; j++) {
						StrPath[j] = null;
					}
					CalcShortestPath.calcShortestPath(mVertex, edge, NumofPath, StrPath, word1, mVertex[i].data);
				}
			}
		} else {
			for (int i = 0; i < edge + 1; i++) {
				if (mVertex[i].data.equals(word1)) {
					pos1 = i;
				}
				if (mVertex[i].data.equals(word2)) {
					pos2 = i;
				}
			}
			for (int i = 0; i < edge + 1; i++) {
				for (int j = 0; j < edge + 1; j++) {
					g[i][j] = 10000;
					path[i][j] = -1;
				}
			}

			for (int i = 0; i < edge + 1; i++) {
				if (mVertex[i].data.equals("*")) {
					for (int j = 0; j < edge + 1; j++) {
						g[i][j] = -1;
						g[j][i] = -1;
					}
				} else {
					p = mVertex[i].firstEdge;
					while (p != null) {
						v = p.ivex;
						g[i][v] = p.weight;
						path[i][v] = -1;
						p = p.nextEdge;
					}
					g[i][i] = 0;
				}
			}
			for (int k = 0; k < g[0].length; k++) {
				for (int i = 0; i < g[0].length; i++) {
					for (int j = 0; j < g[0].length; j++) {
						if (g[i][k] != -1 && g[k][j] != -1 && g[i][j] != -1 && ((g[i][k] + g[k][j]) < g[i][j]))// 遇到更小的路径则更新
						{
							g[i][j] = g[i][k] + g[k][j];
							path[i][j] = k;
						}
					}
				}
			}
			if (g[pos1][pos2] == 10000) {
				s = word1 + "到" + word2 + "不可达";
				System.out.println(s);
			} else {
				System.out.println(word1 + "到" + word2 + "的最短路径为：");
				System.out.println(mVertex[pos1].data + "->");
				CalcShortestPath.dis(mVertex,pos1, pos2, path);
				System.out.println(mVertex[pos2].data);
			}
		}
		return s;
	}

	// 递归输出最短路径所经过的点
	public static int dis(VNode[] mVertex,int num1, int num2, int path[][]) {
		int pos1 = num1;
		int pos2 = num2;
		int p1;
		int pathofv = path[pos1][pos2];
		if (pathofv >= 0) {
			p1 = CalcShortestPath.dis(mVertex,pos1, pathofv, path);
			System.out.println(mVertex[pathofv].data + "->");
			pathofv = p1 + CalcShortestPath.dis(mVertex,pathofv, pos2, path);
		}

		return pathofv;
	}
}
