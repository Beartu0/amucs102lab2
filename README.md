CPE102 Lab 2 — Java Hotel Reservation System (Plain README)
===========================================================

Author: Beartu
Course: CPE 102 – Computer Programming II (Spring 2024–2025)
Assignment: Lab 2

--------------------------------------------------

Project Goals
-------------

This Java project implements a hotel reservation system using a **2D boolean array**. 
It allows users to:

1. Display the current hotel floor plan
2. Book a specific room
3. Find the first free room in a given range
4. Free an occupied room
5. Find three consecutive free rooms
6. Show the total number of occupied rooms
7. Exit the system

All interactions are menu-driven and use `Scanner` for input handling.

--------------------------------------------------

Folder Structure
----------------

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources (App.java, App2.java, app3.java)
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder.

--------------------------------------------------

Build & Run
-----------

Requirements:
- JDK 17 or later
- Command-line interface

To compile:
    javac -d bin src/*.java

To run:
    java -cp bin App

You can also run `App2` or `app3` classes manually if needed.

--------------------------------------------------

Implementation Notes
--------------------

- The hotel is modeled with a `boolean[][]` array where `true` means occupied, `false` means available.
- Random room initialization is used in some implementations.
- Invalid room selections are handled with warnings.
- User-friendly error messages are provided for invalid inputs.
- Separate methods are used for each functionality to improve modularity.

--------------------------------------------------

End of README