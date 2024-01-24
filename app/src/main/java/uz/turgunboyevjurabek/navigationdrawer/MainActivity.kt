package uz.turgunboyevjurabek.navigationdrawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.navigationdrawer.ui.theme.NavigationDrawerTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val rememberDrawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
                val rememberCoroutinesState=rememberCoroutineScope()
                Scaffold(
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            rememberCoroutinesState.launch {
                                if (rememberDrawerState.isClosed) rememberDrawerState.open() else rememberDrawerState.close()
                            }
                        })
                    }

                ) {
                NavigationDrawer(rememberDrawerState)
                }

            }
        }
    }
    @Composable
    private fun NavigationDrawer(rememberDrawerState: DrawerState) {
        val contex= LocalContext.current
        ModalNavigationDrawer(
            drawerState =rememberDrawerState,
            drawerContent = {
                ModalDrawerSheet {
                    DrawerHeader()
                    DrawerBody(items = listOf(
                        MenuItem(
                        id = "Home",
                            title = "Home",
                            contentDescriptor = "Home",
                            icon = Icons.Default.Home
                    ),  MenuItem(
                        id = "Settings",
                            title = "Settings",
                            contentDescriptor = "Settings",
                            icon = Icons.Default.Settings
                    ),  MenuItem(
                        id = "Help",
                            title = "Help",
                            contentDescriptor = "Help",
                            icon = Icons.Default.Info
                    ),  MenuItem(
                        id = "Stars",
                            title = "Stars",
                            contentDescriptor = "Stars",
                            icon = Icons.Default.Star
                    ),
                    ),
                        onItemClick ={it->
                            when(it.id){
                                "Stars"->{
                                    Toast.makeText(contex, "Stars clicked", Toast.LENGTH_SHORT).show()
                                }
                                "Settings"->{
                                    Toast.makeText(contex, "Settings clicked", Toast.LENGTH_SHORT).show()
                                }
                                "Help"->{
                                    Toast.makeText(contex, "Help clicked", Toast.LENGTH_SHORT).show()
                                }
                                "Home"->{
                                    Toast.makeText(contex, "Home clicked", Toast.LENGTH_SHORT).show()
                                }

                            }
                        }

                    )
                }
            },
            content = {

            }
        )
    }
}


