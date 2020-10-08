#include "TablaHash.h"

#include <iostream>
#include <string>
#include <list>
#include <utility>

using namespace std;

int TablaHash::funcionHash(string k){
  return int(k[0]) % 10;
}

int TablaHash::get(string k){
  for (auto p: this->tabla[funcionHash(k)]){
    if (p.first == k){
      return p.second;
    }
  }
  return -1;
}

void TablaHash::put(string k, int v){
  this->tabla[funcionHash(k)].push_back({k,v});
}

