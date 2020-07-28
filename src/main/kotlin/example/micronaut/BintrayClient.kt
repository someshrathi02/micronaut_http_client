package example.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client(BintrayConfiguration.BINTRAY_URL) // <1>
interface BintrayClient {

    @Get("/api/\${bintray.apiversion}/repos/\${bintray.organization}/\${bintray.repository}/packages")  // <2>
    fun fetchPackages(): Single<HttpResponse<List<BintrayPackage>>>  // <3>
}