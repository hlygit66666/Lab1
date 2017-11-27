import java.util.Random;
/**
 * Ëæ»úÓÎ×ß
 * @author asus
 *
 */
public class RandomWalk {
	public static String randomWalk(VNode[] mVertex, int edge) {
		String s = "";
		int min = 0;
		int max = edge + 1;
		int num = 0;
		Random random = new Random();
		int r = random.nextInt(max) % (max - min + 1) + min;
		while (mVertex[r].data == "*") {
			r = random.nextInt(max) % (max - min + 1) + min;
		}
		int[] order = new int[edge + 10];
		for (int i = 0; i < edge + 10; i++) {
			order[i] = -1;
		}
		order[num] = r;
		if (mVertex[r].firstEdge != null) {
			ENode e = mVertex[r].firstEdge;
			ENode p = mVertex[r].firstEdge;
			int numofv = 0;
			while (p != null) {
				p = p.nextEdge;
				numofv++;
			}
			int r1 = random.nextInt(numofv) % (numofv - 1 + 1) + 1;
			while (r1 != 1) {
				e = e.nextEdge;
				r1--;
			}
			if (e != null) {
				e.hasvisted = true;
				order[num] = e.ivex;
				num++;
			}
			ENode next = mVertex[e.ivex].firstEdge;
			while (next != null) {
				int num1 = 0;
				int flag = 0;
				ENode p1 = next;
				while (p1 != null) {
					if (p1.hasvisted == false) {
						flag = 1;
					}
					p1 = p1.nextEdge;
					num1++;
				}
				if (flag == 0) {
					break;
				}
				r1 = random.nextInt(num1) % (num1 - 1 + 1) + 1;
				while (r1 != 1) {
					next = next.nextEdge;
					r1--;
				}
				if (next != null) {
					if (next.hasvisted != true) {
						next.hasvisted = true;
						order[num] = next.ivex;
						num++;
						next = mVertex[next.ivex].firstEdge;
					}
				}
			}

			for (int i = 0; order[i] != -1; i++) {
				s += mVertex[order[i]].data;
				s += " ";
			}
		} else {
			s = mVertex[r].data;
		}
		System.out.println(s);
		return s;
	}
}
