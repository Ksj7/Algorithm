#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
struct Person {
	int age;
	int order;
	string name;

};
bool cmp(const Person &u, const Person &v) {
    if (u.age < v.age) {
        return true;
	}
	else if (u.age == v.age) {
		return u.order < v.order;
	}
	return false;
}
int main() {
    int n;
	cin >> n;
    vector<Person> PersonList(n);
	
    for (int i=0; i<n; i++) {
		cin >> PersonList[i].age >> PersonList[i].name ;
		PersonList[i].order = i;
    }
    sort(PersonList.begin(), PersonList.end(),cmp);
    for (int i=0; i< n; i++) {
        cout << PersonList[i].age << ' ' << PersonList[i].name << '\n';
    }
    return 0;
}