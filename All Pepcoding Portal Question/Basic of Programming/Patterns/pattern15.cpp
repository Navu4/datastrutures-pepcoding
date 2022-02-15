#include <iostream>
using namespace std;

void pattern15(int row ){
    int nst = 1; // No. of star  = 1
    int nsp = row / 2; //No. of space = row/2  = 2
    int val = 1 ;
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "	";
        }

        int cval = val;
        for ( int cst = 1 ; cst <= nst; cst++){
            cout << cval <<"	";

            if( cst <= nst/2 ){
                cval++;                 
            } else {
                cval--;
            }

        }

        if(r <= row/2 ) { 
            nsp--;  
            nst += 2;
            val++;
        }
        else {       
            nst-=2;
            nsp++;
            val--;
        }

        cout << endl;
    } 
}

int main(int argc, char**argv){
    int n;
    cin >> n;

    //write your code here
    pattern15(n);
}