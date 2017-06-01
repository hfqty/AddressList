

public class Test {

	public static void main(String[] args) {
		//1到10位字母
		System.out.println("name66".matches("[a-zA-Z]{1,10}"));//false
		//1位数字
		System.out.println("60".matches("[0-9]{1}"));
		System.out.println("60".matches("\\d{1}"));
	}

}
