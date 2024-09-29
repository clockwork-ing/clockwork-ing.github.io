@Test
fun `get user details`() {
    val githubApi = mockk<GitHubApi>()
    val userDetails = UserDetails("bob", listOf("http4k"))
    every { githubApi(any<GetUser>()) } returns userDetails

    assertThat(githubApi.getUser("bob"), equalTo(userDetails))
}
