#include <iostream>
#include <vector>
#define len(x) (sizeof(x)/sizeof(*x))
using namespace std;

const int MAXN = 10;
int g[MAXN][MAXN];
bool visited[MAXN];

void dibujar(int v){
  cout << "digraph g {" << endl;
  for (int i = 0; i < v; i++){
    for (int j = 0; j < v; j++){
      if (g[i][j] == 1){
        cout << i << " -> " << j << endl;
      }
    }
  }
  cout << "}" << endl;
}

void dfs(int v){
  visited[v] = true;
  for (int i = 0; i < len(g[v]); i++){
    if (g[v][i] && !visited[i]) dfs(i);
  }
}

int main(){
  int v,e,x,y;
  cin >> v >> e;
  while (e--){
    cin >> x >> y;
    g[x][y] = 1;
  }
  dfs(2);
  cout << "desde el 2 se puede llegar a " << endl;
  for (int i = 0; i < v; i++){ 
    cout <<"A :" << i << " " << visited[i] << endl;
  }
  dibujar(v);
}
