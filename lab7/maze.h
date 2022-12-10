#ifndef maze_h
#define maze_h
#include <iostream>

constexpr int size = 9;

//possible variations of coordinates
constexpr int x_moves[8] = {0,1,1,1,0,-1,-1,-1};
constexpr int y_moves[8] = {-1,-1,0,1,1,1,0,-1};	

class Maze{
public:
//CONSTRUCTORS
	//check the map in the file and eventually assign it to map_
	Maze(std::string filename);

//MEMBER FUNCTION
	//check if current position is an exit
	bool check_exit() const;
	//set the values of the boolean array entered representing the possible moves 
	void valid_moves(bool m[8]) const;
	//return if the position id valid for robot
	bool check_valid(int index) const;
	//return the initial x 
	int  get_x() const;
	//return the initial y
	int get_y() const;
	//set the new position for robot
	void move_robot(bool m[8]);
	//insertion operator	
	std::ostream& write(std::ostream& os) const;

private:
//DATA MEMBER
	char map_[size][size];
	int x_position_ = 1;
	int y_position_ = 1;
	std::string file_name_ = "test.txt";
};

//HELPER FUNCTION
	//check if the map is compatible with the maze 
	int check_map(char m[size][size+1]);
	//check if the coordinates entered are compatible with the maze
	bool check_position(int x, int y);

//OVERLOADED OPERATORS
	//insertion operator
	std::ostream& operator<<(std::ostream& os,const Maze& m);
#endif