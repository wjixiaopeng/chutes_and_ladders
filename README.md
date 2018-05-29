# Chutes and Ladders

## Prerequisites
  * JDK 1.8
  * Put the config file(`boardInfo.txt`) into same directory of this project
  * I also create a jar file, you can easily run the program with `ChutesAndLadders.jar`.

## Documentation
All detail documentation formated in Javadoc HTML and generated by Javadoc. What is inclued is all Class Hierarchy, decription of data field, constructor and method in every specfic class.

Check do on [here](https://wjixiaopeng.github.io/chutes_and_ladders/index.html)

## Running Process of Project

### Load Config file
Method `gameController.initializeBoard(boardInfo.txt)` will initialize Game Board.

Sample of `BoardInfo.txt`:
	
		4
		1
		2-->4
		3-->1
		4

**First line** : `4` means capacity of Board also is finish Square of game

**Remeaning lines** : 
1. `1` : without `-->` that means **Normal Square**
2. `2-->4` that means **Ladder Square**(left number < right number)
3. `3-->1` that means **Chute Square**(left number > right number)

### Add Players
Method `gameController.addPlayers()` will use `Scanner` to prompt player input
1. Input how many players will play this game. **Only 2 - 4 players allowed**
2. Input every Player's name

### Shuffle Players
Method `gameController.shufflePlayers()` will shuffle players by **spin number** and decide who will play first

1. Every Player will get a spin number 
2. Sort Players by spin number's descending order

**ASSUMPTIONS**: Spin number could be same

**SOLUTION**: Remain players who are tied will keep spinning untial no one has same spin number.

### Simulating the Game
Method `gameController.run()` will simulate all process of every turn of players

1. Generate a random number by spin: a integer between `1 - 6` will be generated
2. Move player to next Square. System will check next Square's type and decide to how to move player.

**ASSUMPTIONS**: 
Due to costom board, ladders or chutes could be trigger multiple times continuously in each player's turn
eg.

```
	1 --LADDER--> 2 --LADDER --> 5
	2 --LADDER--> 30 --CHUTE --> 17
``` 
**SOLUTION**: 
When a pawn reached square will trigger multiple ladder or chute actions, the method `getNextAllSquares` will be called **recursively** until the last square's type is normal. The information of each passed squares will be stored in a list*


### How to Win
If first player reach the end of Board **exactly**, this player win! if spin take player past last square, don't move. Try again on next turn.

```
100 is finish position, and user is on 97 right now. Only spined number 3, he could win the game
```

## ToDo for Future
1. Friendly GUI and user interaction should be added on project.
2. Project should be deployed on server with network features. Client would play this game by online application.
3. Use database to store all information. Player info, game history
4. This project should be added all test. Unit Test, API test and so on.
