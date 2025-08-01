interface GitHubApiAction<R> {
    fun toRequest(): Request
    fun fromResponse(response: Response): R
}

data class GetUser(val username: String) : GitHubApiAction<UserDetails> {
    override fun toRequest() = Request(GET, "/users/$username")
    override fun fromResponse(response: Response) =
        UserDetails(userNameFrom(response), userOrgsFrom(response))
}

data class UserDetails(val name: String, val orgs: List<String>)
