
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miniact3.network.TextApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface TextScreenUiState {
    data class Success(val photos: String) : TextScreenUiState
    object Error : TextScreenUiState
    object Loading : TextScreenUiState
}

class TextScreenViewModel : ViewModel() {

    var textScreenUiState: TextScreenUiState by mutableStateOf(TextScreenUiState.Loading)
        private set

    init {
        getHtmlText()
    }


    fun getHtmlText() {
        viewModelScope.launch {
            textScreenUiState = TextScreenUiState.Loading
            textScreenUiState = try {
                val listResult = TextApi.retrofitService.getText()
                TextScreenUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                TextScreenUiState.Error
            } catch (e: HttpException) {
                TextScreenUiState.Error
            }
        }
    }
}