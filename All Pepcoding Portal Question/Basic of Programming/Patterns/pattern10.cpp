#include <iostream>
using namespace std;

void pattern10(int row) {
    int nsp1 = row / 2;
    int nsp2 = 1;  
    for (int r = 1; r <= row; r++) {

        for (int csp1 = 1; csp1 <= nsp1; csp1++) {
            cout << "	";  
        }
        cout << "*";
        for (int csp2 = 1; csp2 < nsp2; csp2++) {
            cout << "	";  
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

int main(int argc, char **argv){
    int n;
    cin >> n;

    //write your code here
    pattern10(n);    
}