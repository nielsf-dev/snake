package nelis.org.snake.domain

import org.junit.Test
import org.junit.Assert.*

class SnakeTest{
    @Test
    fun test(){
        val snake = Snake()
        snake.update()

        assertEquals("snake moet vooruit", 3, snake.bodyParts[0].x)
    }
}