package org.hign.platform.u20221a322.personnel.interfaces.res.transforms;

import org.hign.platform.u20221a322.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u20221a322.personnel.interfaces.res.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {

    /**
     * <p>
     *     Converts a resource to a command.
     *     Part of usage of CQRS pattern.
     * </p>
     * @param resource as {CreateExaminerResource}
     * @return command as {CreateExaminerCommand}
     * @author Alex Avila Asto (u20221a322)
     */
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}
