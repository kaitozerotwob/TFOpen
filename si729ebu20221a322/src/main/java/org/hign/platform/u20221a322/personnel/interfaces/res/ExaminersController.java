package org.hign.platform.u20221a322.personnel.interfaces.res;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u20221a322.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u20221a322.personnel.interfaces.res.resources.CreateExaminerResource;
import org.hign.platform.u20221a322.personnel.interfaces.res.resources.ExaminerResource;
import org.hign.platform.u20221a322.personnel.interfaces.res.transforms.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u20221a322.personnel.interfaces.res.transforms.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/examiners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Examiner Management Endpoints")
public class ExaminersController {

    private final ExaminerCommandService examinerCommandService;

    public ExaminersController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    /**
     * <p>
     *     Create a new examiner using resources {@link CreateExaminerResource}
     *     <br>
     *     Constraints:
     *     <ul>
     *         <li>National Provider Identifier must be unique</li>
     *         <li>National Provider Identifier must be in uuid v4 format</li>
     *         <li>First name must not be null or empty</li>
     *         <li>Last name must not be null or empty</li>
     *     </ul>
     * @return resource {@link ExaminerResource} with the created examiner information
     * @param resource {@link CreateExaminerResource}
     * @throws RuntimeException if an error occurred while creating examiner
     * @throws IllegalArgumentException if the national provider identifier is not in uuid v4 format
     * @author Alex Avila Asto (u20221a322)
     */
    @Operation(summary = "Create a new examiner",
            description = "Create a new examiner with the provided information.\n National Provider Identifier must be unique and in uuid v4 format")
    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var command = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(command).orElseThrow(() -> new RuntimeException("An error occurred while creating examiner"));
        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner);
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
}
