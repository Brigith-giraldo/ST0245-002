#include <string>
#include <unordered_map>
#include <chrono>
#include <cmath>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <malloc.h>

using namespace std;
class Bee {
public:
    double x,xx, y,yy, z;
    Bee* previous = nullptr;
    Bee* following = nullptr;

    Bee(double x1, double y1, double z1){
        x = x1;
        xx = x1 * 111111;
        y = y1;
        yy = y1 * 111111;
        z = z1;
    };

    Bee(const Bee& b)
    {
        x = b.x;
        y = b.y;
        z = b.z;
    };
};

class BeeList {
public:
    Bee* first = nullptr;
    Bee* last = nullptr;
    int size = 0;

    void add_bee(Bee* b){
      b->following = this->first;
      this->first = b;
    }

    void add_first_bee(Bee* b){
      this->first = b;
      this->last = b;
    }

    void concatenate_beelist_end(BeeList* bl){
      this->last->following = bl->first;
      this->last = bl->last;
    }
};

typedef pair<BeeList, bool> Pair;
BeeList resultant_blist;


string find_cube_key(double x, double y, double z){
  string output;
  output += "" + to_string((int)(x/57.735));
  output += " " + to_string((int)(y/57.735));
  output += " " + to_string((int)(z/57.735));
  return output;
}

inline void parse_file(string input_file, vector<string>& v, unordered_map<string, Pair>& um){
  fstream file;
  file.open(input_file, ios::in);
  if (file.is_open()){
    string line;
    string tok;
    while(getline(file,line)){
      vector<double> aux;
      stringstream ss(line);
      while(getline(ss, tok, ',')){
        aux.push_back(stod(tok));
      }
      Bee *bee = new Bee(aux[0], aux[1], aux[2]);
      string key = find_cube_key(bee->xx, bee->yy, aux[2]);
      if (!um.count(key)){
        BeeList *l = new BeeList();
	      l->add_bee(bee);
	      um.insert({key,{*l,false}});
        v.push_back(key);
      }else{
        um[key].first.add_bee(bee);
        um[key].second = true;
      }
    }
    file.close();
  }
}

void find_for_unique_bee(string unique_bee_key, unordered_map<string, Pair>& cubes){
  auto iter = cubes.find(unique_bee_key);
  while (iter != cubes.end()){
    cout << iter->first << endl;
    iter++;
  }
}

BeeList* tony;
double x, y, z;

int main(){
  unordered_map<string, Pair> um;
  vector<string> v;
  parse_file("1500000Abejas.txt",v,um);
  auto it = um.begin();
  
  cout << "En riesgo de colision: " <<  endl;
  while (it != um.end()){
    Bee *aux = it->second.first.first;
    if (it->second.second){
      while(aux!=NULL){
        cout << " -> " << aux->x << " " << aux->y << " " << aux->z << endl;
        aux = aux->following;
      }
    }
    it++;
  }
}

