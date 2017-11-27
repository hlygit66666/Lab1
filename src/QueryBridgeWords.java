/**
 * 查询桥接词
 * @author asus
 *
 */
public class QueryBridgeWords {
	
	public static String queryBridgeWords(VNode[] mVertex,String word1, String word2) {
		int exsit = 0;
		String s = "";
		if (!word1.matches("^[a-zA-Z]*") || !word1.matches("^[a-zA-Z]*")) {
			s = "请输入英文单词";
		} else {
			if (word1 == "" || word2 == "") {
				s = "请输入两个单词";
			} else {
				int num = 0;
				String[] Bword = new String[100];
				int po1 = 0;
				int po2 = 0;
				int flag1 = 0;
				int flag2 = 0;
				for (int i = 0; i < mVertex.length; i++) {
					if ((mVertex[i].data.equals(word1))) {
						po1 = i;
						flag1 = 1;
						break;
					}
				}
				for (int i = 0; i < mVertex.length; i++) {
					if ((mVertex[i].data.equals(word2))) {
						po2 = i;
						flag2 = 1;
						break;
					}
				}
				if (flag1 == 0 && flag2 == 1) {
					s = "No " + "\"" + word1 + "\"" + " in the graph";
				}
				if (flag1 == 1 && flag2 == 0) {
					s = "No " + "\"" + word2 + "\"" + " in the graph";
				}
				if (flag1 == 0 && flag2 == 0) {
					s = "No " + "\"" + word1 + " and " + "\"" + word2 + " in the graph";
				}
				if (flag1 == 1 && flag2 == 1) {
					ENode p = mVertex[po1].firstEdge;
					while (p != null) {
						int position = p.ivex;
						while (mVertex[position].firstEdge != null) {
							if (mVertex[position].firstEdge.ivex == po2) {
								Bword[num] = mVertex[position].data;
								num++;
								break;
							} else {
								mVertex[position].firstEdge = mVertex[position].firstEdge.nextEdge;
							}
						}
						p = p.nextEdge;
					}

					String str1 = "";
					if (num > 1) {
						for (int i = 0; i < num - 1; i++) {
							str1 += Bword[i];
							str1 += ",";
						}
					}
					str1 += Bword[num];
					if (num == 1) {
						str1 = Bword[0];
					}
					if (num == 0) {
						s = "No bridge words from " + "\"" + word1 + "\"" + " to " + "\"" + word2 + "\"" + "!";
					}
					if (flag1 == 1 && flag2 == 1 && num != 0) {
						exsit = 1;
						s = "The bridge words from " + "\"" + word1 + "\"" + " to " + "\"" + word2 + "\"" + " is :"
								+ str1;
					}
				}
			}
		}
		return s;
	}
}
