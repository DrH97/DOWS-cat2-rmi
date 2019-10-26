package soapgroupb.demo.client;

import localhost.universities.GetUniversityRequest;
import localhost.universities.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UniversityClient extends WebServiceGatewaySupport {

    public GetUniversityResponse getUniversity(String name) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/universities", request);

        return response;
    }
}
