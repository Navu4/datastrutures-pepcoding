#include <iostream>
using namespace std;

void hollowDiamond(int row){
    int nst = row / 2 + 1;
    int nsp = 1;
    
    for( int r = 1; r <= row ; r++){
        
        for(int cst=1; cst <= nst ; cst++){
            cout << "*	";
        }
        
        for(int csp = 1; csp <= nsp ; csp++){
            cout << "	";
        }
        for(int cst = 1; cst <= nst ; cst++){
            cout << "*	";
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

int main(int argc, char **argv){
    int n;
    cin >> n;

    //write your code here
    hollowDiamond(n);
}