package nelis.org.snake.domain

import java.util.LinkedHashSet

class Snake{
    private var _direction: SnakeDirection = SnakeDirection.RIGHT
    var direction:SnakeDirection
        get(){
            return _direction
        }
        set(value){
            if(_direction == SnakeDirection.RIGHT && value == SnakeDirection.LEFT)
                return
            if(_direction == SnakeDirection.DOWN && value == SnakeDirection.UP)
                return
            if(_direction == SnakeDirection.UP && value == SnakeDirection.DOWN)
                return
            if(_direction == SnakeDirection.LEFT && value == SnakeDirection.RIGHT)
                return

            _direction = value
        }

    constructor(){
        bodyParts.add(SnakePart(2,0))
        bodyParts.add(SnakePart(1,0))
        bodyParts.add(SnakePart(0,0))
    }

    val bodyParts: LinkedHashSet<SnakePart> = LinkedHashSet()

    fun update() {
        for(i in (bodyParts.size-1) downTo 1){
            val snakePart = bodyParts.elementAt(i)
            val prev = bodyParts.elementAt(i-1)
            snakePart.x = prev.x
            snakePart.y = prev.y
        }

        val head = bodyParts.elementAt(0)
        if(_direction == SnakeDirection.RIGHT) {
            head.x ++        }
        if(_direction == SnakeDirection.DOWN)
            head.y ++
        if(_direction == SnakeDirection.LEFT)
            head.x --
        if(_direction == SnakeDirection.UP)
            head.y --
    }
}