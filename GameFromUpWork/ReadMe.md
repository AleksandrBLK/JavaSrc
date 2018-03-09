# Generate a world and provides interaction<br><br>
•	The world must be pseudorandomly generated.<br> 
•	The generated world must include rooms and hallways, though it may also include outdoor spaces.<br>
•	At least some rooms should be rectangular, though you may support other shapes as well.<br>
•	Your game must be capable of generating hallways that include turns (or equivalently, straight hallways that intersect).<br>
•	The world should contain a random number of rooms and hallways.<br>
•	The locations of the rooms and hallways should be random.<br>
•	The width and height of rooms should be random.<br>
•	The length of hallways should be random.<br>
•	Rooms and hallways must have walls that are visually distinct from floors. Walls and floors should be visually distinct from unused spaces.<br>
•	Rooms and hallways should be connected, i.e. there should not be gaps in the floor between adjacent rooms or hallways.<br>
•	The world should be substantially different each time, i.e. you should not have the same basic layout with easily predictable features
The image below is an example of a world that meets all of these. In this image, # represents walls, a dot represents floors, and there is also one golden colored wall segment that represents a locked door. All unused spaces are left blank.<br><br>

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img.jpg?raw=true)
<br><br>
After pressing N for “new game”, the user should be prompted to enter a “random seed”, which is an integer of their choosing. This integer will be used to generate the world randomly. After the user has pressed the final number in their seed, they should press S to tell the game that they’ve entered the entire seed that they want.<br>
After the user has entered a seed and pressed S, the game should start.<br> <br>
The user interface of the game must include:<br>
A 2D grid of tiles showing the current state of the world.<br><br>

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img_2.jpg?raw=true)
<br><br>
A “Heads Up Display” that provides additional information that maybe useful to the user. At the bare minimum, this should include Text that describes the tile currently under the mouse pointer.<br><br>

![](https://github.com/AleksandrBLK/JavaSrc/blob/master/GameFromUpWork/img_1.jpg?raw=true)
