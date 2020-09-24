#include <bits/stdc++.h>

#define D(x) cout << #x << ": " << x << endl;
#define forn(i,n) for(int i=0; i< (int)n; i++)
#define for1(i,n) for(int i=1; i<= (int)n; i++)
#define all(v) v.begin(),v.end()

using namespace std;

typedef long long ll;


int main(){
    ios::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cout<< setprecision(20)<< fixed;
    #ifdef LOCAL
        freopen("input.txt", "r", stdin);
    #else
        #define endl '\n'
    #endif

    stack<pair<int,string>> neveras;
    pair<int,string> aux;
    int codigo,cant,Cnev,Cpedi;
    string desc, nombre;
    
    cin >> Cnev >> Cpedi;
    while (Cnev--){
      cin >> codigo;
      cin.ignore();
      getline(cin,desc);
      neveras.push({codigo,desc});
      cout << codigo << ": " << desc << endl;
    }

    while (Cpedi--) {
      cin >> nombre;
      cin >> cant;
      while (cant--) {
        if (!neveras.empty()){
          aux = neveras.top();
          neveras.pop();
          cout << nombre << ": " << aux.first << " -> " << aux.second << endl;
        }else {
          cout << nombre << ": no hay neveras disponibles" << endl;
          break;
        }
      }
    }

    return 0;
}

