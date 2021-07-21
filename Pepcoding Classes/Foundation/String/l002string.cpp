#include<iostream>
#include<vector>
using namespace std;

//  Check palindrome
bool isPalindrome(string str){
    int i = 0 ;
    int j = str.size() - 1;
    while(i < j){
        if(str[i++] != str[j--]){
            return false;
        }
    }
    return true;
}

// Print all substrings 
void printAllSubstrings(string str){
    for(int i = 0 ; i < str.size(); i++){
        for(int j = i; j < str.size() ; j++){
            string s = str.substr( i , j + 1 - i );
            cout << s << endl;
        }
    }
}
// -------------------------------------------
void anotherWayToPrintAllSubstrings(string str){
    for(int i = 0 ; i < str.size(); i++){
        for(int len = 1; len + i <= str.size() ; len++){
            string s = str.substr( i , len);
            cout << s << endl;
        }
    }
}

// Print all the Palindromic Substring
void solution(string str) {
    for (int i = 0; i < str.length(); i++) {
        for (int j = i; j < str.length(); j++) {
            string s = str.substr(i, j + 1 - i );
            if (isPalindrome(s)) {
                cout << s << endl;
            }
        }
    }
}

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


// WithoutX2 problem 
string withoutX2(string str){
    string ans = "";
    for(int i = 0 ; i < str.length() ; i++){

        if(i < 2 && str[i] != 'x')   ans += str[i];
        if(i >= 2)  ans += str[i];
    }
    return ans;
}

// permutation

void appendCharInString(string str, char ch,vector<string>& ans){
        
    for(int i=0; i<=str.length();i++){
        string s = str.substr(0,i) + ch + str.substr(i);
        ans.push_back(s);
    }
}
void solution2(string str) {
    // write your code here
    vector<string> ans;
    ans.push_back("");
    for(int i = 0; i< str.length() ; i++){
        char ch = str[i];
        
        vector<string> smallAns;
        for(string s : ans){
            appendCharInString(s,ch,smallAns);
        }
        ans = smallAns;
    }
    for(string s: ans){
        cout << s << " ";
    }
}

// LEETCODE -> Reverse String 
void reverseRange(string& s,int i, int j){
    while(i < j){
        swap(s[i++],s[j--]);
    }
}
string reverseStr(string s, int k) {
    if(k == 0 || k == 1 || s.length() <= 1) return s ;
    
    int i = 0 , n = s.length();
    
    while(i < n){
        if(i + k - 1 < n){
            reverseRange(s,i,i+k-1);
            i += 2*k ;
            
        } else {
            reverseRange(s,i,n-1);
            break;
        }
    }
    return s;
}
// ----------------------------------------------

// First Unique Character in a String 
int firstUniqChar(string s) {
    vector<int> freq(26);
    for(int i=0;i < s.size(); i++){
        freq[s[i] - 'a']++;
    }
    for(int i = 0 ; i < s.size() ; i++){
        if( freq[s[i] - 'a'] == 1){
            return i;
        }
    }
    return -1;
}
// -----------------------------------------------------



// Longest Palindrome
void longestPalindrome(string str) {
    int maxEle = -1e8;
    string ans = ""; 
    for (int i = 0; i < str.length(); i++) {
        for (int j = i; j < str.length(); j++) {
            string s = str.substr(i, j + 1 - i );
            int len = s.length();
            if (isPalindrome(s) && (len > maxEle)) {
                maxEle = len;
                ans = s;
            }
        }
    }
    cout << ans << endl;
}

// ------------------------------------------

// Prime Factorisation and Display the factor with there powers 
#include<iostream>
#include<vector>
using namespace std;

bool isPrime(int n){
    for(int i = 2;i * i <= n;i++){
        if(n % i == 0) return false;
    }
    return true;
}

void primeNumbers(int n,vector<int>& ans){
    for(int i = 2; i * i <= n; i++){
        if(isPrime(i)) ans.push_back(i);
    }
}

void primeFactors(int num,vector<int>& list){

    int idx = 0;
    while(num != 1 && idx < list.size()){
        int count = 0;
        while(num % list[idx] == 0){
            num /= list[idx];
            count++;
        }
        if(count > 0)
           cout << list[idx] << "^" << count << " " ;
        idx++;
    }
    
    if(num > 1)
        cout << num << "^" << 1;
    
    cout << endl;
}

void primeFactorsForQuery(vector<int>& query){
    vector<int> list;
    primeNumbers(10000,list);

    for(int ele : query){
        primeFactors(ele,list);
    }
}

// int main(int argc, char** agrc){
//     //write your code here
//     int n ; cin >> n;
//     vector<int> arr(n);
//     for(int i=0; i< arr.size();i++) cin >> arr[i];
//     primeFactorsForQuery(arr);
// }

// --------------------------------------------------------------------------------------



int main(){
    // compression2("aaaaabbbbbcccccdddsefs");
    // solution2("abc");
    // cout << firstUniqChar("leetcode");

    // string str;
	// cin >> str;
	// longestPalindrome(str);

    // int n ; cin >> n;
    // vector<int> arr(n);
    // for(int i=0; i< arr.size();i++) cin >> arr[i];
    // primeFactorsForQuery(arr);
    cout << reverseStr("opopopopopopopopopop",8);
    return 0;
}