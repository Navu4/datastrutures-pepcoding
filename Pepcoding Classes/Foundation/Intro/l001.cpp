#include<iostream>
using namespace std;

void printHello(){
        cout << "Hi there" << endl;
        cout << "My name is Navjot Singh" << endl;
}

void workWithDataType(){
    int a = 10;
    int b = 20;

    cout << "Value of A: " + to_string(a) << endl;
    cout << "Value of B: " + to_string(b) << endl;
}

int main(){

    printHello();
    return 0 ; 
}