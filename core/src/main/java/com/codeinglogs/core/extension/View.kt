package com.codeinglogs.core.extension

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.AdapterView
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

private const val DURATION = 300

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}


fun AppCompatImageView.load(resId: String, centerCrop: Boolean = true, fit: Boolean = true) {
    Picasso.get()
        .load(resId)
        .also { if (centerCrop) it.centerCrop() }
        .also { if (fit) it.fit() }
        .into(this)
}
fun View.getImageDrawable(@DrawableRes id: Int): Drawable? = context.getImageDrawable(id)

fun View.getResolvedColor(@ColorRes id: Int): Int = ContextCompat.getColor(context, id)

fun AppCompatEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun AppCompatSpinner.selected(action: (Int) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            action(position)
        }
    }
}

fun View.animateVisibility(setVisible: Boolean) {
    if (setVisible) expand() else collapse()
}

fun View.expand() {
    this.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val initialHeight = 0
    val targetHeight = this.measuredHeight
    // Older versions of Android (pre API 21) cancel animations for thiss with a height of 0.
    //v.getLayoutParams().height = 1;
    this.layoutParams.height = 0
    this.visible()
    animateView(initialHeight, targetHeight)
}

fun View.collapse() {
    val initialHeight = this.measuredHeight
    val targetHeight = 0
    animateView(initialHeight, targetHeight)
}

fun View.animateView(initialHeight: Int, targetHeight: Int) {
    val valueAnimator = ValueAnimator.ofInt(initialHeight, targetHeight)
    valueAnimator.addUpdateListener { animation ->
        this.layoutParams.height = animation.animatedValue as Int
        this.requestLayout()
    }
    valueAnimator.addListener(object : Animator.AnimatorListener {
        override fun onAnimationEnd(animation: Animator) {
           layoutParams.height = targetHeight
        }
        override fun onAnimationStart(animation: Animator) {}
        override fun onAnimationCancel(animation: Animator) {}
        override fun onAnimationRepeat(animation: Animator) {}
    })
    valueAnimator.duration = DURATION.toLong()
    valueAnimator.interpolator = DecelerateInterpolator()
    valueAnimator.start()

}









