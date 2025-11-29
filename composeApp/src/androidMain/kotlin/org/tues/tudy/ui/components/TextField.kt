// ui/components/TextField.kt
import AppTypography.Caption1
import Dimens.BorderRadius200
import android.R.attr.theme
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TextField(
    value: MutableState<String>,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = BaseColor80,
                shape = RoundedCornerShape(BorderRadius200)
            )
    ) {
        TextField(
            value = value.value,
            onValueChange = { value.value = it },
            label = { Text(label, style = AppTypography.Caption1) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(BorderRadius200),
            textStyle = AppTypography.Paragraph1
        )
    }
}
