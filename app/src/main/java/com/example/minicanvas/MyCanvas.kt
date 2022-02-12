package com.example.minicanvas

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.core.content.res.ResourcesCompat

private const  val STROKE_WIDTH= 12f

class MyCanvas(context: Context) : View (context) {

    private lateinit var extraCanvas:Canvas
    private lateinit var extraBitmap: Bitmap
    private var path = Path()


    private val drawColor=  ResourcesCompat.getColor(resources,R.color.colorPaint,null)

    private val paint= Paint().apply {

        color= drawColor
        isAntiAlias= true
        isDither= true

        style= Paint.Style.STROKE
        strokeJoin= Paint.Join.ROUND
        strokeCap= Paint.Cap.ROUND
        strokeWidth= STROKE_WIDTH


    }



    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()


        extraBitmap= Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)

        extraCanvas= Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap,0f,0f,null)


    }


}