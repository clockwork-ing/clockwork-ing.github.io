fun MySecureApp(): HttpHandler =
    BearerAuth("my-very-secure-and-secret-bearer-token")
        .then(
            routes(
                echo(),
                health()
            )
        )

fun echo() = "/echo" bind POST to { req: Request -> Response(OK).body(req.bodyString()) }

fun health() = "/health" bind GET to { req: Request -> Response(OK).body("alive!") }

val server = MySecureApp().asServer(Netty(8080)).start()
