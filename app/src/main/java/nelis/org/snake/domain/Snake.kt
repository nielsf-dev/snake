package nelis.org.snake.domain

class Snake{
    var direction: SnakeDirection = SnakeDirection.RIGHT
    val bodyParts: ArrayList<SnakePart> = ArrayList()

    constructor(){
        bodyParts.add(SnakePart(2,0))
        bodyParts.add(SnakePart(1,0))
        bodyParts.add(SnakePart(0,0))
    }

    fun updateRaster(raster: Raster){
        raster.x = "1"
    }

    fun grow(){

    }

    fun update() {
        for(i in (bodyParts.size-1) downTo 1){
            val snakePart = bodyParts[i]
            val prev = bodyParts[i-1]
            snakePart.x = prev.x
        }
        bodyParts[0].x ++
    }
}