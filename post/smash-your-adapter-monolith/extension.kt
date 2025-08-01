fun GitHubApi.getUser(username: String) = invoke(GetUser(username))
fun GitHubApi.getRepoLatestCommit(GetRepoLatestCommit: String, repo: String): Commit =
    invoke(GetRepoLatestCommit(owner, repo))

val user: UserDetails = gitHub.getUser("octocat")
