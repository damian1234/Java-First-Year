
public class RationalNumber {
	private int Numerator;
	private int Denominator;
	public RationalNumber(int numerator, int denominator){
		Numerator = numerator;
		Denominator = denominator;
	}
	public RationalNumber(int numerator){
		Numerator = numerator;
		Denominator = 1;
	}
	public RationalNumber add(RationalNumber num){

		if(this.Denominator == num.Denominator){
			this.Numerator += num.Numerator;
		}
		else{
			this.Denominator *= num.Denominator;
			this.Numerator *= num.Denominator;
			num.Numerator *= (this.Denominator/num.Denominator);
			this.Numerator += num.Numerator;
			
		}
		return this;
	}
	public RationalNumber subtract(RationalNumber num){
		if(this.Denominator == num.Denominator){
			this.Numerator -= num.Numerator;
		}
		else{
			this.Denominator *= num.Denominator;
			this.Numerator *= num.Denominator;
			num.Numerator *= (this.Denominator/num.Denominator);
			this.Numerator -= num.Numerator;
		}
		return this;
	}
	public RationalNumber multiply(RationalNumber num){
		this.Numerator *= num.Numerator;
		this.Denominator *= num.Denominator;
		return this;
	}
	public RationalNumber divide(RationalNumber num){
		this.Numerator *= num.Denominator;
		this.Denominator *= num.Numerator;
		return this;
	}
	public boolean equals(RationalNumber num){
		RationalNumber num1 = num;
		RationalNumber num2 = this;
		num1.Numerator *= num2.Denominator;
		num1.Denominator *= num2.Denominator;
		num2.Numerator *= num1.Denominator;
		num2.Denominator *= num1.Denominator;
		if((num1.Numerator == num2.Numerator)&&(num1.Denominator == num2.Denominator)){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean lessThen(RationalNumber num){
		boolean result = false;
		RationalNumber num1 = this;
		RationalNumber num2 = num;
		num1.Numerator *= num2.Denominator;
		num2.Numerator *= num1.Denominator;
		if(num1.Numerator < num2.Numerator){
			result = true;
		}
		return result;
	}
	public RationalNumber simplify(){
		int biggerNum;
		if(this.Denominator > this.Numerator){
			biggerNum = this.Denominator;
		}
		else{
			biggerNum = this.Numerator;
		}
		for(int i = 2;(i < biggerNum); i++){
			if(((this.Numerator % i)==0)&&((this.Denominator % i)==0)){
				this.Numerator /= i;
				this.Denominator /= i;
				i = 2;
			}
		}
		return this;
	}
	public String toString(){
		String description = this.Numerator + "/" + this.Denominator;
		return description;
	}
	
}
