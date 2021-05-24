package com.dapoidev.catmov.core.source

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : com.dapoidev.catmov.core.source.Resource<T>(data)
    class Loading<T>(data: T? = null) : com.dapoidev.catmov.core.source.Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : com.dapoidev.catmov.core.source.Resource<T>(data, message)
}