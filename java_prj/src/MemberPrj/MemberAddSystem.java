package MemberPrj;

public class MemberAddSystem {
	MemberVO[] list = new MemberVO[3];
	int count;
	public void register(Member member) {
		list[count] = member.input();
		count++;
	}
	
}
