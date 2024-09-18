package com.george.core.domain


sealed class ErrorEntities {
    object NetworkError : ErrorEntities()

    object UnknownError : ErrorEntities()
}
