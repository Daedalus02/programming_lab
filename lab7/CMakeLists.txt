#the name of the target os
set(CMAKE_SYSTEM_NAME Linux)

#setting a minimum version for compiler
cmake_minimum_required(VERSION 2.8 FATAL_ERROR)

project(maze LANGUAGES CXX)

add_executable(mazetest
    robottester.cpp
    maze.cpp
    robot.cpp
)

