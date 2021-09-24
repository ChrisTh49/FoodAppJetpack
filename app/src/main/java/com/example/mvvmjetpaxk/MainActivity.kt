package com.example.mvvmjetpaxk

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpaxk.ui.theme.MVVMJetpaxkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    MVVMJetpaxkTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxHeight()) {
            content()
        }
    }
}


@Preview(showBackground = true, name = "MyScreen preview")
@Composable
fun DefaultPreview() {
    MainTheme {
        HomeScreen()
    }
}


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header",
            contentScale = ContentScale.FillWidth
        )

        Column() {
            AppBar()
            Content()
        }
    }
}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search food, vegetable, etc.", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search Icon"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Content() {
    Column() {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        Categorization()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
    }
}

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QrButton()

            VerticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = "",
                    tint = Color(0xFF6FCF97)
                )

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "$10", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Points", color = Color.LightGray, fontSize = 12.sp)
                }
            }

            VerticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = "",
                    tint = Color(0xFF6FCF97)
                )

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "$120", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Top Up", color = MaterialTheme.colors.primary, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun QrButton() {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun Promotions() {
    LazyRow(
        modifier = Modifier.height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.promotion),
                title = "Fruit",
                subTitle = "Start @",
                header = "1$",
                backgroundColor = MaterialTheme.colors.primary
            )
        }

        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.ic_meat),
                title = "Meet",
                subTitle = "Discount",
                header = "20%",
                backgroundColor = Color(0xff276FBF)
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subTitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp,

        ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(
                    text = subTitle,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = header,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Categorization() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Category", style = MaterialTheme.typography.h6)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CategoryButton(
                text = "Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xffFEF4E7)
            )

            CategoryButton(
                text = "Vegetables",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xffF6FBF3)
            )

            CategoryButton(
                text = "Dairy",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xffFFFBF3)
            )

            CategoryButton(
                text = "Meats",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xffF6E6E9)
            )
        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxWidth())
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun BestSellerSection() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Best Sellers", style = MaterialTheme.typography.h6)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_lettuce),
                title = "Iceberg Lettuce",
                price = "1.99",
                discountPercent = 10
            )
        }

        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_apple),
                title = "Apple",
                price = "2.64",
                discountPercent = 5
            )
        }

        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_meat),
                title = "Meat",
                price = "5",
                discountPercent = 25
            )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String = "",
    price: String,
    discountPercent: Int = 0,
    imagePainter: Painter,
) {
    Card(
        modifier = Modifier
            .width(160.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Row {
                    Text(
                        text = "$${price}",
                        textDecoration = if (discountPercent > 0)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None,
                        color = if (discountPercent > 0) Color.Black else Color.Gray
                    )

                    if (discountPercent > 0) {
                        Text(text = "[$discountPercent%]", color = MaterialTheme.colors.primary)

                    }
                }
            }
        }
    }
}