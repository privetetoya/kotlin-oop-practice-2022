package lab4.model
//"C:\\Users\\Ирина Анатольевна\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\maze"
import java.io.File

enum class Cell(private val textValue: String) {
    WALL("\uD83E\uDDF1"), PLAYER("\uD83E\uDD20"), WAY(" "), EXIT("\uD83C\uDFC1"), EMPTY(" ");

    override fun toString(): String {
        return textValue
    }
}

enum class Status() {
    MOVE, EXIT, WIN;
}

interface ModelChangeListener {
    fun onModelChanged()
}

private var mazeLength: Int = 0
private var mazeWidth: Int = 0

class Maze {
    private val maze: MutableList<MutableList<Cell>> = createMaze()
    private var playerPosition = playerPosition()
    var status: Status = Status.MOVE
    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()
    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun createMaze(): MutableList<MutableList<Cell>> { //Creating a Maze
        val file =
            File("C:\\Users\\Ирина Анатольевна\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\maze").readLines()
        mazeLength = file.size
        mazeWidth = file[0].length
        val maze = MutableList(file.size) {
            MutableList(mazeWidth) { Cell.EMPTY }
        }

        for (i in file.indices) {
            for (j in 0 until file[0].length) {
                if (file[i][j] == 'P') {
                    maze[i][j] = Cell.PLAYER
                } else if (file[i][j] == 'E') {
                    maze[i][j] = Cell.EXIT
                } else if (file[i][j] == '-') {
                    maze[i][j] = Cell.WAY
                } else {
                    maze[i][j] = Cell.WALL
                }
            }
        }
        return maze
    }

    private fun playerPosition(): Pair<Int, Int> { //Bubble sort for player position
        var result = Pair(0, 0)
        for (i in 0 until mazeLength) {
            for (j in 0 until mazeWidth) {
                if (maze[i][j] == Cell.PLAYER) {
                    result = Pair(i, j)
                }
            }
        }
        return result
    }

    fun doMove(key: String) { //Move constructor
        require(status == Status.MOVE)
        when (key) {
            "w" -> {
                when (maze[playerPosition.first - 1][playerPosition.second]) {
                    Cell.WAY -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first - 1][playerPosition.second] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first - 1, playerPosition.second)
                    }
                    Cell.EXIT -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first - 1][playerPosition.second] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first - 1, playerPosition.second)
                        status = Status.WIN
                        println("Congratulations!!!")
                    }
                    Cell.WALL -> {
                        error("The wall! I can't move!")
                    }
                }
            }
            "a" -> {
                when (maze[playerPosition.first][playerPosition.second - 1]) {
                    Cell.WAY -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first][playerPosition.second - 1] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first, playerPosition.second - 1)
                    }
                    Cell.EXIT -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first][playerPosition.second - 1] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first, playerPosition.second - 1)
                        status = Status.WIN
                        println("Congratulations!!!")
                    }
                    Cell.WALL -> {
                        error("The wall! I can't move!")
                    }
                }
            }
            "s" -> {
                when (maze[playerPosition.first + 1][playerPosition.second]) {
                    Cell.WAY -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first + 1][playerPosition.second] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first + 1, playerPosition.second)
                    }
                    Cell.EXIT -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first + 1][playerPosition.second] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first + 1, playerPosition.second)
                        status = Status.WIN
                        println("Congratulations!!!")
                    }
                    Cell.WALL -> {
                        error("The wall! I can't move!")
                    }
                }
            }
            "d" -> {
                when (maze[playerPosition.first][playerPosition.second + 1]) {
                    Cell.WAY -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first][playerPosition.second + 1] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first, playerPosition.second + 1)
                    }
                    Cell.EXIT -> {
                        maze[playerPosition.first][playerPosition.second] = Cell.WAY
                        maze[playerPosition.first][playerPosition.second + 1] = Cell.PLAYER
                        playerPosition = Pair(playerPosition.first, playerPosition.second - 1)
                        status = Status.WIN
                        println("Congratulations!!!")
                    }
                    Cell.WALL -> {
                        error("The wall! I can't move!")
                    }
                }
            }
            "exit" -> {
                status = Status.EXIT
            }
            else -> {
                println("Input error!!!")
            }
        }
        notifyListeners()
    }

    override fun toString(): String {
        return buildString {
            if (status != Status.EXIT) {
                maze.forEach {
                    append(it).appendLine()
                }
            }
            append(status).appendLine()
        }
    }
}