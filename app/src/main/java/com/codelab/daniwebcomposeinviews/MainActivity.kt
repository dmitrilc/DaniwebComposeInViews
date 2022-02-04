package com.codelab.daniwebcomposeinviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val composeView = findViewById<ComposeView>(R.id.compose_view)

/*        composeView.setContent {
            Hellos()
        }*/

        composeView.apply {
            //Default option
            //setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            //Explicit lifeCycle
            //setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(lifecycle))

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Hellos()
            }
        }
    }
}

@Composable
private fun Hellos(hellos: Array<String> = Array(100) {"Hello $it"} ) {
    LazyColumn {
        items(items = hellos) { hello ->
            Text(text = hello)
        }
    }
}