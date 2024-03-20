package io.kerno.challenge.exception

/**
 * This class is used to represent exceptions that occur during the execution of the business logic.
 *
 * @author Samuel Catalano
 * @since 1.0
 */
class ServiceException : Exception {
  /**
   * Creates a new instance of the ServiceException class.
   */
  constructor() : super()

  /**
   * Creates a new instance of the ServiceException class with the specified message.
   * @param message The message that describes the error.
   */
  constructor(message: String?) : super(message)

  /**
   * Creates a new instance of the ServiceException class with the specified message and cause.
   * @param message The message that describes the error.
   * @param cause   The cause of the error.
   */
  constructor(message: String?, cause: Throwable?) : super(message, cause)

  /**
   * Creates a new instance of the ServiceException class with the specified cause.
   * @param cause The cause of the error.
   */
  constructor(cause: Throwable?) : super(cause)
}
