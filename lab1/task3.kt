sealed class Result<out T>

data class Success<out T>(val data: T) : Result<T>()

data class Error(val message: String) : Result<Nothing>()

fun <T> processResult(result: Result<T>) {
    when (result) {
        is Success -> {
            val data = result.data
            println("Operation successful. Data: $data")
        }
        is Error -> {
            val errorMessage = result.message
            println("Operation failed. Error: $errorMessage")
        }
    }
}

fun main() {
    // Создание экземпляра Result.Success
    val successResult: Result<String> = Success("Data from successful operation")
    // Обработка результата с использованием pattern matching
    processResult(successResult)

    // Создание экземпляра Result.Error
    val errorResult: Result<Int> = Error("Error message")
    // Обработка результата с использованием pattern matching
    processResult(errorResult)
}
