package day0206;

/**
 *企掻嘘搭呪舘引 km研 脊径閤焼 焼掘税 妊研 凧繕馬食 窒径
 *獄什-1250,走馬旦-1300,澱獣-3800
 *脊径嘘搭呪舘戚 獄什,走馬旦,澱獣心聖凶 域至 馬壱 3鯵税 企掻嘘搭戚 焼艦虞檎 "企掻嘘搭戚 焼観採歳 しじ,ししじ"窒径
 *獄什,走馬旦精 古5km原陥  100据税 蓄亜推榎戚 細澗陥 澱獣澗 奄沙推榎幻 窒径
 *獄什,走馬旦:脊径 嘘搭呪舘 xx 畷亀推榎 xx据,腎差推榎 xx据 廃含 20析奄層 嘘搭搾xxx据 脊艦陥.
 *澱獣:厭拝凶 戚遂馬澗 嘘搭呪舘 推榎 3800据脊艦陥.
 * @author user
 */
public class work {
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	public static final int TAXI = 3800;

	public static void main(String[] args) {
		String pubTrans = args[0]; //args研 痕呪稽 閤走省製
		int km =Integer.parseInt(args[1]);
		int price = 0;
		if(pubTrans.equals("獄什")||pubTrans.equals("走馬旦")) {
			if(km>10) {
				km = km -10;
				price += ((km/5)+1)*100;
			}
			if(pubTrans.equals("獄什")) {
				price += BUS;
				System.out.println("脊径嘘搭呪舘精"+pubTrans+" 畷亀推榎"+price+"据, 腎差推榎"+price*2+"据, 廃含 20析 奄層 嘘搭搾 "+price*2*20+"据 脊艦陥");
			}else{
				price += SUBWAY;
				System.out.println("脊径嘘搭呪舘精"+pubTrans+" 畷亀推榎"+price+"据, 腎差推榎"+price*2+"据, 廃含 20析 奄層 嘘搭搾 "+price*2*20+"据 脊艦陥");
			}
		}else if(pubTrans.equals("澱獣")) {
			System.out.println("厭拝凶 戚遂馬澗 嘘搭呪舘 推榎 3800据脊艦陥.");
		}else {
			System.out.println("企掻嘘搭戚 焼観採歳 しじ,ししじ");
		}//end else
	}
}