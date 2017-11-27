/**
 * 展示有向图
 * @author asus
 *
 */
public class ShowDirectedGraph {

	public static void showDirectedGraph(VNode[] mVertex) {
		System.out.printf("List Graph:\n");
		for (int i = 0; i < mVertex.length; i++) {
			System.out.println("------------");
			if (!(mVertex[i].data.equals("*"))) {
				System.out.println(mVertex[i].data);
				ENode node = mVertex[i].firstEdge;
				while (node != null) {
					System.out.println("->" + mVertex[node.ivex].data + "  weight:" + node.weight);
					node = node.nextEdge;
				}
			}
		}
	}
}
