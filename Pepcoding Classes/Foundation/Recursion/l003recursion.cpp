#include<iostream>
#include<vector>

using namespace std;

    // IMPORTANT QUESTION   
    // Mobile KeyPad Problem 
    // 0 -> .;
    // 1 -> abc
    // 2 -> def
    // 3 -> ghi
    // 4 -> jkl
    // 5 -> mno
    // 6 -> pqrs
    // 7 -> tu
    // 8 -> vwx
    // 9 -> yz
    
static vector<string> codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

vector<string> getKPC(string str, int idx) {
    if(idx == str.length()){
        vector<string> base;
        base.push_back("");
        return base;
    }
    
    vector<string> recAns = getKPC(str,idx + 1);
    vector<string> myAns;
    
    char ch = str[idx];
    
    string code = codes[ch - '0'];
    for(int i = 0; i < code.length() ; i++){
        char c = code[i];
        
        for(string s : recAns){
            myAns.push_back(c + s);
        }
    }
    

    return myAns;
}

// -------------------------------------------------------------


// Get the Paths of the Maze (0,0) -> (n,m)
vector<string> getMazePaths(int sr, int sc, int dr, int dc){
    if(sr == dr && sc == dc){
        vector<string> base; 
        base.push_back("");
        return base;
    }
    
    vector<string> myAns ;
    if(sc + 1 <= dc){
        vector<string> Horizontal = getMazePaths(sr,sc + 1 , dr, dc);
        for(string s : Horizontal){
            myAns.push_back("h" + s);
        }
    }
    
    if(sr + 1 <= dr){
        vector<string> Vertical = getMazePaths(sr + 1,sc, dr, dc);
        for(string s : Vertical){
            myAns.push_back("v" + s);
        }
    }
    
    return myAns;
}

// ----------------------------------------

// Maze Paths With Jumps 

vector<string> getMazePathsWithJumps(int sr, int sc, int dr, int dc){
    if(sr == dr && sc == dc){
        vector<string> base; 
        base.push_back("");
        return base;
    }
    
    vector<string> myAns ;
    
    for (int i = 1; i <= dc - sc; i++){
        
        vector<string> Horizontal = getMazePathsWithJumps(sr,sc + i , dr, dc);
        for(string s : Horizontal){
            myAns.push_back("h"+ to_string(i) + s);
        }
    }
    
    for (int i = 1; i <= dr - sr; i++){
        
        vector<string> Vertical = getMazePathsWithJumps(sr + i,sc, dr, dc);
        for(string s : Vertical){
            myAns.push_back("v"+ to_string(i) + s);
        }
    }
    
    
    for (int i = 1; i <= ((dr - sr) && i <= (dc - sc)); i++){
        
        vector<string> Diagonal = getMazePathsWithJumps(sr + i,sc + i, dr, dc);
        for(string s : Diagonal){
            myAns.push_back("d"+ to_string(i) + s);
        }
    }
    
    return myAns;
}

// -----------------------------------------

// Print the vector 
void display(vector<string> ans){
    cout << "[";
    for(int i = 0 ; i < ans.size(); i++){
        cout << ans[i] ;
        if( i < ans.size() - 1) cout << ", ";
    }
    cout << "]" << endl ;
}

// ------------------------------------------------------------------------------------------

// Stair Path 
// Path of ladder

vector<string> pathOfLadder(int st , int dest , int jump){
    if(st == dest ){
        vector<string> base;
        base.push_back("");
        return base;
    }

    vector<string> ans;
    for(int move = 1 ; move <= dest - st && move <= jump ; move++){
        vector<string>  smallAns = pathOfLadder(st + move , dest , jump);
        for(string s : smallAns){
            ans.push_back(to_string(move) + s);
        }
    }
    return ans ;
} 

// ------------------------------------------------------------------------------------------

int main(){
    int n,m ; cin >> n >> m ;
    display(pathOfLadder(0,n,m));
    
    // display(getKPC("78",0));

    return 0;
}