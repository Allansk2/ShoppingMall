package com.allan.messagecenter.widgets


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.ViewFlipper
import com.allan.messagecenter.R
import org.jetbrains.anko.dimen
import org.jetbrains.anko.find
import org.jetbrains.anko.px2sp


class NewsFlipperView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
    private val mFlipperView: ViewFlipper

    init {
        val rootView = View.inflate(context, R.layout.layout_news_flipper, null)
        mFlipperView = rootView.find(R.id.mFlipperView)
        mFlipperView.setInAnimation(context, R.anim.news_bottom_in)
        mFlipperView.setOutAnimation(context, R.anim.news_bottom_out)

        addView(rootView)
    }


    private fun buildNewsView(text: String): View {
        val textView = TextView(context)
        textView.text = text
        textView.textSize = px2sp(dimen(R.dimen.text_small_size))
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)


        return textView
    }

    fun setData(data: Array<String>) {
        for (text in data) {
            mFlipperView.addView(buildNewsView(text))
        }
        mFlipperView.startFlipping()
    }
}
