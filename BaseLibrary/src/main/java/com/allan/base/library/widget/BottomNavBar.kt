package com.allan.base.library.widget

import android.content.Context
import android.util.AttributeSet
import com.allan.base.library.R
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem


class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    private val mCartBadge: TextBadgeItem
    private val mMsgBadge: ShapeBadgeItem

    init {
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, R.string.nav_bar_home)
            .setActiveColorResource(R.color.common_blue)
            .setInactiveIconResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_home_normal)

        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, R.string.nav_bar_category)
            .setActiveColorResource(R.color.common_blue)
            .setInactiveIconResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_category_normal)

        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, R.string.nav_bar_cart)
            .setActiveColorResource(R.color.common_blue)
            .setInactiveIconResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_cart_normal)

        mCartBadge = TextBadgeItem()

        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, R.string.nav_bar_msg)
            .setActiveColorResource(R.color.common_blue)
            .setInactiveIconResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)

        mMsgBadge = ShapeBadgeItem()

        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, R.string.nav_bar_user)
            .setActiveColorResource(R.color.common_blue)
            .setInactiveIconResource(R.color.text_normal)
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)

        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)

        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(msgItem)
            .addItem(userItem)
            .setFirstSelectedPosition(0)
            .initialise()


    }

    fun checkCartBadge(count: Int) {
        if (count == 0) {
            mCartBadge.hide()
        } else {
            mCartBadge.show()
            mCartBadge.setText("$count")
        }
    }

    fun checkMsgBadge(isVisible: Boolean) {
        if (isVisible) {
            mMsgBadge.show()
        } else {
            mMsgBadge.hide()
        }
    }
}