package com.organisation.bazar.data


import com.organisation.bazar.model.BookDataItem
import retrofit2.http.GET

interface ApiInterface {
  @GET("books.json") suspend fun getBooks(): List<BookDataItem>
}
