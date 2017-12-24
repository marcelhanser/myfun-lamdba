import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.aws.codestar.projecttemplates.configuration.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, IntegrationTestConfig.class})
@Configuration
@TestExecutionListeners(inheritListeners = false, listeners = {DependencyInjectionTestExecutionListener.class})
public class HelloControllerIntegrationTest {

    @Autowired
    private MockLambdaContext lambdaContext;

//
//    @Autowired
//    private ConfigurableWebApplicationContext applicationContext;

    @Test
    public void shouldSayHello() throws ContainerInitializationException {
        //when

        AwsProxyRequest request = new AwsProxyRequestBuilder("/articles", "GET").build();
//        AwsProxyResponse response = (AwsProxyResponse) handler.proxy(request, lambdaContext);
        //then
//        assertEquals(response.getStatusCode(), 200);
    }
}