Generate a world and provides interaction
•	The world must be pseudorandomly generated. 
•	The generated world must include rooms and hallways, though it may also include outdoor spaces.
•	At least some rooms should be rectangular, though you may support other shapes as well.
•	Your game must be capable of generating hallways that include turns (or equivalently, straight hallways that intersect).
•	The world should contain a random number of rooms and hallways.
•	The locations of the rooms and hallways should be random.
•	The width and height of rooms should be random.
•	The length of hallways should be random.
•	Rooms and hallways must have walls that are visually distinct from floors. Walls and floors should be visually distinct from unused spaces.
•	Rooms and hallways should be connected, i.e. there should not be gaps in the floor between adjacent rooms or hallways.
•	The world should be substantially different each time, i.e. you should not have the same basic layout with easily predictable features
The image below is an example of a world that meets all of these. In this image, # represents walls, a dot represents floors, and there is also one golden colored wall segment that represents a locked door. All unused spaces are left blank.

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img.jpg?raw=true)

After pressing N for “new game”, the user should be prompted to enter a “random seed”, which is an integer of their choosing. This integer will be used to generate the world randomly. After the user has pressed the final number in their seed, they should press S to tell the game that they’ve entered the entire seed that they want.
After the user has entered a seed and pressed S, the game should start. 
The user interface of the game must include:
A 2D grid of tiles showing the current state of the world.

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img_2.jpg?raw=true)

A “Heads Up Display” that provides additional information that maybe useful to the user. At the bare minimum, this should include Text that describes the tile currently under the mouse pointer.

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img_1.jpg?raw=true)
