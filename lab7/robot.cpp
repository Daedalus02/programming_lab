#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "robot.h"

//RandomRobot
//MEMBER FUNCTIONS
    bool RandomRobot::move(Maze& m){
        srand(time(NULL));
        bool moves[8] = {false};
        bool possible[8];
        m.valid_moves(possible);
        int random_index = rand()%8;
        while(possible[random_index] == false){
            random_index = rand() % 8;
        }
        moves[random_index] = true;
        return m.move_robot(moves);
    }

//RightHandRuleRobot
    bool RightHandRuleRobot::move(Maze& m){
        bool moves[8] = {false};
        bool possible[8];
        m.valid_moves(possible);
        if(possible[2] == true){
            moves[2] = true; 
            return m.move_robot(moves);
        }
        srand(time(NULL));
        int random_index = rand()%8;
        while(possible[random_index] == false){
            random_index = rand() % 8;
        }
        moves[random_index] = true;
        return m.move_robot(moves);
    }
