#include<iostream>
using namespace std;

void pattern16(int n){
    int sp = 2* n -3;
    int st = 1;
    for( int i = 1; i <= n; i++){
        int val = 1;
        for( int j = 1; j <= st; j++){
            cout << val <<"\t";
            val++;
        }

        for( int j = 1; j <= sp; j++){
            cout << "\t" ;
        }
        if(i == n){
            st--;
            val--;
        }
        val--;
        for( int j = 1; j <= st; j++){
            cout << val <<"\t";
            val--;
        }

        st++;
        sp -= 2;
        cout << endl;
    }
}


void pattern14(int n){
    for(int i = 1; i <= 10 ; i++){
        cout << n << "*" << i << "=" << n*i << endl; 
    }
}


// pattern 13
int fact(int n){
    int factorial = 1;
    for(int i = 2; i <= n; i++){
        factorial *= i;
    }
    return factorial;
}

int nCr(int n, int r){
    return fact(n)/(fact(r)*fact(n-r));
}

void pascalTriangle(int n){
    for(int i=0 ; i < n ; i++){
        for(int j=0 ; j <= i ; j++){
            cout << nCr(i,j) << "\t";
        }
        cout << endl;
    }
}


// pattern12
void pattern12(int row){
    int a = 0;
    int b = 1;
    for( int r = 1; r <= row ; r++){
        for(int c = 1; c <= r ;c++ ){
            cout << a << "\t" ;
            int sum = a + b; 
            a = b;
            b = sum;
        }
        cout << endl;
    }
}
void pattern11(int row){
    int nst = 1;
    for( int r = 1; r <= row ; r++){
        for(int c = 1; c <= r ;c++ ){
            cout << nst << "\t" ;
            nst++;
        }
        cout << endl;
    }
}

void pattern10(int row) {
    int nsp1 = row / 2;
    int nsp2 = 0;  
    for (int r = 1; r <= row; r++) {

        for (int csp1 = 1; csp1 <= nsp1; csp1++) {
            cout << "\t";  
        }
        cout << "*";
        for (int csp2 = 1; csp2 <= nsp2; csp2++) {
            cout << "\t";  
        }

        if( r != 1 && r != row){
            cout << "*";
        }

        if(r <= row/2 ) { // 2 < 2
            nsp1--; // 1 
            nsp2 += 2; // 3
        }  else {       
            nsp2-=2; // 
            nsp1++;
        }
        
        cout << endl;
    }
}

void pattern9(int row) {


    for (int r = 1; r <= row; r++) {
        for (int c = 1; c <= row; c++) {
            if (r == c) {
                cout << "*\t";
            } else if ((c+r) == (row+1)) {
                cout << "*\t";
            } else {
                cout << "\t";
            }
        }
        cout << endl;
    }
}

void pattern7(int row){
    int nsp = 0;
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "\t";
        }
        cout << "*\t" << endl;
        nsp++;
    }
}


// Pattern 15
void pattern15(int row ){
    int nst = 1; // No. of star  = 1
    int nsp = row / 2; //No. of space = row/2  = 2
    int count = 1 ;
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "\t";
        }

        int cval = count;
        for ( int cst = 1 ; cst <= nst; cst++){
            cout << cval <<"\t";

            if( cst <= nst/2 ){
                cval++;                 
            } else {
                cval--;
            }

        }

        if(r <= row/2 ) { 
            nsp--;  
            nst += 2;
            count++;
        }
        else {       
            nst-=2;
            nsp++;
            count--;
        }

        cout << endl;
    } 
}






void hollowDiamond(int row){
    int nst = (row + 1) / 2;
    int nsp = 1;
    
    for( int r = 1; r <= row ; r++){
        
        for(int cst=1; cst <= nst ; cst++){
            cout << "*\t";
        }
        
        for(int csp = 1; csp <= nsp ; csp++){
            cout << "\t";
        }
        for(int cst = 1; cst <= nst ; cst++){
            cout << "*\t";
        }
        
    
        if(r <= row/2 ) { 
            nst--; 
            nsp += 2; 
        }
        else {       
            nsp-=2;  
            nst++;
        }
        cout << endl;
    }
}


//     *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *

void printDiamond(int row){ // row = 5
    int nst = 1; // No. of star  = 1
    int nsp = row / 2; //No. of space = row/2  = 2
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "\t";
        }

        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*\t"; 
        }

        if(r <= row/2 ) { // 2 < 2
            nsp--; // 1 
            nst += 2; // 3
        }
        else {       
            nst-=2; // 
            nsp++;
        }
        cout << endl;
    }
}





// *
// **
// ***
// ****
// *****
void printTriangle(int row){
    int nst = 1; // No. of star
    for (int r = 1; r <= row ; r++){
        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*"; 
        }
        nst++;
        cout << endl;
    }
}


//     *
//    **
//   ***
//  ****
// *****
void printMirrorTriangle(int row){
    int nst = 1; // No. of star
    int nsp = row -1; //No. of space
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "\t";
        }

        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*\t"; 
        }
        nsp--;
        nst++;
        cout << endl;
    }
}


// *****
// *****
// *****
// *****
// *****
void printSquare(int row){
    int nst = 5;
    for(int r = 1; r <= row; r++){
        for( int cst = 1; cst <= nst; cst++){
            cout << "*";
        } cout << endl; 
    }
}

void pattern17(int n){
    int nsp = n /2 ;
    int nst = 1;

    for( int i = 1; i <= n ; i++){
        for(int j= 1; j <= nsp ; j++ ){
            if( i == (n/2 + 1)){
                cout << "*\t";
            } else{
                cout << "\t";
            }
        }

        for(int j= 1; j <= nst ; j++ ){
            cout << "*\t";
        }
        if(i <= n / 2){
            nst++;
        } else {
            nst--;
        }
        cout << endl;
    }
}


void pattern18(int n){
    int nsp = 0;
    int nst = n;

    for(int i = 1; i <= n ; i++){
        for(int j = 1; j <= nsp; j++){
            cout << "\t";
        }
        for(int j = 1; j <= nst; j++){
            if( i > 1 && i <= n/2 && j > 1 && j < nst){
                cout << "\t";
            } else {
                cout << "*\t";
            }
        }

        if(i <= (n / 2)){
            nst -= 2;
            nsp++;
        } else {
            nst += 2;
            nsp--;
        }
        cout << endl;
    }
}

int main(){
    // printTriangle(5);
    // printMirrorTriangle(5);
    // printSquare(5);
    // printDiamond(5);
    // hollowDiamond(7);
    // pattern15(7);
    // pattern7(5);
    // pattern9(5);
    // pattern10(5);
    // pattern11(5);
    // pattern12(5);
    // pattern14(5);
    // pattern16(5);
    // pattern17(5);
    pattern18(5);
    return 0;
}