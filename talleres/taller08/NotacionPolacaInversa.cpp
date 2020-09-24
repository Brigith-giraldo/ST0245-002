#include <bits/stdc++.h>

#define D(x) cout << #x << ": " << x << endl;
#define forn(i,n) for(int i=0; i< (int)n; i++)
#define for1(i,n) for(int i=1; i<= (int)n; i++)
#define all(v) v.begin(),v.end()

using namespace std;

typedef long long ll;

bool isNumber(string cadena){
  for(char s: cadena){
    if(!isdigit(s) )
      return false;
  }
  return true;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cout<< setprecision(20)<< fixed;
    #ifdef LOCAL
        freopen("input.txt", "r", stdin);
    #else
        #define endl '\n'
    #endif
    
    vector<string> c;
    string s;
    while (cin >> s) {
      c.push_back(s);
    }
    stack<int> sta;
    forn(i,c.size()){;
      if (isNumber(c[i])){
        sta.push(stoi(c[i]));
      }else {
        int n1 = sta.top();
        sta.pop();
        int n2 = sta.top();
        sta.pop();
        int res;
        if (c[i] == "*") {
          res = n2*n1;
        }else if (c[i] == "+") {
          res = n2+n1;
        }else if (c[i] == "-") {
          res = n2-n1;
        }else if(c[i] == "/") {
          res = n2/n1;
        }
        sta.push(res);
      }
    }
    cout << sta.top() << endl;

    return 0;
}

