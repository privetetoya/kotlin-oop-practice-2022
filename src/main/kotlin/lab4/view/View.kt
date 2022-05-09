package lab4.view

import lab4.model.Maze
import lab4.model.ModelChangeListener

class ConsoleUI(private val maze: Maze) {
    init {
        println(
            "Maze game\n" + "To move use w-a-s-d\n" + "To exit just type exit in console\n" + "Good game!\n"
        )
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        maze.addModelChangeListener(listener)

        repaint()
    }

    private fun repaint() {
        println(maze)
    }
}