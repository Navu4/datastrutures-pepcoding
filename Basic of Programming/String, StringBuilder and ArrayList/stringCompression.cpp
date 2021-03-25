#include<iostream>
using namespace std;

// String compression 
// aaabbccdefff -> a3b2c2def3 
void compression1(string str){
    if(str.length() <= 1){ 
        cout << str ;
        return ;
    }
    string ans = "";
    char prevchar = str[0];
    int i = 1;
    while(i <= str.length()){
        int count = 1;
        while (i < str.length() && prevchar == str[i]){
            count++;
            i++;
        }
        ans += prevchar;
        if(count != 1)  ans += to_string(count); 
        prevchar = str[i];
        i++;
        
    }
    cout << ans << endl; 
}

// aaaaabbbbbcccccdddsefs -> abcdsefs
void compression2(string str){
    string ans = "";
    char prevchar = str[0];
    int i = 1;
    while(i <= str.length()){
        int count = 1;
        while (i < str.length() && prevchar == str[i]){
            count++;
            i++;
        }
        ans += prevchar;
        // if(count != 1)  ans += to_string(count); 
        prevchar = str[i];
        i++;
        
    }
    cout << ans << endl; 
}

int main(){
    string s;
    cin >> s;
    compression2(s);
    compression1(s);
    return 0;
}