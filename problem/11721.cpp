#include <iostream>
#include <string>
using namespace std;

int main() {
	string input;
	std::getline(cin, input);
	int size = input.length();
	for (int i = 1; i <= size; i++) {
		cout << input.at(i-1);
		if (i % 10 == 0)
			cout << '\n';
	}
	return 0;
}