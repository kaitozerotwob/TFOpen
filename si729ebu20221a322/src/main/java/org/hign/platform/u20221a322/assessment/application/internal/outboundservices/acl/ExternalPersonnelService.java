package org.hign.platform.u20221a322.assessment.application.internal.outboundservices.acl;

import org.hign.platform.u20221a322.personnel.interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalPersonnelService {

    private final PersonnelContextFacade personnelContextFacade;

    public ExternalPersonnelService(PersonnelContextFacade personnelContextFacade) {
        this.personnelContextFacade = personnelContextFacade;
    }

    /**
     * <p>
     *     Check if an examiner with the given national provider identifier exists using the personnel context facade
     *     {@link PersonnelContextFacade#existsExaminerByNationalIdentifierId(String)}
     * </p>
     * @param nationalProviderIdentifier String
     * @return boolean
     * @author Alex Avila Asto (u20221a322)
     */
    public boolean existsExaminerByNationalIdentifierId(String nationalProviderIdentifier) {
        return personnelContextFacade.existsExaminerByNationalIdentifierId(nationalProviderIdentifier);
    }
}
