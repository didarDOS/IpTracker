package com.dos.iptracker.utils

import java.io.IOException

object NetworkExceptions {

    class BadRequest(description: String = "Something went wrong") : RuntimeException(description)

    class EmptyBody(description: String = "Server returned an empty body") :
        RuntimeException(description)

    class ConnectivityError(description: String = "No internet connection") :
        IOException(description)

    class SessionOverException(description: String = "Access denied") :
        RuntimeException(description)

    class ErrorMessage(description: String = "Something went wrong") : IOException(description)

    class ServiceException(description: String? = "Service exception") :
        RuntimeException(description)
}