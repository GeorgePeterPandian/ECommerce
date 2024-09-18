package com.george.core.domain

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<out O> {
    abstract fun execute(): Flow<O>
}