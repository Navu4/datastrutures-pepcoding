#include<iostream>
using namespace std;


int LCM(int a, int b){
    return ((a/GCD(a,b)) * b);
}

int GCD(int a, int b){
    int divisior = a;
    int dividend = b;
    
    while(dividend % divisior != 0){
        
        int rem = dividend % divisior;
        dividend = divisior;
        divisior = rem;
        
    }
    
    return divisior;
}

int countDigit(int n){
    int count = 0 ;
    int num = n;
    while(n > 0){
        n /= 10;
        count++;
    }
    return count;
}

void printDigits(int n){
        int len = countDigit(n);
        
        int div = 1;
        while(len-- > 1){
            div *= 10;
        }
        
        while(div !=0){
            cout << (n/div) << endl;
            n = n %div ;
            div /= 10;
        }
} 

int revDigits(int n, int r){
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


int countDigit(int n){
    int count = 0 ;
    int num = n;
    while(num > 0){
        num /= 10;
        count++;
    }
    return count;
}
bool isPrime_(int n){
    bool prime = true;
    for( int i = 2; i*i <= n; i++){
        if((n % i) == 0){
            prime = false;
            break;
        }
    }
    return prime;
}

void isPrime(){
    int n;
    cin >> n;
    
    bool ans = isPrime_(n);
    
    if(ans) cout << "prime" << endl;
    else cout << "not prime" << endl;
}

void printAllPrime(int a,int b){
    for( int i = 0; i <=b ; i++){
        bool ans = isPrime_(i);
        if(ans) cout << i << " "; 
    }
}

void fib(int n){
    int a = 0;
    int b = 1;

    while(n--){
        cout << a << endl;
        int temp = a;
        a = b;
        b = a + temp;
    }
    
}

void printz(){
    cout << "*****" << endl;
    cout << "   * " << endl;
    cout << "  *  " << endl;
    cout << " *   " << endl;
    cout << "*****" << endl;
}

void gradingSystem(int n){
    if(n > 90){
        cout << "excellent" << endl;
    } else if (n > 80){
        cout << "good");
    } else if (n > 70){
        cout << "fair" << endl;
    } else if (n > 60){
        cout << "meets expectation" << endl;
    } else {
        cout << "below par" << endl;
    }
}

void oddEven(int n){
    if(n%2 == 0){
        cout << "Even" << endl;
    } else {
        cout << "Odd" << endl;
    }
}

int main(){
    int marks ;
    cin >> marks;

    printz();

    gradingSystem(marks);
    return 0;
}