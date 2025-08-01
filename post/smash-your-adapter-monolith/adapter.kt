interface GitHubApi {
    operator fun <R : Any> invoke(action: GitHubApiAction<R>): R

    companion object
}
