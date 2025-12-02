package org.tues.tudy.ui.components

import BaseColor0
import Dimens.BorderRadius200
import PrimaryColor1
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LinkButton (
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .clickable() { onClick() }
            .padding(Dimens.Space25),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            style = AppTypography.Heading6.copy(color = PrimaryColor1)
        )
    }
}