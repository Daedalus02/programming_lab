#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "robot.h"

//RandomRobot
//MEMBER FUNCTIONS
    bool RandomRobot::move(Maze& m){
        bool moves[8] = {false};
        bool possible[8];
        m.valid_moves(possible);

        srand(time(NULL));
        int random_index = rand()%8;
        while(possible[random_index] == false){
            random_index = rand() % 8;
        }

        moves[random_index] = true;
        m.move_robot(moves);
        return m.check_exit();
    }

//RightHandRuleRobot
//MEMBER FUNCTIONS
    bool RightHandRuleRobot::move(Maze& m){
        bool moves[8] = {false};
        bool possible[8];
        m.valid_moves(possible);

        if(possible[2] == true){
            moves[2] = true; 
            m.move_robot(moves);
            return m.check_exit();
        }

        if(possible[last_direction]){
            moves[last_direction] = true; 
            m.move_robot(moves);
            return m.check_exit();
        }
        
        srand(time(NULL));
        int random_index = rand()%8;
        while(possible[random_index] == false){
            random_index = rand() % 8;
        }

        moves[random_index] = true;
        last_direction = random_index;
        m.move_robot(moves);
        return m.check_exit();
    }
