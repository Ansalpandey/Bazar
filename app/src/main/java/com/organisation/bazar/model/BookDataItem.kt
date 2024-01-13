package com.organisation.bazar.model

data class BookDataItem(
  val authors: List<String>,
  val categories: List<String>,
  val isbn: String, // 1933988673
  val longDescription: String,
  val pageCount: Int, // 416
  val shortDescription: String,
  val status: String,
  val thumbnailUrl: String,
  val title: String
)
