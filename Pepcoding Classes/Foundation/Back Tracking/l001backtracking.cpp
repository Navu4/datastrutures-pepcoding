#include<iostream>
#include<vector>
#include<string>

using namespace std;


// Targert Sum
// 1. You will be given a non negative integers' array and an intger S
//  2. You can either make an integer positive or negative
//  3. Your aim is to make sum of all the elements a given target sum (S)
//  4. Return number of ways to make to assign symbols to make sum of elements equal to target S

// Sample Input
// 8
// 6 3 7 5 5 8 4 8 
// 6

int findCountOfTargetSum(vector<int>& nums, int S, int idx){
    if(idx == nums.size()){
        if(S == 0){
            return 1;
        }
        return 0;
    }
    
    int count = 0 ;
    count += findCountOfTargetSum(nums,S - nums[idx],idx + 1);
    count += findCountOfTargetSum(nums,S - (-nums[idx]),idx + 1);
    
    return count;
}


// int findcountTagetSum2(vector<int>& nums, int S, int idx, int sum){
//     if(idx == nums.size()){
//         return 0;
//     }

//     int count = 0;

//     sum = findcountTagetSum2(nums, S, idx, sum + nums[idx]);
//      sum = findcountTagetSum2(nums, S, idx, sum - nums[idx]);
// }
// --------------------------------------------------------------------

// SET QUESTION
// S = {......................}
// A & B subset of S 
// A = {.............}
// B = {..........}

// 1. A U B = S
// 2. A intersection B = 0
// 3. Sum of A = Sum of B

// Sum of Two Array Should be Equals( SET ) 

int equiSet(vector<int> arr, int idx, int sum1, int sum2, string set1, string set2){

    if(idx == arr.size()){
        if(sum1 == sum2){
            cout << set1 << "= " << set2 << endl;
            return 1;
        }
        return 0;
    }

    int count = 0 ;
    count += equiSet(arr,idx + 1, sum1 + arr[idx], sum2, set1 + to_string(arr[idx]) + " ", set2);
    count += equiSet(arr,idx + 1, sum1, sum2 + arr[idx], set1, set2 + to_string(arr[idx]) + " ");

    return count;
}

// --------------------------------------------------------------------


int main(){

    vector<int> arr = {30,10,20};
    // equiSet(arr, 1, arr[0], 0, to_string(arr[0]) + " ", "");
    equiSet(arr, 0, 0, 0, " ", "");

    // int n; cin >> n;
    // vector<int> arr(n);
    // for (int i = 0; i < n; i++){
    //     cin >> arr[i]; 
    // }
    // int S ; cin >> S;

    // findCountOfTargetSum(arr,S,0);

    return 0;
}