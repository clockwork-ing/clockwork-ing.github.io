fun GitHubApi.Companion.Http(client: HttpHandler) = object : GitHubApi {
    private val http = SetBaseUriFrom(Uri.of("https://api.github.com"))
        .then(SetHeader("Accept", "application/vnd.github.v3+json"))
        .then(client)

    override fun <R : Any> invoke(action: GitHubApiAction<R>) =
        action.fromResponse(http(action.toRequest()))
}
