

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Graph {

	private int vertex = 0; // ����ͼ�ж���ĸ���
	private int edge = 0; // ����ͼ�бߵĸ���
	public int exsit = 0; // ��ʶ��������֮���Ƿ����ŽӴʣ�(1Ϊ����)
	private VNode[] mVertex; // ����ĵ�ļ���(�ظ��ĵ��Ϊ*)
	private String[] StrPath = new String[100];
	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

	public VNode[] getmVertex() {
		return mVertex;
	}

	public void setmVertex(VNode[] mVertex) {
		this.mVertex = mVertex;
	}

	public String[] getStrPath() {
		return StrPath;
	}

	public void setStrPath(String[] strPath) {
		StrPath = strPath;
	}

	public int getNumofPath() {
		return NumofPath;
	}

	public void setNumofPath(int numofPath) {
		NumofPath = numofPath;
	}


	private int NumofPath = 0;

	Graph(int v, int e, String[] w) // ͼ�Ĺ��캯��
	{
		edge = e;
		mVertex = new VNode[v];
		vertex++;
		mVertex[0] = new VNode();
		mVertex[0].data = w[0];
		mVertex[0].firstEdge = null;
		for (int i = 1; i < v; i++) // ���춥��
		{
			mVertex[i] = new VNode();
			int flag1 = 0;
			for (int j = 0; j < i; j++) {
				if (mVertex[j].data.equals(w[i])) {
					flag1 = 1;
				}
			}
			if (flag1 == 0) {
				vertex++;
				mVertex[i].data = w[i];
				mVertex[i].firstEdge = null;
			}
		}
		for (int i = 0; i < edge; i++) // �����
		{
			String str1 = w[i];
			String str2 = w[i + 1];
			int p1 = getPosition(str1);
			int p2 = getPosition(str2);
			ENode node1 = new ENode();
			node1.ivex = p2;
			if (mVertex[p1].firstEdge == null) {
				mVertex[p1].firstEdge = node1;
				mVertex[p1].firstEdge.weight++;
			} else {
				int flag = 0;
				ENode t = mVertex[p1].firstEdge;
				while (t != null) {
					if (t.ivex == node1.ivex) {
						t.weight++;
						flag = 1;
						break;
					}
					t = t.nextEdge;
				}
				if (flag == 0) {
					linkNext(mVertex[p1].firstEdge, node1);
				}
			}
		}
	}

	// ��node�ڵ�������list����
	public static void linkNext(ENode list, ENode node) {
		ENode t = list;
		while (t.nextEdge != null) {
			t = t.nextEdge;
		}
		t.nextEdge = node;
		t.nextEdge.weight++;
	}

	// ����ַ������ڽӱ�ͷ�е�λ��
	public int getPosition(String s) {
		int po = 0;
		for (int i = 0; i < mVertex.length; i++) {
			if (mVertex[i].data.equals(s)) {
				po = i;
				break;
			}
		}
		return po;
	}

	public String getStr() {
		String myStr = "";
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextLine()) {
			String str1 = scan.nextLine();
			myStr = myStr + str1;
		}
		scan.close();
		System.out.println(myStr);
		return myStr;
	}

	

	// ��ѯword1��word2���ŽӴ�
	
	

	 public static void WriteToFile(List<String> words, File file) {

			FileWriter writer = null;
			try {
				writer = new FileWriter(file);
				for (String word : words) {
					writer.write(word);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	 public static void OpenGra(String workSpace, String wordPath) {
			try {
				String[] cmd = { workSpace, wordPath };
				Process proc = Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test;
		String []words= {"to", "explore", "strange", "new", "worlds", "to", "seek", "out", "new", "life", "and", "new", "civilizations"};
		Graph g=new Graph(13, 12, words);
		test=QueryBridgeWords.queryBridgeWords(g.getmVertex(),"���", "and");
		System.out.println(test);
	}

}

