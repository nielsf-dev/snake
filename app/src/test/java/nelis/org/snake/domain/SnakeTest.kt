package nelis.org.snake.domain

import org.junit.Test
import org.junit.Assert.*

class SnakeTest{
    @Test
    fun test(){
        val snake = Snake()
        snake.update()

        assertEquals("snake moet vooruit bij update", 3, snake.bodyParts[0].x)

        snake.direction = SnakeDirection.DOWN
        snake.update()

        assertEquals("snake moet naar beneden bij direction.DOWN", 1, snake.bodyParts[0].y)
    }
}