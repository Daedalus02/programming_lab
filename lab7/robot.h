#ifndef robot_h
#define robot_h
#include <iostream>
#include "maze.h"
class Robot{
public: 
//CONSTRUCTORS
    Robot(const Robot& r) = delete;
    Robot(){}

//OPERATORS
    Robot& operator=(const Robot& r) = delete;

//MEMBER FUNCTIONS
    virtual bool move(Maze& m) = 0;

};

class RandomRobot : public Robot{
public:
//CONSTRUCTOR
    RandomRobot(){}

//MEMBER FUNCTIONS
    bool move(Maze& m) override;
};

class RightHandRuleRobot : public Robot{
public:
//CONSTRUCTORS
    RightHandRuleRobot(){}

//MEMBER FUNCTIONS
    bool move(Maze& m) override;

private:
//DATA MEMBER
    int last_direction;
};
#endif