
// 邻接表中表对应的链表的顶点
public class ENode {
	int ivex; // 该边所指向的顶点的位置
	ENode nextEdge; // 指向下一条弧的指针
	int weight = 0; // 边的权重
	Boolean hasvisted = false; // 该边是否访问过
	public int getIvex() {
		return ivex;
	}
	public void setIvex(int ivex) {
		this.ivex = ivex;
	}
	public ENode getNextEdge() {
		return nextEdge;
	}
	public void setNextEdge(ENode nextEdge) {
		this.nextEdge = nextEdge;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Boolean getHasvisted() {
		return hasvisted;
	}
	public void setHasvisted(Boolean hasvisted) {
		this.hasvisted = hasvisted;
	}
	

}
