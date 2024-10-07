package com.example.shapar_32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val description: String
) {
    fun getBookInfo(): String {
        return "Назва: $title\nАвтор: $author\nРік видання: $year\nОпис: $description"
    }
}

class MainActivity : AppCompatActivity() {

    private val books: Map<String, Book> = mapOf(
        "1984" to Book(
            title = "1984",
            author = "Джордж Орвелл",
            year = 1949,
            description = "Дистопічний роман про тоталітаризм."
        ),
        "Brave New World" to Book(
            title = "Brave New World",
            author = "Олдос Хакслі",
            year = 1932,
            description = "Роман про майбутній світ."
        ),
        "To Kill a Mockingbird" to Book(
            title = "To Kill a Mockingbird",
            author = "Харпер Лі",
            year = 1960,
            description = "Роман про расову несправедливість."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val searchButton: Button = findViewById(R.id.searchButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        searchButton.setOnClickListener {
            val query: String = searchEditText.text.toString().trim()
            if (query.isEmpty()) {
                resultTextView.text = "Будь ласка, введіть назву книги."
                return@setOnClickListener
            }

            val book: Book? = books[query]
            if (book != null) {
                resultTextView.text = book.getBookInfo()
            } else {
                resultTextView.text = "Книга не знайдена."
            }
        }
    }
}
