 #include <iostream>
#include "maze.h"
#include <fstream>

//HELPER FUNCTION
	int check_map(char m[size][size+1]){
		bool s_pos = false;
		int x = 1;
		int y = 1;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(m[i][j] != ' ' && m[i][j] != '*' && m[i][j] != 'E' && m[i][j] != 'S' && m[i][j] != '\n'){
					throw std::invalid_argument("Map entered is not valid: characters not allowed!");
				}
				if(m[i][j] == 'E' && (i != (size-1) && j != (size-1) && i != 0 && j != 0)){

					throw  std::invalid_argument("Map entered is not valid: some exits are not correct!");
				}
				if(m[i][j] == 'S'){
					if(s_pos) throw std::invalid_argument("Map entered is not valid: robot position is not unique!");
					s_pos = true;
					x = i;
					y = j;
				}
			}
		}
		return (x+y*10);
	}
	bool check_position(int x, int y){
		if(x < size && x > -1 && y < size && y > -1){
			return true;
		}
		return false;
	}


//CONSTRUCTORS
	Maze::Maze(std::string filename){
		char tmp_map[size][size+1];
		filename = filename + ".txt";
		std::fstream file_reader(filename); 
		if(file_reader.is_open()){
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					file_reader.get(tmp_map[j][i]);
				}
			}
			file_reader.close();
			file_name_ = filename;
		}else{
			throw std::invalid_argument("Cannot open the file, check the file name!");
		}
		int pos = check_map(tmp_map);
		x_position_ = pos%10;
		y_position_ = pos/10;
		//std::cout<<x_position_<<y_position_<<std::endl;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				map_[i][j] = tmp_map[i][j];
			}
		}
	}
	
//MEMBER FUNCTIONS
	bool Maze::check_exit(int x, int y) const{
		check_position(x, y);
		if(x == 0 || x == (size-1) || y == 0 || y == (size-1)){
			return true;
		}
		return false;
	}
	std::ostream& Maze::write(std::ostream& os) const{
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				os << map_[j][i];
			}
			os << '\n';
		}
	}
	bool Maze::check_valid(int index) const{
		return check_position(x_position_+x_moves[index],y_position_+y_moves[index]) && (map_[x_position_+x_moves[index]][y_position_+y_moves[index]] == ' ' || map_[x_position_+x_moves[index]][y_position_+y_moves[index]] == 'E' );
	}
	void Maze::valid_moves(bool m[8]) const{
		for(int i = 0; i < 8; i++){
			m[i] = check_valid(i);
		}
	}
	int Maze::get_x() const{
		return x_position_;
	}
	int Maze::get_y() const{
		return y_position_;
	}
	bool Maze::move_robot(bool m[8]){
		bool moved = false;
		for(int i = 0; i < 8; i++){
			if(m[i] == true){
				if(!check_valid(i)){
					throw std::invalid_argument("Not a possible move in current position!");
				}
				map_[x_position_][y_position_] = ' ';
				x_position_ = x_position_ + x_moves[i];
				y_position_ = y_position_ + y_moves[i];
				if(map_[x_position_][y_position_] == 'E'){
					map_[x_position_][y_position_] = 'S';
					return true;
				}
				map_[x_position_][y_position_] = 'S';
				moved = true;
			}
		}
		if(!moved){
			throw std::invalid_argument("No possible moves in current position!");
		}
		return false;
	}

//OPERATORS
	std::ostream& operator<<(std::ostream& os,const Maze& m){
		return m.write(os);
	}