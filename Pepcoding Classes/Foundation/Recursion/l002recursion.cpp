#include<iostream>
#include<vector>
using namespace std; 

int fibo(int n)
{
    if (n <= 1)
        return n;

    return fibo(n - 1) + fibo(n - 2);
}

int tribonacci(int n)
{
    if (n <= 2)
        return n == 2 ? 1 : n;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
}

// Recursion With Array

void display(int arr[], int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    cout << arr[idx] << endl;
    display(arr, idx + 1, n);
}

void reverseDisplay(int arr[], int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    reverseDisplay(arr, idx + 1, n);
    cout << arr[idx] << endl;
}

int maxOfArray(int arr[], int idx,int n) {
    if (idx == n) return -1e9;

    return max(arr[idx], maxOfArray(arr, idx + 1,n));
}


int firstIndex(int arr[], int idx, int x, int n)
{
    if (idx == n)
        return -1;

    if (arr[idx] == x)
        return idx;
    return firstIndex(arr, idx + 1, x, n);
}

int lastIndex(int arr[], int idx ,int x ,int n){
    if(idx == n) return -1;
    
    int value = lastIndex(arr,idx + 1 ,x ,n);

    if(value != -1) return value;

    return ((arr[idx] == x) ? idx : -1 );  
}

// ------------------------------------------------

// Palindome using Recursion
bool isPalindrome(vector<int> arr, int start, int end){
    if(start == end || start > end) return true;
    
    if(arr[start] != arr[end])  return false;
    return isPalindrome(arr,start + 1, end -1);
}

// Reverse of an Array
void reverseOfArray(vector<int>& arr, int start , int end){
    if(start == end || start > end) return;
    
    swap(arr[start], arr[end]);
    
    reverseOfArray(arr,start + 1, end -1);
    return; 
}


// --------------------------------------------------

// Print the Sum of String 
int sumOfString(string str,int idx){
    if(idx == (int)str.size()) return 0;
    
    int smallAns = (str[idx]-'0');
    int ans = sumOfString(str, idx+1);
    return (smallAns + ans);
}

// -----------------------------------------

long stringToNumber(string str, int idx, long pow){
    if(idx == -1) return 0;

    long recAns = stringToNumber(str, idx -1 , pow * 10);
    return recAns + (str[idx] - '0') * pow ;
}

// --------------------------------------------




// --------------------------------------------
int main(){

    // int n; cin >> n;
    // vector<int> arr(n,0);
    // for(int i = 0 ; i < n ; i++) cin >> arr[i];

    // reverseOfArray(arr, 0 , n - 1);

    // int idx ; cin >> idx;
    // for(int ele : arr) cout << ele << " ";
    
    // cout << endl << arr[idx] << endl;
    // if(isPalindrome(arr,0,n-1)){
    //     cout << "true" << endl;
    // } else {
    //     cout << "false" << endl;
    // }

    string str; cin >> str;
    cout << sumOfString(str,0,0) << endl; 


    // int n; cin >> n;
    // int arr[n];
    // for(int i = 0 ; i < n ; i++){
    //     cin >> arr[i];
    // }

    // int x ; cin >> x; 
    // cout << firstIndex(arr,0,x,n) << endl ;
    return 0;
}