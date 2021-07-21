#include<iostream>
#include<vector>
using namespace std;

void test1(){
    int* arr = new int[10];
    for(int i=0; i < 20; i++){
        cout << arr[i] << " ";
    } 
}
void test2(){
    vector<int> arr(10);
    for(int i=0; i < 20; i++){
        cout << arr[i] << " ";
    } 
}

void arrayInput(){
    int n;
    cin >> n;

    int* arr = new int[n];
    for(int i=0; i < n; i++){
        cout << arr[i] << " ";
    }
}

// Vector Input 
void vectorInput(){
    int n;
    cin >> n;

    vector<int> arr(n);
    for(int i=0; i < arr.size(); i++){
        cin >> arr[i];
    }
}



// Basic Question ------------------------------
// Find the maximum value
int maximumElement(vector<int>& arr){
    int maxEle = -1e8;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] > maxEle){
            maxEle = arr[i];
        }
    }
    return maxEle;
}

// Find the minmum value
int minmumElement(vector<int>& arr){
    int minEle = 1e8;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] < minEle){
            minEle = arr[i];
        }
    }
    return minEle;
}

// Find the entered element
int findElement(vector<int>& arr,int data){
    int idx = -1;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}

// Find the first index of entered element
int firstIndex(vector<int>& arr,int data){
    int idx = -1;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}

// Find the last index of entered element
int lastIndex(vector<int>& arr,int data){
    int idx = -1;
    for(int i= arr.size();i >= 0; i--){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}

// Sum of two arrays
void sumOfTwoArrays(vector<int>& arr1, vector<int>& arr2){
    int p = arr1.size();
    int q = arr2.size();
    int r = max(p,q) + 1;

    vector<int> ans(r,0);

    int carry = 0 ;
    int i = p -1;
    int j = q -1;
    int k = r -1;


    while(k >= 0){
        int sum = carry;
        if(i >= 0){
            sum += arr1[i--];
        }    
        if(j >= 0){
            sum += arr2[j--];
        }    

        ans[k--] = sum % 10;
        carry = sum / 10;
    }

    for(int l = 0; l < ans.size() ; l++){
        if( l == 0 && ans[l] == 0){
            continue;
        } 
        cout << ans[l] << endl;
    }
}


// Subtraction of two arrays
void subOfTwoArrays(vector<int>& arr1, vector<int>& arr2){
    int p = arr1.size();
    int q = arr2.size();
    int r = p + 1;

    vector<int> ans(r,0);

    int borrow = 0 ;
    int i = p -1;
    int j = q -1;
    int k = r -1;


    while(k >= 0){
        int num = borrow;
        if(i >= 0){
            num += arr1[i--];
        }    
        if(j >= 0){
            num -= arr2[j--];
        }    
        
        if(num < 0){
            num += 10;
            borrow = -1;
        } else {
            borrow = 0;
        }

        ans[k--] = num;
    }
    
    bool flag = false;
    for(int l = 0; l < ans.size() ; l++){
        if( !flag && ans[l] == 0){
            continue;
        } 
        cout << ans[l] << endl;
        flag = true;
    }
}

// Reverse an array
void reverse(vector<int>& arr, int k){
    int i = 0;
    int j = arr.size() - 1;

    while(i < j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        i++;
        j--;
    }
}

// Rotate an array 
void rotate(vector<int>& arr, int k){
    int n = 0;
    // reverse(arr,0,n -1);
}

// Inverse of an array 
void inverse(vector<int>& arr){
        int n = arr.size();
        vector<int> ans(n);

        for(int i = 0; i < ans.size(); i++){
            ans[arr[i]] = i ;
        }

        for(int ele : ans){
            cout << ele << endl;
        }
    }

// Print all subarrays
void printSubArrays(vector<int>& arr){
    for(int i = 0 ; i < arr.size() ; i++){
        for(int j = i ;j < arr.size() ; j++){
            cout << arr[j] << " " ;
        }
        cout << endl;
    }
}

// Binary Search 
int binarySearch(vector<int> arr, int key ){
    int start = 0;
    int end = arr.size() - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(key == arr[mid]){
            return mid;
        } 
        else if(key < arr[mid]){
            end = mid - 1;
        }
         else {
            start = mid + 1;
        }
    }
    return -1;
}

// Application of Binary Search Algorithm
// If numbers are arranged in an array in sorted manner in a pair and one digit goes missing 
// You need to find that element/digit 
// Write a function which returns the index of the element 
// Example :- 1 1 2 2 3 3 4 5 5 

int findMissingNumberInPair(vector<int>& arr){
    int size = arr.size() ; 
    if(size % 2 == 0)   return -1;

    int i = 0 ;
    int j = size - 1;
    int mid ;
    while ( i <= j ){
        mid = (i + j) / 2;
        if(i == j) return mid;

        if(mid % 2 == 0){
            if(arr[mid] == arr[mid + 1])    
                i = mid + 2;
            else 
                j = mid;
        } else {
            if(arr[mid] == arr[mid - 1])    
                i = mid + 1;
            else 
                j = mid;
        }
    } 
    return mid; 
}
// ----------------------------------------------------------------

//  Questions .
void input(vector<vector<int>>& arr){
    for(int i= 0; i < arr.size(); i++){
        for(int j=0; j < arr[0].size();j++){
            cin >> arr[i][j];
        }
    }
}
void output(vector<vector<int>>& arr){
    for(int i= 0; i < arr.size(); i++){
        for(int j=0; j < arr[0].size();j++){
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}

// Wave print
void waveprint(vector<vector<int>>& arr, int row, int col){
    for(int j = 0; j < col; j++){
        if(j % 2 == 0){
            for(int i = 0 ; i < row ; i++){
                cout << arr[i][j] << " ";
            }
        } else  {
            for(int i = row - 1 ; i >= 0 ; i--){
                cout << arr[i][j] << " ";
            }
        }
    }
}

//  Wave Print from left
void leftwaveprint(vector<vector<int>>& arr, int row, int col){
    for(int i = 0; i < row; i++){
        if(i % 2 == 0){
            for(int j = 0 ; j < col ; j++){
                cout << arr[i][j] << " ";
            }
        } else
        {
            for(int j = col - 1 ; j >= 0 ; j--){
                cout << arr[i][j] << " ";
            }
        }
        
    }
}





// Exit point of array 
void exitPoint(vector<vector<int>>& arr, int row, int col){
    int i = 0, j = 0 , d = 0;

    while (true)        
    {
        d = (d + arr[i][j]) % 4;
        if(d == 0){ // East
            j++;
            if(j == col){
                cout << i << endl << j -1 << endl;
                break;
            }
        } else if(d == 1){ // South
            i++;
            if(j == row){
                cout << i - 1<< endl << j << endl;
                break;
            }
        } else if(d == 2){ // West
            j--;
            if(j == -1){
                cout << i << endl << j + 1 << endl;
                break;
            }
        } else if(d == 3){ // South
            i++;
            if(i == -1){
                cout << i + 1 << endl << j << endl;
                break;
            }
        }

    }
    
}

int main(){
    int n;
    cin >> n;

    vector<int> arr(n);
    for(int i=0; i < arr.size(); i++){
        cin >> arr[i];
    }
    // int key;
    // cin >> key;
    // test2();
    cout << arr[findMissingNumberInPair(arr)];
    return 0;
}