package com.patrickchow.financeforsuccess.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patrickchow.financeforsuccess.data.api.StockData
import com.patrickchow.financeforsuccess.data.repository.RedditRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RedditViewModel : ViewModel() {

    private val repository = RedditRepository()

    private val _stockList = MutableStateFlow<List<StockData>>(emptyList())
    val stockList: StateFlow<List<StockData>> get() = _stockList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun fetchTopStocks(date: String? = null) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val result = repository.getTopStocks(date)
                _stockList.value = result
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching stocks"
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
