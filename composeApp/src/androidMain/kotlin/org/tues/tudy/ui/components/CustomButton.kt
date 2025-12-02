package org.tues.tudy.ui.components

import BaseColor0
import BaseColor80
import Dimens.BorderRadius200
import PrimaryColor1
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton (
    value: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    val backgroundColor = if (enabled) PrimaryColor1 else BaseColor80

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = backgroundColor,
                shape = RoundedCornerShape(BorderRadius200)
            )
            .background(backgroundColor, RoundedCornerShape(BorderRadius200))
            .clickable(enabled = enabled) { onClick() }
            .padding(vertical = Dimens.Space50),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            style = AppTypography.Heading4.copy(color = BaseColor0)
        )
    }
}