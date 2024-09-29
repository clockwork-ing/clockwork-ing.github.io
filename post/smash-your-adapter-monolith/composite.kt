fun GitHubApi.getLatestUser(owner: String, repo: String): UserDetails {
    val commit = getRepoLatestCommit(owner, repo)
    return getUser(commit.author)
}

val latestUser: UserDetails = gitHub.getLatestUser("http4k", "http4k-connect")
