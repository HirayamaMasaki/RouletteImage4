package com.example.rouletteimage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.Bitmap.CompressFormat
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val myView = MyView(this)
//        setContentView(myView)

        val editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, RouletteScreen::class.java)

            val etText1 = editTextTextPersonName.text.toString()
            val etText2 = editTextNumber1.text.toString()
            val etText3 = editTextNumber2.text.toString()

            //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
            intent.putExtra("key1",etText1)
            intent.putExtra("key2",etText2)
            intent.putExtra("key3",etText3)
            startActivity(intent)
            finish()
        }
    }

//    override fun onStart() {
//        super.onStart()
////        setContentView(R.layout.activity_main)
//
//    }

//     Viewを継承したクラス
    internal inner class MyView(context: Context) : View(context) {

        private var paint: Paint = TODO()
        private val paint1 = Paint()
        private val paint2 = Paint()
        private val paint3 = Paint()
        private val paint4 = Paint()
        private val paint5 = Paint()
        private val paint6 = Paint()
        private val paint7 = Paint()
        private val paint8 = Paint()
        private val paint9 = Paint()
        private val paint10 = Paint()
        private val dm = DisplayMetrics()
        internal val width = dm.widthPixels
        internal val height = dm.heightPixels

        private var sum by Delegates.notNull<Float>()

        @SuppressLint("DrawAllocation")
        override fun onDraw(canvas: Canvas){
            rouletteMaking(canvas,1f,1f,2f,1f,1f,5f,4f,1f,1f,1f)
        }

        private fun rouletteMaking(canvas: Canvas, a:Float, b:Float?, c:Float?, d:Float?, e:Float?, f:Float?, g:Float?, h:Float?, i:Float?, j:Float?) {
            // 背景、半透明
            canvas.drawColor(Color.argb(0, 0, 0, 0))

            // 円
            paint.color = Color.argb(255, 0, 0, 0)
            paint.strokeWidth = 5f
            paint.isAntiAlias = true
            paint.style = Paint.Style.STROKE

            // 分岐
            if (height >= width) {
                // 円
                // (x1,y1,r,paint) 中心x1座標, 中心y1座標, r半径
                canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2.5).toFloat(), paint)
                // 各項目
                val rect = RectF((width / 10).toFloat(), (height / 2 - 2 * width / 5).toFloat(), (9 * width / 10).toFloat(), (height / 2 + 2 * width / 5).toFloat())
                itemRation(canvas,rect, a, b, c, d, e, f, g, h, i, j)

            } else {
                // 円
                canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (height / 2.5).toFloat(), paint)
                //　各項目
                val rect = RectF((width / 2 - 2 * height / 5).toFloat(), (height / 10).toFloat(), (width / 2 + 2 * height / 5).toFloat(), (9 * height / 10).toFloat())
                itemRation(canvas,rect,a, b, c, d, e, f, g, h, i, j)
            }

            //保存用Bitmap準備
            val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            //新しいcanvasに保存用Bitmapをセット
            Canvas(image)
            //canvasに対して描画
            try {
                //出力ファイルを準備
                val fos = FileOutputStream(File("sample.png"))
                //PNG形式で出力
                image.compress(CompressFormat.PNG, 100, fos)
                fos.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        private fun itemRation(canvas: Canvas, rect: RectF, a:Float, b:Float?, c:Float?, d:Float?, e:Float?, f:Float?, g:Float?, h:Float?, i:Float?, j:Float?){
            if (b != null && c != null && d != null && e != null && f != null && g != null && h != null && i != null && j != null) {
                sum = a + b + c + d + e + f + g + h + i + j
            } else if(b != null && c != null && d != null && e != null && f != null && g != null && h != null && i != null){
                sum = a + b + c + d + e + f + g + h + i
            } else if(b != null && c != null && d != null && e != null && f != null && g != null && h != null){
                sum = a + b + c + d + e + f + g + h
            } else if(b != null && c != null && d != null && e != null && f != null && g != null){
                sum = a + b + c + d + e + f + g
            } else if(b != null && c != null && d != null && e != null && f != null){
                sum = a + b + c + d + e + f
            } else if(b != null && c != null && d != null && e != null){
                sum = a + b + c + d + e
            } else if(b != null && c != null && d != null){
                sum = a + b + c + d
            } else if(b != null && c != null){
                sum = a + b + c
            } else if(b != null){
                sum = a + b
            } else{
                sum = a
            }

            val a0 : Float = a/sum
            val b0 : Float? = b?.div(sum)
            val c0 : Float? = c?.div(sum)
            val d0 : Float? = d?.div(sum)
            val e0 : Float? = e?.div(sum)
            val f0 : Float? = f?.div(sum)
            val g0 : Float? = g?.div(sum)
            val h0 : Float? = h?.div(sum)
            val i0 : Float? = i?.div(sum)
            val j0 : Float? = j?.div(sum)

            paint1.color = Color.argb(195, 233, 58, 36)
            canvas.drawArc(rect, -90F, a0*360, true, paint1)
            paint2.color = Color.argb(195, 234, 97, 25)
            if (b0 != null) {
                canvas.drawArc(rect, -90F+a0*360, b0*360, true, paint2)
            }
            paint3.color = Color.argb(195, 252, 202, 0)
            if (c0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!)*360, c0*360, true, paint3)
            }
            paint4.color = Color.argb(195, 184, 198, 1)
            if (d0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!)*360, d0*360, true, paint4)
            }
            paint5.color = Color.argb(195, 58, 149, 42)
            if (e0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!)*360, e0*360, true, paint5)
            }
            paint6.color = Color.argb(195, 10, 151, 114)
            if (f0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!)*360, f0*360, true, paint6)
            }
            paint7.color = Color.argb(195, 24, 158, 151)
            if (g0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!)*360, g0*360, true, paint7)
            }
            paint8.color = Color.argb(195, 89, 113, 157)
            if (h0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!)*360, h0*360, true, paint8)
            }
            paint9.color = Color.argb(195, 104, 68, 126)
            if (i0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!+ h0!!)*360, i0*360, true, paint9)
            }
            paint10.color = Color.argb(195, 224, 61, 114)
            if (j0 != null) {
                canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!+ h0!!+ i0!!)*360, j0*360, true, paint10)
            }
        }
    }


