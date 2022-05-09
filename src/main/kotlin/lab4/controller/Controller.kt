package lab4.controller

import lab4.model.Maze
import lab4.model.Status

class Controller(private val maze: Maze) {
    init {
        startGame()
    }

    private fun startGame() {
        while (maze.status == Status.MOVE) {
            val input = readln()
            try {
                maze.doMove(input.lowercase())
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}