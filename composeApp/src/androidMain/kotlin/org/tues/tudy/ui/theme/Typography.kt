// ui/theme/Typography.kt
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypography {

    val H1 = TextStyle(
        fontSize = 40.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Bold
    )

    val H2 = TextStyle(
        fontSize = 36.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold
    )

    val H3 = TextStyle(
        fontSize = 36.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold
    )

    val Body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp
    )

    val BodySmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp
    )
}