//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun rouletteMaking(canvas: Canvas, a:Float, b:Float?, c:Float?, d:Float?, e:Float?, f:Float?, g:Float?, h:Float?, i:Float?, j:Float?) {
//        // 背景、半透明
//        canvas.drawColor(Color.argb(0, 0, 0, 0))
//
//        // 円
//        paint.color = Color.argb(255, 0, 0, 0)
//        paint.strokeWidth = 5f
//        paint.isAntiAlias = true
//        paint.style = Paint.Style.STROKE
//
//        // 分岐
//        if (height >= width) {
//            // 円
//            // (x1,y1,r,paint) 中心x1座標, 中心y1座標, r半径
//            canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2.5).toFloat(), paint)
//            // 各項目
//            val rect = RectF((width / 10).toFloat(), (height / 2 - 2 * width / 5).toFloat(), (9 * width / 10).toFloat(), (height / 2 + 2 * width / 5).toFloat())
//            itemRation(canvas,rect, a, b, c, d, e, f, g, h, i, j)
//
//        } else {
//            // 円
//            canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (height / 2.5).toFloat(), paint)
//            //　各項目
//            val rect = RectF((width / 2 - 2 * height / 5).toFloat(), (height / 10).toFloat(), (width / 2 + 2 * height / 5).toFloat(), (9 * height / 10).toFloat())
//            itemRation(canvas,rect,a, b, c, d, e, f, g, h, i, j)
//        }
//
//        //保存用Bitmap準備
//        val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
//        //新しいcanvasに保存用Bitmapをセット
//        Canvas(image)
//        //canvasに対して描画
//        try {
//            //出力ファイルを準備
//            val fos = FileOutputStream(File("sample.png"))
//            //PNG形式で出力
//            image.compress(CompressFormat.PNG, 100, fos)
//            fos.close()
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//    }
//
//    private fun itemRation(canvas: Canvas, rect: RectF, a:Float, b:Float?, c:Float?, d:Float?, e:Float?, f:Float?, g:Float?, h:Float?, i:Float?, j:Float?){
//        if (b != null && c != null && d != null && e != null && f != null && g != null && h != null && i != null && j != null) {
//            sum = a + b + c + d + e + f + g + h + i + j
//        } else if(b != null && c != null && d != null && e != null && f != null && g != null && h != null && i != null){
//            sum = a + b + c + d + e + f + g + h + i
//        } else if(b != null && c != null && d != null && e != null && f != null && g != null && h != null){
//            sum = a + b + c + d + e + f + g + h
//        } else if(b != null && c != null && d != null && e != null && f != null && g != null){
//            sum = a + b + c + d + e + f + g
//        } else if(b != null && c != null && d != null && e != null && f != null){
//            sum = a + b + c + d + e + f
//        } else if(b != null && c != null && d != null && e != null){
//            sum = a + b + c + d + e
//        } else if(b != null && c != null && d != null){
//            sum = a + b + c + d
//        } else if(b != null && c != null){
//            sum = a + b + c
//        } else if(b != null){
//            sum = a + b
//        } else{
//            sum = a
//        }
//
//        val a0 : Float = a/sum
//        val b0 : Float? = b?.div(sum)
//        val c0 : Float? = c?.div(sum)
//        val d0 : Float? = d?.div(sum)
//        val e0 : Float? = e?.div(sum)
//        val f0 : Float? = f?.div(sum)
//        val g0 : Float? = g?.div(sum)
//        val h0 : Float? = h?.div(sum)
//        val i0 : Float? = i?.div(sum)
//        val j0 : Float? = j?.div(sum)
//
//        paint1.color = Color.argb(195, 233, 58, 36)
//        canvas.drawArc(rect, -90F, a0*360, true, paint1)
//        paint2.color = Color.argb(195, 234, 97, 25)
//        if (b0 != null) {
//            canvas.drawArc(rect, -90F+a0*360, b0*360, true, paint2)
//        }
//        paint3.color = Color.argb(195, 252, 202, 0)
//        if (c0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!)*360, c0*360, true, paint3)
//        }
//        paint4.color = Color.argb(195, 184, 198, 1)
//        if (d0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!)*360, d0*360, true, paint4)
//        }
//        paint5.color = Color.argb(195, 58, 149, 42)
//        if (e0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!)*360, e0*360, true, paint5)
//        }
//        paint6.color = Color.argb(195, 10, 151, 114)
//        if (f0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!)*360, f0*360, true, paint6)
//        }
//        paint7.color = Color.argb(195, 24, 158, 151)
//        if (g0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!)*360, g0*360, true, paint7)
//        }
//        paint8.color = Color.argb(195, 89, 113, 157)
//        if (h0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!)*360, h0*360, true, paint8)
//        }
//        paint9.color = Color.argb(195, 104, 68, 126)
//        if (i0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!+ h0!!)*360, i0*360, true, paint9)
//        }
//        paint10.color = Color.argb(195, 224, 61, 114)
//        if (j0 != null) {
//            canvas.drawArc(rect, -90F+(a0+ b0!!+ c0!!+ d0!!+ e0!!+ f0!!+ g0!!+ h0!!+ i0!!)*360, j0*360, true, paint10)
//        }
//    }

}