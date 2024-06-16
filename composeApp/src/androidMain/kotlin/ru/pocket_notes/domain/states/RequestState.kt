package ru.pocket_notes.domain.states

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable

sealed class RequestState<out T>{
    data object Idle: RequestState<Nothing>()
    data object Loading: RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()

    data class Error(val message: String): RequestState<Nothing>()

    fun isLoading() = this is Loading
    fun isSuccess() = this is Success

    fun isError() = this is kotlin.Error

    fun getSuccessData() = (this as Success).data

    fun getSuccessDataOrNull(): T?{
        return try{
            (this as Success).data
        }catch (error: Exception){
            null
        }
    }

    fun getErrorMessage() = (this as Error).message

    fun getErrorMessageOrEmpty(): String{
        return try{
            (this as Error).message
        }catch(error: Exception){
            ""
        }
    }

    @Composable
    fun displayResult(
        onIdle: (@Composable () -> Unit)? = null,
        onLoading: @Composable () -> Unit,
        onSuccess: @Composable (T) -> Unit,
        onError: @Composable (String) -> Unit,
        transitionSpec: AnimatedContentTransitionScope<*>.() -> ContentTransform = {
            fadeIn(tween(durationMillis = 300)) togetherWith fadeOut(tween(durationMillis=300))
        }
    ){
        AnimatedContent(
            targetState = this,
            transitionSpec = transitionSpec,
            label="Animated State"
        ){state ->
            when(state){
                is Idle ->{
                    onIdle?.invoke()
                }
                is Loading -> {
                    onLoading()
                }
                is Success -> {
                    onSuccess(state.getSuccessData())
                }
                is Error -> {
                    onError(state.getErrorMessage())
                }
            }
        }
    }
}
