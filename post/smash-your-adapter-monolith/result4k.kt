interface GitHubApiAction<R> {
    fun toRequest(): Request
    fun fromResponse(response: Response): Result<R, Exception>
}

data class GetUser(val username: String) : GitHubApiAction<UserDetails> {
    override fun toRequest() = Request(GET, "/users/$username")
    override fun fromResponse(response: Response) = when {
        response.status.successful ->
            Success(UserDetails(userNameFrom(response), userOrgsFrom(response)))
        else -> Failure(RuntimeException("API returned: " + response.status))
    }
}
