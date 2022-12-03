#include <iostream>
#include "myvector.h"

int main(void){
    //Reserve and integer argument constructor test
    std::cout << "TESTING THE RESERVE FUNCTION, DIMENSION GETTER, INTEGER ARGUMENT CONSTRUCTOR:" << std::endl;
    MyVector<int> mv (10);
    mv.reserve(20);
    std::cout<<"The dimension of vector mv is: "<<mv.get_dimension()<<std::endl;
    
    //Testing the initilizer_list constructor, operator[](lvalue and rvalue), getters, print_all
    std::cout<<std::endl<<"TESTING THE INITILIZER LIST CONSTRUCTOR, OPERATOR[](LVALUE AND RVALUE), GETTERS , PRINT_ALL:"<<std::endl;
    MyVector<std::string> mv1 {"sd","bg","bg","vf","ds","we","er","fg","cd","ad"};
    std::cout<<"The dimension of vector mv1 is: "<<mv1.get_dimension()<<std::endl;
    std::cout<<"The size of vector mv1 is "<<mv1.get_size()<<std::endl;
    std::cout<<"Printing all the elements of the vector mv1: "<<std::endl;
    mv1[0] = "hp";
    mv1.print_all();

    //Testing push_back,pop_back
    std::cout<<std::endl<<"TESTING PUSH_BACK, POP_BACK :"<<std::endl;
    MyVector<int> mv3{};
    mv3.push_back(1);
    mv3.push_back(2);
    mv3.push_back(3);
    mv3.reserve(10);
    std::cout<<"Extracting the values contained in mv3 in reverse order: "<<std::endl;
    std::cout<<mv3.pop_back()<<" "<<mv3.pop_back()<<" "<<mv3.pop_back()<<std::endl;
    std::cout<<"The dimension of vector mv3 is: "<<mv3.get_dimension()<<std::endl;
    std::cout<<"The size of vector mv3 is: "<<mv3.get_size()<<std::endl;

    //Testing range check 
    std::cout<<std::endl<<"TESTING RANGE CHECK(AT), :"<<std::endl;
    MyVector<int> mv4 {1,2,3,4,5};
    try{
    for(int i = 0; i <= mv4.get_size(); i++){
        std::cout<<mv4.at(i)<<" ";
    }
    }catch(std::invalid_argument i){
        std::cout<<std::endl<<i.what()<<std::endl;
    }

    //Testing copy constructor, copy assignment
    std::cout<<std::endl<<"TESTING COPY CONSTRUCTOR, COPY ASSIGNMENT :"<<std::endl;
    MyVector<int> mv5 {1,2,3,4};
    MyVector<int> mv6 {mv5};
    std::cout<<"Printing the values of mv6 after initializing it with mv5({1, 2, 3, 4}) (copy constructor): "<<std::endl;
    mv6.print_all();
    mv5[0] = 34;
    mv6 = mv5;
    std::cout<<"Printing the values of mv6 after assigning a modified version of mv5({34, 2, 3, 4}) (copy assignment): "<<std::endl;
    mv6.print_all();

    //Testing move constructor, move assignement
    std::cout<<std::endl<<"TESTING COPY CONSTRUCTOR, COPY ASSIGNMENT :"<<std::endl;
    MyVector<int> mv7 {1,2,3,4};
    MyVector<int> mv8 = std::move(mv7);
    std::cout<<"Printing the values of mv8 after initializing it with mv7({1, 2, 3, 4}) (move constructor): "<<std::endl;
    mv8.print_all();
    //ripristinating mv7 with mv8
    std::cout<<"Ripristinating mv7 values with mv8."<<std::endl;
    mv7 = mv8;
    mv7[0] = 34;
    mv8 = std::move(mv7);
    std::cout<<"Printing the values of mv8 after assigning a modified version of mv7({34, 2, 3, 4}) (move assignment): "<<std::endl;
    mv8.print_all();

    return 0;
}
