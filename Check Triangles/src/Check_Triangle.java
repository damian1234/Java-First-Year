
public class Check_Triangle
{


	public static final int ACUTE_TRI = 2;
	public static final int RIGHT_ANGLED_TRI = 1;
	public static final int OBTUSE_TRI = 3;
	public static final double TINY_DIFF = 0.0001;
	public static final int NOT_TRI = 0;

	static boolean form_triangle(double[] ls)
	{
		if(ls.length == 3){
			if(!(ls[0] <= 0&& ls[1] <= 0&& ls[2] <= 0)){
				double largest = max(ls);
				double total = sum(ls);
				largest = 2*largest;
				if(largest < total){
					return true;
				}
			}
		}
		return false;
	}

	static int kind_triangle(double[] ls)
	{
		if(form_triangle(ls)){
			double total = sum(ls);
			double a = min(ls);
			double c = max(ls);
			double b = total-(a +c);
			c = c*c;
			a = a*a;
			b = b*b;
			double answer = c -(a + b);
			if(answer < 0){
				return ACUTE_TRI;
			}
			if(answer > 0){
				return OBTUSE_TRI;
			}
			return RIGHT_ANGLED_TRI;
		}
		return NOT_TRI;
	}


	static double sum(double[] arr)
	{
		double result = 0;
		for (int k = 0; k < arr.length; k++)
			result += arr[k];
		return result;
	}

	static double max(double[] arr)
	{
		int j = 0;
		int k = arr.length- 1;
		while ( j < k ) {
			if (arr[j] < arr[k])
				j++;
			else
				k--;
		}
		return arr[j];
	}

	static double min(double[] arr)
	{
		int j = 0;
		int k = arr.length - 1;
		while ( j < k )
			if (arr[j] > arr[k])
				j++;
			else
				k--;
		return arr[j];
	}
}
