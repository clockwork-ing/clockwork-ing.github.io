val gitHub: GitHubApi = GitHubApi.Http(OkHttp())

val user: UserDetails = gitHub(GetUser("octocat"))
