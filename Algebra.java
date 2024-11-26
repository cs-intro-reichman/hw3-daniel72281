// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int g = x1;
		int add = x2;
		int i = 0;
		if (add < 0){
			while (i > add) {
				g--;
				i--;
				
			}
			return g;

		}
		while (i < add) {
			g++;
			i++;
			
		}
		return g;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int g = x1;
		int t = x2;
		int i = 0;
		if(t < 0){
			while (i > t) {
				i--;
				g++;
				
			}
			return g;

		}
		while (i < t) {
			i++;
			g--;
			
		}
		return g;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int g = x1;
		int times = x2;
		int i = 0;
		int sum = 0;
		
		if (times > 0 && g < 0){
			while (i < times ) {
				times--;
				sum =  plus(sum, g);			
			}			
			return sum;
			
		}

		if (times < 0 && g < 0){
			while (i > times ) {
				i--;
				sum =  minus(sum, g);			
			}			
			return sum;
			
		}
			
		if (times < 0 && g > 0){
			while (i < g ) {
				i++;
				sum =  plus(sum, times);			
			}			
			return sum;
			
		}
		while (i <= times-1 ) {
			i++;
			sum =  plus(sum, g);			
		}			
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int g = x;
		int power = n;
		int i = 2;
		int Sum = g;
		if (power==0) {
			return 1;
		}
		if (power == 1){
			return g;
		}
		while (i<=power) {
			
			
			Sum =times(Sum, g);
			i++;
		}
		return Sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int g = x1;
		int divisor = x2;	
		int step = 0;
		int Sum = 0;
		int neg = -1;

		if (divisor == 1) {
			return g;						
		}
		if (g==0) {
			return g;
		}
		if (divisor==g){
			return 1;
		}
		if (g > 0 && divisor < 0) {
			divisor = times(divisor, neg);
			while (Sum <= g) {
				Sum = plus(Sum, divisor);
				step++;	
				if (plus(Sum, divisor) > g) {
					break;					
				}											
			}	
		
		
			
		return times(step, neg);
		}
		
		if (g <0 && divisor > 0) {
			g = times(g, neg);
			while (Sum <= g) {
				Sum = plus(Sum, divisor);
				step++;	
				if (plus(Sum, divisor) > g) {
					break;					
				}											
			}	
		
		
			
		return times(step, neg);
		}
		if (g <0 && divisor < 0) {
			while (Sum >= g) {
				Sum = plus(Sum, divisor);
				step++;	
				if (plus(Sum, divisor) < g) {
					break;					
				}											
			}	
		
		return step;
		}
			while (Sum <= g) {
				Sum = plus(Sum, divisor);
				step++;	
				if (plus(Sum, divisor) > g) {
					break;					
				}											
			}	
		
		return step;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int g = x1;
		int divisor = x2;	
		int remaindr = 0;
		int i = 0;

        if (divisor == 0) {
			return -1;						
		}
		if (divisor == 1) {
			return 0;						
		}
		if (g==0) {
			return g;
		}
		if (divisor==g){
			return 0;
			
		}else{i = div(g, divisor);
			i = times(i, divisor);
			remaindr = minus(g, i);
		}
		return remaindr;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int g = x;
		int i = 2;
		int power = 2;
		if (g==0) {
			return 0;
		}
		if (g==1) {
			return 1;
		}
		while (pow(i, power) != g) {
        
			i++;
			if ((pow(i, power) >=g)) {
				
				break;
				
			}
			
		}		
		
		return i;	
		}
		
		

		
	}	  	  
