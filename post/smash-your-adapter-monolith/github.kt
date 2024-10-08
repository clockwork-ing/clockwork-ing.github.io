class GitHubApi(client: HttpHandler) {
    private val http = SetBaseUriFrom(Uri.of("https://api.github.com"))
        .then(SetHeader("Accept", "application/vnd.github.v3+json"))
        .then(client)

    fun getUser(username: String): UserDetails {
        val response = http(Request(GET, "/users/$username"))
        return UserDetails(userNameFrom(response), userOrgsFrom(response))
    }

    fun getRepoLatestCommit(owner: String, repo: String) = Commit(
        authorFrom(http(Request(GET, "/repos/$owner/$repo/commits").query("per_page", "1")))
    )
}

val gitHub: GitHubApi = GitHubApi(OkHttp())
val user: UserDetails = gitHub.getUser("octocat")
