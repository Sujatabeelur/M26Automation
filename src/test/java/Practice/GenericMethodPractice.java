package Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=add(20,40);
		System.out.println(sum);
		
		System.out.println(add(sum,20));
		System.out.println(add(30,sum));
		
	}
		
		public static int add(int a,int b) {
			int c=a+b;
		   return c;
		}

	}


