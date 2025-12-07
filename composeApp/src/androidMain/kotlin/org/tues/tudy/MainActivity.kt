package org.tues.tudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import org.tues.tudy.ui.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // create nav controller
            val navController = rememberNavController()
            // host your nav graph
            Surface(color = MaterialTheme.colorScheme.background) {
                AppNavGraph(navController)
            }
        }
    }
}
