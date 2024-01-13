package com.organisation.bazar.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.organisation.bazar.model.BookDataItem
import com.organisation.bazar.ui.theme.MainColor
import com.organisation.bazar.ui.theme.RobotoFamily
import com.organisation.bazar.utils.RetrofitInstance
import com.organisation.bazar.viewmodel.BookViewModel
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

@Composable
fun BookList(price: String) {
  val viewModel: BookViewModel = viewModel()

  LaunchedEffect(key1 = true) {
    try {
      val books = withContext(Dispatchers.IO) { RetrofitInstance.instance.getBooks() }
      viewModel.setPosts(books)
    } catch (e: HttpException) {
      // Handle HTTP exception
    } catch (e: IOException) {
      // Handle IO exception
    }
  }

  // Display only 5 books in a LazyRow
  LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
    items(viewModel.posts.take(10)) { book -> BookCard(book, price) }
  }
}

@Composable
fun BookCard(book: BookDataItem, price: String) {
  // Customize the appearance of each book item
  Card(
    modifier = Modifier.width(170.dp).height(300.dp).padding(end = 10.dp),
    colors = CardDefaults.cardColors(Color.White)
  ) {
    Column {
      AsyncImage(
        model = book.thumbnailUrl,
        contentDescription = "book Image",
        modifier =
          Modifier.height(200.dp)
            .width(500.dp)
            .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)),
      )

      Text(
        text = book.title,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        fontFamily = RobotoFamily,
        color = Color.Black,
        maxLines = 1,
        modifier = Modifier.padding(top = 10.dp),
      )
      Text(
        text = price,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        fontFamily = RobotoFamily,
        color = MainColor,
      )
    }
  }
}
