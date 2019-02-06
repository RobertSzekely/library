package com.example.booklibrary.feature.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booklibrary.data.models.Book
import com.example.booklibrary.data.storage.BookRepository

class BookFeedViewModel(private val repository: BookRepository) : ViewModel() {

    val booksList = MutableLiveData<List<Book>>()

    fun loadBooks() {
        repository.getBooks(object : BookRepository.ApiCallback {
            override fun onSuccess(books: List<Book>) {
                booksList.postValue(books)
            }

            override fun onFailure(errorMessage: String) {
                Log.d("BookFeedViewModel", "Loading books failed!")
            }

        })
    }
}
