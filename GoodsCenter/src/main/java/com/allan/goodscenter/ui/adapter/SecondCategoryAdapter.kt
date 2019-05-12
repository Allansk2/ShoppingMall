package com.allan.goodscenter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allan.base.library.ext.loadUrl
import com.allan.goodscenter.R
import com.allan.goodscenter.data.protocol.Category
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.layout_second_category_item.view.*


class SecondCategoryAdapter(context: Context) :
    BaseRecyclerViewAdapter<Category, SecondCategoryAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.layout_second_category_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]

        holder.itemView.mCategoryIconIv.loadUrl(model.categoryIcon)

        holder.itemView.mSecondCategoryNameTv.text = model.categoryName

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
