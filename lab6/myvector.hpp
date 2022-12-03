#include <iostream>
#include "myvector.h"

//CONSTRUCTORS
	template <typename T>
	MyVector<T>::MyVector(std::initializer_list<T> lst) : size_{lst.size()}, dimension_{lst.size()}, elements_{new T[lst.size()]}{
			std::copy(lst.begin(), lst.end(), elements_);
	}
	template <typename T>
	MyVector<T>::MyVector(int dim) : size_{dim}, dimension_{dim}, elements_{new T[dim]}{}
	template <typename T>
	MyVector<T>::MyVector(const MyVector& v) : size_{v.size_}, dimension_{v.dimension_}, elements_{new T[v.dimension_]}{
		std::copy(v.elements_, v.elements_ + v.dimension_, elements_);
	}
	template <typename T>
	MyVector<T>::MyVector(MyVector&& v) : size_{v.size_}, dimension_{v.dimension_}, elements_{v.elements_}{
		v.elements_ = nullptr;
		v.size_ = 0;
		v.dimension_ = 0;
	}
	
//MEMBER FUNCTIONS
	template <typename T>
	T MyVector<T>::at(int pos) const{
		if(pos < 0 || pos >= size_) throw std::invalid_argument("The position entered does not match the range of MyVector!");
		return elements_[pos];
	}
	template <typename T>
	void  MyVector<T>::push_back(T elem){
		if(size_ == dimension_){
			dimension_ = dimension_*2+1; //per trattare anche il caso dell'vector senza dimensione
			T* tmp = new T[dimension_];
			std::copy(elements_, elements_+size_,tmp);
			delete[] elements_;
			elements_ = tmp;
		}
		elements_[size_] = elem;
		size_++;
	}
	template <typename T>
	T MyVector<T>::pop_back(){
		if(size_ == 0){
			throw std::invalid_argument("pop_back not allowed, MyVector is empty!");
		}
		size_--;
		return elements_[size_];
	}
	template <typename T>
	void MyVector<T>::reserve(int dim){
		if(dim <= dimension_) return;
		T* tmp = new T[dim];
		std::copy(elements_, elements_ + size_, tmp);
		delete[] elements_;
		elements_ = tmp;
		dimension_ = dim;
	}
	template<typename T>
	void MyVector<T>::print_all(){
		if(size_ == 0) return;
		std::cout<<"{ ";
		for(int i = 0; i < size_; i++){
			std::cout<<elements_[i];
			if(i != (size_ - 1)) std::cout<<", ";
		}
		std::cout<<" }"<<std::endl;
	}
	
//MEMBER OPERATORS
	template <typename T>
	T MyVector<T>::operator[](int pos) const{
		return elements_[pos];
	}
	template<typename T>
	T& MyVector<T>::operator[](int pos){
		return elements_[pos];
	}
	template <typename T>
	MyVector<T>& MyVector<T>::operator=(const MyVector& v){
		T* tmp = new T[v.dimension_];
		std::copy(v.elements_,v.elements_+v.dimension_,tmp);
		delete[] elements_;
		elements_ = tmp;
		size_ = v.size_;
		dimension_ = v.dimension_;
		return *this;
	}
	template <typename T>
	MyVector<T>& MyVector<T>::operator=(MyVector&& v){
		T* tmp = new T[v.dimension_];
		std::copy(v.elements_,v.elements_+v.dimension_,tmp);
		delete[] elements_;
		elements_ = tmp;
		v.elements_ = nullptr;
		v.size_ = 0;
		v.dimension_ = 0;
		return *this;
	}

//DISTRUTTORE
	template<typename T>
	MyVector<T>::~MyVector(){
		delete[] elements_;
		elements_ = nullptr;
	}
	