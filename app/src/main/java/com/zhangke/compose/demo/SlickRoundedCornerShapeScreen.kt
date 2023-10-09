package com.zhangke.compose.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.zhangke.compose.ext.ui.SlickRoundedCornerShape
import com.zhangke.compose.ui.composable.Toolbar

class SlickRoundedCornerShapeScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        SlickRoundCornerShapeScreenContent(
            onBackClick = navigator::pop,
        )
    }

    @Composable
    private fun SlickRoundCornerShapeScreenContent(
        onBackClick: () -> Unit,
    ) {
        Scaffold(
            topBar = {
                Toolbar(
                    title = "SlickRoundCornerShape",
                    onBackClick = onBackClick,
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val radius = 20.dp
                val normalContainerHeight = radius * 2
                val highContainerHeight = radius * 3
                Text(text = "RoundCornerShape")
                RoundedCornerShapeDemo(
                    containerHeight = normalContainerHeight,
                    radius = radius,
                    contentWidth = 15.dp,
                )
                RoundedCornerShapeDemo(
                    containerHeight = highContainerHeight,
                    radius = radius,
                    contentWidth = 15.dp,
                )
                RoundedCornerShapeDemo(
                    containerHeight = highContainerHeight,
                    radius = radius,
                    contentWidth = 100.dp,
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .width(1.dp)
                )
                Text(text = "SlickRoundCornerShape")
                SlickRoundedCornerShapeDemo(
                    containerHeight = normalContainerHeight,
                    radius = radius,
                    contentWidth = 5.dp,
                )
                SlickRoundedCornerShapeDemo(
                    containerHeight = normalContainerHeight,
                    radius = radius,
                    contentWidth = 10.dp,
                )
                SlickRoundedCornerShapeDemo(
                    containerHeight = highContainerHeight,
                    radius = radius,
                    contentWidth = 15.dp,
                )
                SlickRoundedCornerShapeDemo(
                    containerHeight = highContainerHeight,
                    radius = radius,
                    contentWidth = 100.dp,
                )
            }
        }
    }

    @Composable
    private fun RoundedCornerShapeDemo(
        containerHeight: Dp,
        radius: Dp,
        contentWidth: Dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(containerHeight)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(radius)
                ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(contentWidth)
                    .background(
                        color = Color.Blue.copy(alpha = 0.3F),
                        shape = RoundedCornerShape(radius),
                    )
            )
        }
    }

    @Composable
    private fun SlickRoundedCornerShapeDemo(
        containerHeight: Dp,
        radius: Dp,
        contentWidth: Dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(containerHeight)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(radius)
                ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(contentWidth)
                    .clipToBounds()
                    .background(
                        color = Color.Blue.copy(alpha = 0.3F),
                        shape = SlickRoundedCornerShape(radius),
                    )
            )
        }
    }
}
