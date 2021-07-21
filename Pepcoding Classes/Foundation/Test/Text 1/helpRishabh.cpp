#include<iostream>
#include<vector>
using namespace std; 

// void listOfSubarray(vector<vector<int>> &list,vector<int> &A ){
//     int n = A.size();
//     for(int i = 0 ; i < n ; i++){
//         for(int j = i; j < n ; j++){
//             vector<int> a;
//             for(int k = i; k <= j  ; k++){
//                 a.push_back(A[k]);
//             }
//             list.push_back(a);
//         }
//     }
// }

// bool bpresent(vector<int> &arr,int key){
//     int cval = 0, i = 0;
//     while( i < arr.size()){
//         if(arr[i] == key){
//             cval++;
//         }
//         i++;
//     }
//     if(cval >= 2){
//         return true;
//     }
//     return false;
// }


int main(){
    int n ; cin >> n;
    vector<int> arr(n,0);
    for(int i = 0 ; i < arr.size(); i++){
        cin >> arr[i];
    }
    int key; cin >> key;
    vector<vector<int>> list;
    for(int i = 0 ; i < arr.size() ; i++){
        for(int j = i; j < arr.size() ; j++){
            vector<int> a;
            for(int k = i; k <= j  ; k++){
                a.push_back(arr[k]);
            }
            list.push_back(a);
        }
    }

    int count = 0 ;
    for(int i = 0 ; i < list.size(); i++){
        // vector<int> a = list[i];
        vector<int> freq (1e5,0); 
        for(int j =0 ; j < list[i].size() ; j++){
            freq[list[i][j]]++;
        }
        
        int cval = 0 ;
        for(int k = 0; k < freq.size(); k++){
            if(freq[k] >= 2){
                cval++;
            }
        }

        if(cval == key){
            count++;
        }
        

        // int cval = 0 ;
        // for(int j =0 ; j < list[i].size() ; j++){
        //     if(list[i][j] == key){
        //         cval++;
        //     }
        // }
        // if(cval >= 2){
        //     count++;
        // }
    }
    cout << count <<endl ;

    return 0;
}

// int main(){
//     vector<int> arr(5);
//     for(int i = 0 ; i < 5; i++){
//         cin >> arr[i];
//     }
//     int B ; cin >> B;
//     vector<vector<int>> list;
//     listOfSubarray(list, arr);
//     // for(int i = 0 ; i < list.size(); i++)
//     // {
//     //     for(int j = 0 ; j < list[i].size(); j++)
//     //         cout << list[i][j] << " ";
//     //     cout << endl;
//     // }
//     int count = 0 ;
//     for(int i = 0 ; i < list.size(); i++)
//     {   
//         vector<int> a = list[i];
//         if(bpresent(a,B)){
//             count++;
//         }
//     }
//     cout << count ;
//     return 0;
// }
// g++ helpRishabh.cpp -o out && out


