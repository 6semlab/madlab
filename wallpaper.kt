//<uses-permission android:name="android.permission.SET_WALLPAPER" />

import android.app.WallpaperManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var wallpaperlist: Array<Int> =arrayOf(R.drawable.img,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3)
    private lateinit var chwall : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chwall=findViewById(R.id.startbtn)
        chwall.setOnClickListener { setwall() }

    }
    fun setwall(){

        Handler().postDelayed(
            {
                for (i in wallpaperlist) {
                    val manager = WallpaperManager.getInstance(baseContext)
                    manager.setResource(i)
                    Thread.sleep(3000)
                }
            }
        ,4000)
    }

}
