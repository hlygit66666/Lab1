
// �ڽӱ��б��Ӧ������Ķ���
public class ENode {
	int ivex; // �ñ���ָ��Ķ����λ��
	ENode nextEdge; // ָ����һ������ָ��
	int weight = 0; // �ߵ�Ȩ��
	Boolean hasvisted = false; // �ñ��Ƿ���ʹ�
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
