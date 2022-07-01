package organizations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/organizations")
public class OrganizationController {
    public final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("list")
    public List<Organization> getOrganizations() {
        return organizationService.list();
    }

    @PostMapping("item")
    public void add(@RequestBody Organization organization) {
        organizationService.add(organization);
    }

    @DeleteMapping("item/{organizationId}")
    public void delete(@PathVariable Long organizationId) {
        organizationService.delete(organizationId);
    }

    @PutMapping("item")
    public void update(@RequestBody Organization organization) {
        organizationService.update(organization);
    }
}
