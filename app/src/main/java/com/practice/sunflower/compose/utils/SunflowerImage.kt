package com.practice.sunflower.compose.utils

import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.RequestBuilderTransform
import com.bumptech.glide.integration.compose.placeholder

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SunflowerImage(
    model : Any?,
    contentDescription : String,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha : Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    requestBuilderTransform: RequestBuilderTransform<Drawable> ={it}
){
    if(LocalInspectionMode.current){
        Box(modifier = modifier.background(Color.Magenta))
        return
    }

    GlideImage(model = model, contentDescription = contentDescription, modifier = modifier, alignment = alignment, contentScale = contentScale, alpha = alpha, colorFilter = colorFilter, requestBuilderTransform =  requestBuilderTransform,
        loading = placeholder{
            Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                CircularProgressIndicator(Modifier.size(40.dp))
            }
        }
    )
}