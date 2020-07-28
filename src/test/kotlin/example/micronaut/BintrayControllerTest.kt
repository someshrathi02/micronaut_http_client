/*
package example.micronaut

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.reactivex.Flowable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.stream.StreamSupport
import javax.inject.Inject

@MicronautTest
class BintrayControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client : RxStreamingHttpClient // <2>

    @Test
    fun verifyBintrayPackagesCanBeFetchedWithLowLevelHttpClient() {
        //when:
        val request: HttpRequest<Any> = HttpRequest.GET<Any>("/bintray/packages-lowlevel")
        val rsp: HttpResponse<List<BintrayPackage>> = client.toBlocking().exchange<Any, List<BintrayPackage>>(request,  // <3>
                Argument.listOf(BintrayPackage::class.java)) // <4>

        //then: 'the endpoint can be accessed'
        Assertions.assertEquals(HttpStatus.OK, rsp.status) // <5>
        Assertions.assertNotNull(rsp.body()) // <6>

        //when:
        val packages = rsp.body()!!

        //then:
        for (name in expectedProfileNames) {
            Assertions.assertTrue(packages.stream().map(BintrayPackage::name).anyMatch { anObject: String? -> name.equals(anObject) })
        }
    }

    @Test
    fun verifyBintrayPackagesCanBeFetchedWithCompileTimeAutoGeneratedAtClient() {
        //when:
        val request: HttpRequest<Any> = HttpRequest.GET("/bintray/packages")
        val bintrayPackageStream: Flowable<BintrayPackage> = client.jsonStream(request, BintrayPackage::class.java) // <7>
        val bintrayPackages = bintrayPackageStream.blockingIterable()

        //then:
        for (name in expectedProfileNames) {
            Assertions.assertTrue(StreamSupport.stream(bintrayPackages.spliterator(), false)
                    .map(BintrayPackage::name)
                    .anyMatch { anObject: String? -> name.equals(anObject) })
        }
    }

    companion object {
        private val expectedProfileNames = Arrays.asList("base", "federation", "function", "function-aws", "service")
    }
}*/
