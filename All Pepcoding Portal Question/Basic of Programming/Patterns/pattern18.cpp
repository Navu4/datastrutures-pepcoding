#include <iostream>
using namespace std;

void pattern18(int n){
    int nsp = 0;
    int nst = n;

    for(int i = 1; i <= n ; i++){
        for(int j = 1; j <= nsp; j++){
            cout << "	";
        }
        for(int j = 1; j <= nst; j++){
            if( i > 1 && i <= n/2 && j > 1 && j < nst){
                cout << "	";
            } else {
                cout << "*	";
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

int main(int agrc, char**argv){
    int n;
    cin >> n;

    //write your code here
    pattern18(n);   
}