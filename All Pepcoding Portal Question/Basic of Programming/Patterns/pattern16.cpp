#include <iostream>
using namespace std;

void pattern16(int n){
    int sp = 2* n -3;
    int st = 1;
    for( int i = 1; i <= n; i++){
        int val = 1;
        for( int j = 1; j <= st; j++){
            cout << val <<"	";
            val++;
        }

        for( int j = 1; j <= sp; j++){
            cout << "	" ;
        }
        if(i == n){
            st--;
            val--;
        }
        val--;
        for( int j = 1; j <= st; j++){
            cout << val <<"	";
            val--;
        }

        st++;
        sp -= 2;
        cout << endl;
    }
}

int main(int argc, char**argv){
    int n;
    cin >> n;

    //write your code here
    pattern16(n);    
}