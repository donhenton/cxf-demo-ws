

package com.dhenton9000.cxf.demo.ws;

import com.mule_health.soa.message._1.AdmitSubject;
import com.mule_health.soa.message._1.AdmitSubjectResponse;
 import com.mule_health.soa.service.admission._1_0.Admission;
import javax.jws.WebService;


@WebService(targetNamespace = "http://www.mule-health.com/SOA/service/admission/1.0",
    portName="AdmissionPort",
    serviceName="AdmissionService",
    endpointInterface = "com.mule_health.soa.service.admission._1_0.Admission")
public class AdmissionServicePortTypeImpl implements Admission{

    @Override
    public AdmitSubjectResponse admitSubject(AdmitSubject parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
