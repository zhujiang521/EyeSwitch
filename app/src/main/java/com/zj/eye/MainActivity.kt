package com.zj.eye

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zj.eye.ui.theme.EyeSwitchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EyeSwitchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestEyeHealthProviderScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EyeSwitchTheme {
        TestEyeHealthProviderScreen()
    }
}


@Composable
fun TestEyeHealthProviderScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val contentResolver = context.contentResolver
    var result by remember { mutableStateOf("") }
    var getData by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Test EyeHealthProvider",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Set Buttons
        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_EYE_HEALTH_MODE,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Eye Health Mode (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_EYE_HEALTH_MODE,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Eye Health Mode (false)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_LIGHT_REMIND,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Light Remind (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_LIGHT_REMIND,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Light Remind (false)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_DISTANCE_REMIND,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Distance Remind (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_DISTANCE_REMIND,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Distance Remind (false)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_DISTANCE_VALUE,
                    50
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Distance Value (50)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_SITTING_REMIND,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Sitting Remind (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_SITTING_REMIND,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Sitting Remind (false)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_SITTING_STRICTNESS,
                    2
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Sitting Strictness (2)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_ATTENTION_REMIND,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Attention Remind (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_ATTENTION_REMIND,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Attention Remind (false)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_ATTENTION_STRICTNESS,
                    1
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Attention Strictness (1)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_VOICE_REMIND,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Voice Remind (true)")
        }

        Button(
            onClick = {
                result = callProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_SET_VOICE_REMIND,
                    false
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Set Voice Remind (false)")
        }

        // Get Buttons
        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_EYE_HEALTH_MODE
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Eye Health Mode")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_LIGHT_REMIND
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Light Remind")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_DISTANCE_REMIND
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Distance Remind")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_DISTANCE_VALUE,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Distance Value")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_SITTING_REMIND
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Sitting Remind")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_SITTING_STRICTNESS,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Sitting Strictness")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_ATTENTION_REMIND
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Attention Remind")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_ATTENTION_STRICTNESS,
                    true
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Attention Strictness")
        }

        Button(
            onClick = {
                getData = getProviderMethod(
                    contentResolver,
                    EyeHealthConstants.METHOD_GET_VOICE_REMIND
                )
            },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("Get Voice Remind")
        }

        // Display Results
        Text(
            text = "Set Result: $result",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Get Result: $getData",
            fontSize = 16.sp
        )
    }
}


fun callProviderMethod(contentResolver: ContentResolver, method: String, value: Boolean): String {
    val extras = Bundle().apply {
        putBoolean(EyeHealthConstants.KEY_ENABLED, value)
    }
    val result = contentResolver.call(
        Uri.parse("content://com.zui.engine.provider.eyehealth"),
        method,
        null,
        extras
    )
    val status = result?.getString(EyeHealthConstants.STATUS) ?: "Unknown"
    val message =
        result?.getString(EyeHealthConstants.MESSAGE) ?: "No message"
    Log.d("TestEyeHealthProvider", "Result: $status - $message")
    return "$status - $message"
}

fun callProviderMethod(contentResolver: ContentResolver, method: String, value: Int): String {
    val extras = Bundle().apply {
        putInt(EyeHealthConstants.KEY_VALUE, value)
    }
    val result = contentResolver.call(
        Uri.parse("content://com.zui.engine.provider.eyehealth"),
        method,
        null,
        extras
    )
    val status = result?.getString(EyeHealthConstants.STATUS) ?: "Unknown"
    val message =
        result?.getString(EyeHealthConstants.MESSAGE) ?: "No message"
    Log.d("TestEyeHealthProvider", "Result: $status - $message")
    return "$status - $message"
}

fun getProviderMethod(
    contentResolver: ContentResolver,
    method: String,
    isInt: Boolean = false
): String {
    val result = contentResolver.call(
        Uri.parse("content://com.zui.engine.provider.eyehealth"),
        method,
        null,
        null
    )
    val status = result?.getString(EyeHealthConstants.STATUS) ?: "Unknown"
    val message =
        result?.getString(EyeHealthConstants.MESSAGE) ?: "No message"
    val value = if (isInt) {
        result?.getInt(EyeHealthConstants.VALUE) ?: -1
    } else {
        result?.getBoolean(EyeHealthConstants.VALUE) ?: "No value"
    }
    Log.d("TestEyeHealthProvider", "Result: $status - $message")
    return "$status - $message - $value"
}

