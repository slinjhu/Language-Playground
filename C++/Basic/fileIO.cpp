#include<iostream>
#include<fstream>
#include<sstream>
#include<vector>
using namespace std;

template<typename T>
ostream & operator<<(ostream & os, vector<T> xx){
  for(T x : xx) os << x << " ";
  return os;
}

vector<string> split(string input, char delimiter){
  stringstream ss (input);
  string word;
  vector<string> result;
  while(getline(ss, word, delimiter)){
    result.push_back(word);
  }
  return result;
}

int main(){
  // Read file by line
  ifstream infile ("test.txt");
  if(infile.is_open()){
    string line;
    while(getline(infile, line, '\n')){
      cout << split(line, ',') << endl;
    }
    infile.close();
  }

  // Write file
  ofstream outfile ("out.txt");
  if(outfile.is_open()){
    outfile << "Write to file as a stream\n";
  }
}
