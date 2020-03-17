package day0206;

/**
 *대중교통수단과 km를 입력받아 아래의 표를 참조하여 출력
 *버스-1250,지하철-1300,택시-3800
 *입력교통수단이 버스,지하철,택시였을때 계산 하고 3개의 대중교통이 아니라면 "대중교통이 아닌부분 ㅇㅈ,ㅇㅇㅈ"출력
 *버스,지하철은 매5km마다  100원의 추가요금이 붙는다 택시는 기본요금만 출력
 *버스,지하철:입력 교통수단 xx 편도요금 xx원,왕복요금 xx원 한달 20일기준 교통비xxx원 입니다.
 *택시:급할때 이용하는 교통수단 요금 3800원입니다.
 * @author user
 */
public class work {
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	public static final int TAXI = 3800;

	public static void main(String[] args) {
		String pubTrans = args[0]; //args를 변수로 받지않음
		int km =Integer.parseInt(args[1]);
		int price = 0;
		if(pubTrans.equals("버스")||pubTrans.equals("지하철")) {
			if(km>10) {
				km = km -10;
				price += ((km/5)+1)*100;
			}
			if(pubTrans.equals("버스")) {
				price += BUS;
				System.out.println("입력교통수단은"+pubTrans+" 편도요금"+price+"원, 왕복요금"+price*2+"원, 한달 20일 기준 교통비 "+price*2*20+"원 입니다");
			}else{
				price += SUBWAY;
				System.out.println("입력교통수단은"+pubTrans+" 편도요금"+price+"원, 왕복요금"+price*2+"원, 한달 20일 기준 교통비 "+price*2*20+"원 입니다");
			}
		}else if(pubTrans.equals("택시")) {
			System.out.println("급할때 이용하는 교통수단 요금 3800원입니다.");
		}else {
			System.out.println("대중교통이 아닌부분 ㅇㅈ,ㅇㅇㅈ");
		}//end else
	}
}