package soapgroupb.demo;

import localhost.universities.GetUniversityRequest;
import localhost.universities.GetUniversityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class universityEndpoint {
    private static final String NAMESPACE_URI = "http://localhost/universities";

    private UniversityRepository universityRepository;

    @Autowired
    public universityEndpoint(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUniversityRequest")
    @ResponsePayload
    public GetUniversityResponse getUniversity(@RequestPayload GetUniversityRequest request) {
        GetUniversityResponse response = new GetUniversityResponse();
        response.setUniversity(universityRepository.getUniversityByName(request.getName()));

        return response;
    }

}
