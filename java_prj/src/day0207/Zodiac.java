package day0207;

public class Zodiac {
	public static final int MONKEY = 0;
	public static final int CHIKEN = 1;
	public static final int DOG = 2;
	public static final int PIG = 3;
	public static final int MOUSE = 4;
	public static final int COW = 5;
	public static final int TIGER = 6;
	public static final int RABBIT = 7;
	public static final int DRAGON = 8;
	public static final int SNACKE = 9;
	public static final int HORESE = 10;
	public static final int SHEEP = 11;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=1997;
		int zodiacFlag = year%12;
		switch(zodiacFlag) {
		case MONKEY:System.out.println("¿ø¼þÀÌ¶ì");break;
		case CHIKEN:System.out.println("´ß¶ì");break;
		case DOG:System.out.println("°³¶ì");break;
		case PIG:System.out.println("µÅÁö¶ì");break;
		case MOUSE:System.out.println("Áã¶ì");break;
		case COW:System.out.println("¼Ò¶ì");break;
		case TIGER:System.out.println("È£¶ûÀÌ¶ì");break;
		case RABBIT:System.out.println("Åä³¢¶ì");break;
		case DRAGON:System.out.println("¿ë¶ì");break;
		case SNACKE:System.out.println("¹ì¶ì");break;
		case HORESE:System.out.println("¸»¶ì");break;
		case SHEEP:System.out.println("¾ç¶ì");break;
		default: System.out.println("¿À·ù");
		}//end switch
	}//end main
}//end class
