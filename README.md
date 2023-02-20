# Maze Game - Find the shortest path!
In this application, you can create a hexagon maze by giving its width and its height. By setting the starting point and end point, a shortest path will be shown on maze. There is also possibility to choose wall box where the path will be blocked. 

This application is fully developped with [Java](https://www.java.com/en/) and it uses Java Swing for interface.

## Summary
- [What is the aim of project?]
- [How to run and use this application?]
- [Tips of usage]

## What is the aim of project?
The goal of the project is to use implementation of Dijkstra's algorithm to solve a hexagonal maze and to provide a shortest path. Figure below shows an example of hexagonal maze with dimension of 10x10.
![register](./projetJava/images/HexagonMaze.png)

Every odd-numbered row is shifted to the right and every hexagon case has 6 neighbors surrounding it.

The project consists of a graphical interface where users will be able to configure his labyrinth with its entry and exit points, launch the Dijkstra algorithm and display the result. The maze configured can be saved in a file and be imported for reusage.

The main functions of this applcation are:
- Create an empty labyrinth by giving its dimension.
- Choose entry point and exit point by clicking directly on the hexagon case.
- Choose some wall case where path is not allowed.
- Launch Dijkstra and display shortest path on maze.
- Save edited maze in text file.
- Import maze 

## How to run and use this application?

