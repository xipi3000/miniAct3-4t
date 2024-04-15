
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miniact3.model.MarsPhoto
import com.example.miniact3.network.ImageApi
import com.example.miniact3.network.ImageApiService
import com.example.miniact3.network.MarsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface ImageScreenUiState {
    data class Success(val photos: String) : ImageScreenUiState
    object Error : ImageScreenUiState
    object Loading : ImageScreenUiState
}

class ImageScreenViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var imageScreenUiState: ImageScreenUiState by mutableStateOf(ImageScreenUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getMarsPhotos() {
        viewModelScope.launch {
            imageScreenUiState = ImageScreenUiState.Loading
            imageScreenUiState = try {
                val listResult = ImageApi.retrofitService.getPhotos()
                ImageScreenUiState.Success(
                    listResult
                )
            } catch (e: IOException) {
                ImageScreenUiState.Error
            } catch (e: HttpException) {
                ImageScreenUiState.Error
            }
        }
    }
}