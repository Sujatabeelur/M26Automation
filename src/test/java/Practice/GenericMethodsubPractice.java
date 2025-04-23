package Practice;

public class GenericMethodsubPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int substraction= sub(200,10);
		System.out.println(sub(substraction,10));
		System.out.println(sub(substraction,20));
			

	}

	
	public static int sub(int a, int b) {
		int c=a-b;
		return c;
	}
}
