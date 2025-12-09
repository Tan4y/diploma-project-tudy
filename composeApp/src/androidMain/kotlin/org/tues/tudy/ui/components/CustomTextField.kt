// ui/components/CustomTextField.kt
import Dimens.BorderRadius200
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    error: String? = null,
    forgotPassword: Boolean = false,
    onForgotPassword: () -> Unit = {"forgotPassword"},
    trailingIcon: (@Composable (() -> Unit))? = null
) {
    val isFocused = remember { mutableStateOf(false) }

    val stateColor = when {
        error != null -> ErrorColor
        isFocused.value -> PrimaryColor1
        value.isNotEmpty() -> BaseColor100
        else -> BaseColor80
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = AppTypography.Caption1,
            color = if (stateColor == BaseColor80) androidx.compose.ui.graphics.Color.Transparent else stateColor,
            modifier = Modifier
                .padding(Dimens.Space25)
                .animateContentSize()
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = stateColor,
                    shape = RoundedCornerShape(BorderRadius200)
                )
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = AppTypography.Paragraph1.copy(color = stateColor),
                placeholder = {
                    Text(
                        text = label,
                        style = AppTypography.Caption1.copy(color = BaseColor80)
                    )
                },
                trailingIcon = trailingIcon,
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { isFocused.value = it.isFocused },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                    focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                    disabledIndicatorColor = MaterialTheme.colorScheme.surface,
                ),
            )
        }

        Spacer(modifier = Modifier.height(Dimens.Space25))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.Space75, end = Dimens.Space25),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (error != null) {
                Text(
                    text = error,
                    color = ErrorColor,
                    style = AppTypography.Caption2
                )
            } else {
                Spacer(modifier = Modifier.height(Dimens.Space100))
            }

            if (forgotPassword) {
                Text(
                    text = "Forgot Password",
                    color = PrimaryColor1,
                    style = AppTypography.UnderlinedCaption1,
                    modifier = Modifier.clickable { onForgotPassword() }
                )
            }
        }

    }
}

