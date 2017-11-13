package lab_1;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello2");
		ReadFromFile read=new ReadFromFile();
		System.out.println("�������ļ�·����");
		Scanner sc = new Scanner(System.in);
		String f = sc.nextLine();
		File file = new File(f);//D:/work/java/RFF/test.txt
		while(file.exists()==false) {
			System.out.println("�������ļ�·����");
			sc = new Scanner(System.in);
			f = sc.nextLine();
			file = new File(f);
		}
		List<String> words = read.getLowerCaseWords(file); 
		
		read.WriteToFile(words, new File("C:/lab/output.txt"));
		
		int vex=words.size();
		int edge=words.size()-1;
		String [] s=new String[words.size()];
		words.toArray(s);
		Graph g=new Graph(vex,edge,s);
		g.showDirectedGraph();
		String func;
		System.out.println("lalalala");
		System.out.println('\n'+"��ѯ�ŽӴʰ�1���������ı���2�����·����3��������߰�4���˳���5��");
		func = sc.nextLine();
		
			if(func.equals("1")==true) {
				String QS1,QS2;
		        System.out.println("������Ų�ѯ��word1��");
		        QS1 = sc.nextLine();
		        QS1.toLowerCase();
		        System.out.println("������Ų�ѯ��word2��");
		        QS2 = sc.nextLine();
		        QS2.toLowerCase();
		        String result;
		        result = g.queryBridgeWords(QS1, QS2);
		        if(g.exsit==1)
		        {
		        	System.out.println("The bridge words from "+"\""+QS1+"\""+" to "+ "\""+QS2+"\""+" are:"+result);
		        }
		        else
		        {
		        	System.out.println(result);
		        }
		        
			}else if(func.equals("2")==true) {
				System.out.println("�������ı��ļ���");
				String NT;
				NT = sc.nextLine();//Seek to explore new and exciting synergies
				g.generateNewText(NT);			
			}else if(func.equals("3")==true) {
				
				String SP1,SP2;
				System.out.println("�������word2Ϊ**�����������ͼ�����ж�������·��");
				System.out.println("�������·����word1��");
			    SP1 = sc.nextLine();
			    SP1.toLowerCase();
			    System.out.println("�������·����word2��");
			    SP2 = sc.nextLine();
			    SP2.toLowerCase();
			    g.calcShortestPath(SP1, SP2);
			}else if(func.equals("4")==true) {
				g.randomWalk();			
			}else {
				System.out.println("�������");
			}
			System.out.println("��ѯ�ŽӴʰ�1���������ı���2�����·����3��������߰�4��");
			func = sc.nextLine();
		
		sc.close();
		}
	
}



