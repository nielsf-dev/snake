package nelis.org.snake.domain

import java.util.LinkedHashSet

class Snake{

    var direction:SnakeDirection
        set(value){
            if(field == SnakeDirection.RIGHT && value == SnakeDirection.LEFT)
                return
            if(field == SnakeDirection.DOWN && value == SnakeDirection.UP)
                return
            if(field == SnakeDirection.UP && value == SnakeDirection.DOWN)
                return
            if(field == SnakeDirection.LEFT && value == SnakeDirection.RIGHT)
                return

            field = value
        }

    val bodyParts: LinkedHashSet<SnakePart>

    private var tail: SnakePart

    constructor(){
        direction = SnakeDirection.RIGHT

        bodyParts = LinkedHashSet()
        bodyParts.add(SnakePart(2,0))
        bodyParts.add(SnakePart(1,0))

        tail = SnakePart(0, 0)
        bodyParts.add(tail)
    }

    fun grow(){
        //TODO: add part @ tail
    }

    fun update() {
        val tailIndex = bodyParts.size - 1
        tail = bodyParts.elementAt(tailIndex)

        for(i in tailIndex downTo 1){
            val snakePart = bodyParts.elementAt(i)
            val prev = bodyParts.elementAt(i-1)
            snakePart.x = prev.x
            snakePart.y = prev.y
        }

        val head = bodyParts.elementAt(0)
        if(direction == SnakeDirection.RIGHT)
            head.x ++
        if(direction == SnakeDirection.DOWN)
            head.y ++
        if(direction == SnakeDirection.LEFT)
            head.x --
        if(direction == SnakeDirection.UP)
            head.y --
    }
}