/**
 * 根据桥接词生成新文本
 * @author asus
 *
 */
public class GenerateNewText {

	public static String generateNewText(VNode[] mVertex,String inputText) {
		int exsit = 0;
		String[] str = new String[100];
		String s = "";
		String str1 = "";
		String str2 = "";
		int num = 0;
		for (String retval : inputText.split(" ")) {
			str[num] = retval;
			num++;
		}
		for (int i = 0; i < num; i++) {
			exsit = 0;
			str2 = QueryBridgeWords.queryBridgeWords(mVertex,str[i], str[i + 1]);
			s += str[i];
			if (exsit == 1) {

				for (String retval : str2.split(",")) {
					str1 = retval;
					s += " ";
					s += str1;
					break;
				}
			}
			s += " ";

		}
		System.out.println(s);
		return s;
	}
}
