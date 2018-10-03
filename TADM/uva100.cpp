#include<iostream>
#include<string>
#include<assert.h>
#include<vector>
#include<sstream>
using namespace std;

void giveLength(int & value, int &count);

int findMaxLengthBwtRange(const int& x, const int& y) {
	int max = 0;
	for (int i = x; i <= y; i++) {
		int count = 0;
		int tmp = i;
		giveLength(tmp, count);
		if (count > max)
			max = count;
	}
	return max;
}

void giveLength(int & value, int &count) {
	count++;
	if (value == 1) return;
	if (value % 2 == 1)
		value = value * 3 + 1;
	else
		value = value / 2;
	giveLength(value, count);
}

int main() {
	vector<int*> v;
	stringstream ss;
	int pos = 0;
	while (true)
	{
		string tmp;
		getline(cin, tmp);
		if (tmp == "") break;
		ss << tmp;
		int min, max;
		ss>>min;
		ss >> max;
		ss.clear();
		v.push_back(new int[3]);
		v[pos][0] = min;
		v[pos][1] = max;
		v[pos][2] = findMaxLengthBwtRange(min, max);
		pos++;
	}
	--pos;
	for (int i = 0; i <= pos; ++i)
		cout << v[i][0] << " " << v[i][1] << " " << v[i][2] << endl;
}

