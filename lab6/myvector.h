#ifndef MyVector_h
#define MyVector_h
#include <iostream>

template <typename T>
class MyVector{
public:
//CONSTRUCTORS
	//constructor with initializer_list
	MyVector(std::initializer_list<T> lst);
	//constructor with size
	explicit MyVector(int dim = 0);
	//copy constructor
	MyVector(const MyVector& v);
	//move constructor
	MyVector(MyVector&& v);
	
//MEMBER FUNCTIONS
	//return the value in the position pos (with range check)
	T at(int pos) const;
	//add a value at the end of the vector
	void  push_back(T elem);
	//cut the last element of the vector and return it 
	T pop_back();
	//reserve a space in memory for the vector
	void reserve(int dim);
	
//MEMBER OPERATORS
	//return the value at position pos (without range check), rvalue
	T operator[](int pos) const;
	//operator[] lvalue
	T& operator[](int pos);
	//copy asssignment
	MyVector& operator=(const MyVector& v);
	//move assignment
	MyVector& operator=(MyVector&& v);
	//getters
	int get_dimension(){return dimension_;}
	int get_size(){return size_;}
	//print all elements
	void print_all();	
//DISTRUTTORE
	~MyVector();
	
private:
//DATA MEMBERS
	//represents the number of elements in the vector
	int size_ = 0;
	//pointer the the first element of the vector
	T* elements_ = nullptr;
	//represents the number of elements that could stay in the vector for current dimension in memory
	int dimension_ = 0;
};
#include "myvector.hpp"
#endif