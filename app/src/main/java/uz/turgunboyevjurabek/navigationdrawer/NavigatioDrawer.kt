package uz.turgunboyevjurabek.navigationdrawer

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun DrawerHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(
            Brush.horizontalGradient(
                colors = listOf(
                    Color.Red, Color.LightGray
                )
            )
        )
        .padding(vertical = 60.dp),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Header", fontSize = 60.sp)
    }
    
}

@Composable
fun DrawerBody(
    items:List<MenuItem>,
    modifier: Modifier= Modifier
        .background(
            Brush.horizontalGradient(
                colors = listOf(
                    Color.Red, Color.LightGray
                )
            )
        )
        .fillMaxHeight(),
    onItemClick:(MenuItem)->Unit
) {
    LazyColumn(modifier){
        items(items){item->
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescriptor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title, modifier = Modifier.weight(1f))
            }
        }
    }
}