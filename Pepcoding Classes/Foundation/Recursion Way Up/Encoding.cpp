#include <iostream>
#include<string>
using namespace std;

void printEncoding(string str, int idx, string ans){
    if(str[idx] == '0')   return;
    
    if(idx == str.size()){
        cout << ans << endl;
        return ;
    } // 655196
    
    if(idx == (str.size() - 1)){
        int n = str[idx] - '0';
        char ch = 'a' + n - 1;
        printEncoding(str, idx + 1, ans + ch);
    }
    
    if(idx + 1 < str.size()){
        int n = str[idx] - '0';
        char ch = 'a' + n - 1;
        printEncoding(str, idx + 1, ans + ch);

        string s = str.substr(idx, 2);
        char c = 'a' + stoi(s) - 1;

        if(s <= "26"){
            printEncoding(str, idx + 2, ans + c);
        }

    }
    return;   
}

int main(){
    string str;
    cin>>str;
    if(str[0] == '0'){
        cout << "Invalid input";
    }
    else {
        printEncoding(str, 0, "");   
    }
    
}