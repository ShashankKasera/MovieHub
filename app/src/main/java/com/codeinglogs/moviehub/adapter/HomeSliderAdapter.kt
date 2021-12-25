package com.codeinglogs.moviehub.adapter
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class HomeSliderAdapter(private val list: List<String>) : SliderAdapter() {

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
        viewHolder.bindImageSlide(list.get(position))
    }
}