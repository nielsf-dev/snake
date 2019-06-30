package nelis.org.snake.domain

import org.junit.Test
import org.junit.Assert.*

class SnakeTest{
    @Test
    fun testUpdate(){
        val snake = Snake()

        snake.direction = SnakeDirection.RIGHT
        snake.update()
        val head = snake.bodyParts.elementAt(0)
        assertEquals("snake moet vooruit bij update", 3, head.x)

        snake.direction = SnakeDirection.DOWN
        snake.update()
        assertEquals("snake moet naar beneden bij direction.DOWN", 1, head.y)

        snake.direction = SnakeDirection.LEFT
        snake.update()
        assertEquals("snake moet naar links", 1, head.y)
        assertEquals("snake moet naar links", 2, head.x)
    }

    @Test
    fun testDirection(){
        val snake = Snake()
        snake.direction = SnakeDirection.RIGHT
        snake.direction = SnakeDirection.LEFT
        assertEquals("kan niet de tegengestelde richting op", SnakeDirection.RIGHT, snake.direction)

        snake.direction = SnakeDirection.UP
        snake.direction = SnakeDirection.DOWN
        assertEquals("kan niet de tegengestelde richting op", SnakeDirection.UP, snake.direction)

        snake.direction = SnakeDirection.LEFT
        snake.direction = SnakeDirection.RIGHT
        assertEquals("kan niet de tegengestelde richting op", SnakeDirection.LEFT, snake.direction)

        snake.direction = SnakeDirection.DOWN
        snake.direction = SnakeDirection.UP
        assertEquals("kan niet de tegengestelde richting op", SnakeDirection.DOWN, snake.direction)

    }
}