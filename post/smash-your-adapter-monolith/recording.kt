class RecordingGitHubApi(private val delegate: GitHubApi) : GitHubApi {
    val recorded = mutableListOf<GitHubApiAction<*>>()
    override fun <R : Any> invoke(action: GitHubApiAction<R>): R {
        recorded += action
        return delegate(action)
    }
}

val recorder = RecordingGitHubApi(GitHubApi.Http(JavaHttpClient()))
recorder.getUser("bob")

println(recorder.recorded)
