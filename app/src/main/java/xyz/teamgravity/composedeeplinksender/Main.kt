package xyz.teamgravity.composedeeplinksender

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.teamgravity.composedeeplinksender.ui.theme.ComposeDeepLinkSenderTheme

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDeepLinkSenderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://raheem.com/666"))
                                val pendingIntent = TaskStackBuilder.create(applicationContext).run {
                                    addNextIntentWithParentStack(intent)
                                    getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
                                }
                                pendingIntent.send()
                            }
                        ) {
                            Text(text = stringResource(id = R.string.trigger_deeplink))
                        }
                    }
                }
            }
        }
    }
}