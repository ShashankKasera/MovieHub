package com.codeinglogs.core.util
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class SliderAdapter(private val list: List<String>) : SliderAdapter() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
        viewHolder.bindImageSlide(list.get(position))
    }
}