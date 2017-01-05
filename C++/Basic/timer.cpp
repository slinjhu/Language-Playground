#include<iostream>
#include<chrono>
#include<vector>

typedef std::chrono::high_resolution_clock HRTime;
typedef std::chrono::time_point<HRTime> TimePoint;
typedef std::chrono::duration<float> FloatSecond;

void task(){
  std::vector<int> xx (1 << 25, 0);
  for(int & x : xx) x = rand();
}

int main(){
  TimePoint t0 = HRTime::now();
  task();
  TimePoint t1 = HRTime::now();
  float duration = ((FloatSecond)(t1 - t0)).count();

  std::cout << duration << " second\n";
}
