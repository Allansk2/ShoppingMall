package com.kotlin.goods.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allan.base.library.ext.loadUrl
import com.allan.goodscenter.R


import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.allan.goodscenter.data.protocol.Goods
import com.kotlin.base.utils.YuanFenConverter
import kotlinx.android.synthetic.main.layout_goods_item.view.*


class GoodsAdapter(context: Context) : BaseRecyclerViewAdapter<Goods, GoodsAdapter.ViewHolder>(context) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(mContext)
            .inflate(
                R.layout.layout_goods_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model = dataList[position]

        holder.itemView.mGoodsIconIv.loadUrl(model.goodsDefaultIcon)

        holder.itemView.mGoodsDescTv.text = model.goodsDesc

        holder.itemView.mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(model.goodsDefaultPrice)

        holder.itemView.mGoodsSalesStockTv.text = "销量${model.goodsSalesCount}件     库存${model.goodsStockCount}"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
