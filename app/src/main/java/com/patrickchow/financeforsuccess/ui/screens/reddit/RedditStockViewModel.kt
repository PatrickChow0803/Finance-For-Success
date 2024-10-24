package com.patrickchow.financeforsuccess.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patrickchow.financeforsuccess.data.repository.RedditStockRepository
import com.patrickchow.financeforsuccess.dataclass.RedditStock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RedditStockViewModel @Inject constructor(
    private val repository: RedditStockRepository
) : ViewModel() {

    private val _redditStocks = MutableStateFlow<List<RedditStock>>(emptyList())
    val redditStocks: StateFlow<List<RedditStock>> = _redditStocks

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun getStocks(date: String? = null) {
        viewModelScope.launch {
            _loading.value = true
            try {
                _redditStocks.value = repository.getRedditStocks(date)
            } catch (e: Exception) {
                _redditStocks.value = emptyList()
            } finally {
                _loading.value = false
            }
        }
    }
}
