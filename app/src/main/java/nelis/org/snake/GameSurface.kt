package nelis.org.snake

import android.content.Context
import android.graphics.Bitmap
import android.view.SurfaceView
import android.view.SurfaceHolder
import android.graphics.BitmapFactory
import android.graphics.Canvas
import nelis.org.snake.domain.Pig
import nelis.org.snake.domain.Raster
import nelis.org.snake.domain.Snake

class GameSurface(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private var snakeManager: SnakeManager

    private lateinit var gameThread: GameThread

    private lateinit var squareBitmap: Bitmap

    var left = 20f
    var top = 20f

    init {

        // Make Game Surface focusable so it can handle events. .
        this.isFocusable = true

        // Sét callback.
        this.holder.addCallback(this)
        this.snakeManager = SnakeManager(Snake(), Pig(), Raster())
    }

    fun update() {
        snakeManager.update()
        if(left <= top)
            left++
        else
            top++
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawBitmap(squareBitmap, left, top,null)
        snakeManager.draw(canvas)
    }

    // Implements method of SurfaceHolder.Callback
    override fun surfaceCreated(holder: SurfaceHolder) {
        squareBitmap = BitmapFactory.decodeResource(this.resources, R.drawable.square)

        this.gameThread = GameThread(this, holder)
        this.gameThread.setRunning(true)
        this.gameThread.start()
    }

    // Implements method of SurfaceHolder.Callback
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    // Implements method of SurfaceHolder.Callback
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry = true
        while (retry) {
            try {
                this.gameThread!!.setRunning(false)

                // Parent thread must wait until the end of GameThread.
                this.gameThread!!.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            retry = true
        }
    }

}
