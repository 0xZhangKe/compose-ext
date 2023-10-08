package com.zhangke.compose.ui.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val navigationIcon: (@Composable (() -> Unit)) = if (onBackClick != null) {
        @Composable
        {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Filled.ArrowBack),
                    "back"
                )
            }
        }
    } else {
        {}
    }
    TopAppBar(
        navigationIcon = navigationIcon,
        actions = actions,
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
            )
        },
    )
}
