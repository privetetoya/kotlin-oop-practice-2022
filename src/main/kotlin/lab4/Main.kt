package lab4

import lab4.controller.Controller
import lab4.model.Maze
import lab4.view.ConsoleUI

fun main() {
    val maze = Maze()
    ConsoleUI(maze)
    Controller(maze)
}