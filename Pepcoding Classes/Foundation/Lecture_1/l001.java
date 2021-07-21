import java.util.Scanner;
public class l001{
    public static Scanner scn = new Scanner(System.in);

    public static int LCM(int a, int b){
        return ((a/GCD(a,b)) * b);
    }
    
    public static int GCD(int a, int b){
        int divisior = a;
        int dividend = b;
        
        while(dividend % divisior != 0){
            
            int rem = dividend % divisior;
            dividend = divisior;
            divisior = rem;
            
        }
        
        return divisior;
    }

    public static int countDigit(int n){
        int count = 0 ;
        int num = n;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }
    
    public static void printDigits(int n){
            int len = countDigit(n);
            
            int div = 1;
            while(len-- > 1){
                div *= 10;
            }
            
            while(div !=0){
                System.out.println(n/div);
                n = n %div ;
                div /= 10;
            }
    } 

    public static int revDigits(int n, int r){
        int num = n;
        int len =  countDigit(num);
        r %=len;
        if( r < 0 ) r = (r+ len) % len;

        int mul = 1, div = 1;
        for( int i = 1 ; i < n ; i++){
            if( i <= r ){
                mul *= 10;
            } else {
                div *= 10;
            }
        }

        int A = num % div;
        int B = num / div;

        return (A * mul + B);
    }


    public static int countDigit(int n){
        int count = 0 ;
        int num = n;
        while(num > 0){
            num /= 10;
            count++;
        }
        return count;
    }

    public static void fib(int n){
        int a = 0 ;
        int b = 1;
        while(n-- >= 0){
            System.out.println(a);
            int sum = a + b;
            a = b ; 
            b = sum;
        }
    }

    public static boolean isPrime_(int n){
        boolean prime = true;
        for (int i = 2; i*i <= n; i++){
            if(n % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void isPrime(){
        int n = scn.nextInt();
        bool ans = isPrime_(n);

        if(ans) System.out.println("prime");
        else System.out.println("not prime")
    }

    public static void printAllPrime(int a, int b){
        for(int i =a; i<=b ; i++){
            boolean ans = isPrime_(i);
            if(ans) System.out.println(i);
        }
    }

    public static void oddEven(int n){
        if(n%2 == 0){
        cout << "Even" << endl;
        } else {
            cout << "Odd" << endl;
        }
    }


    public static void gradingSystem(int n){
        if(n > 90){
            System.out.println("excellent");
        } else if (n > 80){
            System.out.println("good");
        } else if (n > 70){
            System.out.println("fair");
        } else if (n > 60){
            System.out.println("meets expectation");
        } else {
            System.out.println("below par");
        }
    }


    public static void printz(){
        System.out.println("*****");
        System.out.println("   * ");
        System.out.println("  *  ");
        System.out.println(" *   ");
        System.out.println("*****");
    }


    public static void main(String[] args){
        int marks = scn.nextInt();

        oddEven(marks);

        printz();
        gradingSystem(marks);
    }
    
}