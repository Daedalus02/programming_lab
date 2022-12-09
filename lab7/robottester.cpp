#include <iostream>
#include <unistd.h>
#include "robot.h"
#include "maze.h"

constexpr int move_limit = 20;

int main(void){

    //RandomRobot test
    std::cout<<"RandomRobot test, trying to reach the exit from the following maze: "<<std::endl;
    RandomRobot rr;
    Maze m1{"test"};
    std::cout<<m1<<std::endl;
    int move_counter = 1;
    for(;!m1.check_exit(m1.get_x(),m1.get_y()) && move_counter < move_limit;move_counter++){
        if(rr.move(m1)){
            std::cout<<m1<<std::endl<<"RandomRobot got to an exit in :"<<move_counter<<" moves"<<std::endl;
            break;
        }
        std::cout<<m1<<std::endl;
        sleep(1);
    }
    if(move_counter == 20){
        std::cout<<"RandomRobot didn't get to an exit in the moves limit!"<<std::endl;
    }

    std::cout<<std::endl<<"RightHandRuleRobot test, trying to reach the exit from the following maze: "<<std::endl;
    RightHandRuleRobot rrrr;
    Maze m2{"test"};
    std::cout<<m2<<std::endl;
    int move_counter2 = 0;
    for(;!m2.check_exit(m2.get_x(),m2.get_y()) && move_counter2 < move_limit;move_counter2++){
        if(rrrr.move(m2)){
            std::cout<<m2<<std::endl<<"RightHandRuleRobot got to an exit in :"<<move_counter2<<" moves"<<std::endl;
            break;
        }
        std::cout<<m2<<std::endl;
        sleep(1);
    }

    return 0;
}
