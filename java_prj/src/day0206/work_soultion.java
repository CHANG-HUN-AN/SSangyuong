package day0206;

/**
 * work 에 대한 해설
 * 코딩은 처음엔 부분부분 짜는 것을 추천한다.
 * @author user
 */
public class work_soultion {
	//기본요금은 자주변경되지않아 constant 로 표현한다.
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	public static final int TAXI = 3800;
	
	public static void main(String[] args) {
		//대중교통인지 아닌지를 판단
		if(args[0].equals("버스")||args[0].equals("지하철")||args[0].equals("택시")) {
			//버스,지하철(구간요금계산 대상)인지 아닌지를 판단
			if(args[0].equals("버스")||args[0].equals("지하철")) {//구간요금대상
				int distance = Integer.parseInt(args[1]);//이용거리
				int typeFare = work_soultion.BUS; //버스를 기본요금으로 우선 설정
				int tempFare = 0; // 초과요금
				
				if(args[0].equals("지하철")){
					typeFare = work_soultion.SUBWAY;
				}//end if
				if(distance >10) {//10km를 초과한 경우의 초과요금
					tempFare = (((distance-10)/5)+1)*100;
				}//end if
				System.out.println("입력교통수단은"+args[0]+" 편도요금"+typeFare+"원, 초과요금"+tempFare+"원, 총결제 비용 "+(typeFare+tempFare)+"원 입니다");			}else{//단순요금 계산
				System.out.println("급할때 이용하는 교통수단 요금 3800원입니다.");
			}//end else
		}else {
			System.out.println("대중교통 아님");
		}//end else
	}//main
}//class
